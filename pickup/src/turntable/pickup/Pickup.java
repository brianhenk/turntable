package turntable.pickup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Pickup {

	public static final String DEFAULT_DIR_FORMAT = "/{artist}/{album}/{disknum}-{tracknum}-{song}";
	
	public Pickup() {
		
	}
	
	/**
	 * Construct album from a directory.
	 * 
	 * @param directory the directory that mp3 files are located in
	 * 
	 * @return the normalized album
	 */
	public Album constructAlbumFromDirectory(File directory) {
		File[] fileArr = directory.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name != null) {
					int indexOfDot = name.lastIndexOf('.');
					
					if(indexOfDot != -1) {
						String extension = name.substring(indexOfDot + 1);
						
						if(extension.equalsIgnoreCase("mp3")) {
							return true;	// We are mp3
						} else {
							return false;	// Not an mp3
						}
					} else {
						return false;	// Didn't have a .
					}
				} else {
					return false;	// We got null, bugger out
				}
			}
		});
		
		return this.constructAlbumFromDirectory(Arrays.asList(fileArr));
	}
	
	/**
	 * Construct album from a directory.
	 * 
	 * @param files mp3 files to process
	 * 
	 * @return the normalized album
	 */
	public Album constructAlbumFromDirectory(List<File> files) {
		Album album = new Album();
		
		for(File mp3File : files) {
			Track track = new Track(mp3File);
			album.addTrack(track);
		}
		
		return album;
	}
	
	public void writeAlbumToDirectory(File directory, Album album) {
		this.writeAlbumToDirectory(directory, album, DEFAULT_DIR_FORMAT);
	}
	
	public void writeAlbumToDirectory(File directory, Album album, String formatString) {
		
		String basePath = directory.getAbsolutePath();
		for(Track track : album.getTracks()) {
			String path = getPathFromFormatString(formatString, track);
			File newFile = new File(basePath + path + ".mp3");
			this.copyTrack(track, newFile);			
			track.setTagsFromProperties();
		}
		
	}
	
	protected void copyTrack(Track track, File newFile) {
		
		InputStream originalStream = null;
		OutputStream newStream = null;
		try {
			newFile.delete();
			
			File dirs = new File(newFile.getAbsolutePath().substring(0, newFile.getAbsolutePath().lastIndexOf('\\')));
			if(!dirs.exists()) {
				dirs.mkdirs();
			}
			newFile.createNewFile();
			
			originalStream = new FileInputStream(track.getFile());
			newStream = new FileOutputStream(newFile);
			
			byte[] buffer = new byte[1024];
			int i = 0;
			while((i = originalStream.read(buffer)) != -1) {
				newStream.write(buffer, 0, i);
			}
			
			track.setFile(newFile);
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				originalStream.close();
				newStream.close();
			} catch(IOException ex) { }
		}
	}
	
	protected String getPathFromFormatString(String formatString, Track track) {
		
		String newPath = new String(formatString);
		
		final String artistPlaceholder = "{artist}";
		if(formatString.contains(artistPlaceholder)) {
			if(track.getAlbum() != null && track.getAlbum().getArtist() != null && !track.getAlbum().getArtist().isEmpty()) {
				newPath = newPath.replace(artistPlaceholder, makeSafe(track.getAlbum().getArtist()));
			} else if(track.getArtist() != null && !track.getArtist().isEmpty()) {
				newPath = newPath.replace(artistPlaceholder, makeSafe(track.getArtist()));
			} else {
				newPath = newPath.replace(artistPlaceholder, makeSafe("Unknown Artist"));
			}
		}
		
		final String albumPlaceholder = "{album}";
		if(formatString.contains(albumPlaceholder)) {
			if(track.getAlbum() != null && track.getAlbum().getName() != null && !track.getAlbum().getName().isEmpty()) {
				newPath = newPath.replace(albumPlaceholder, makeSafe(track.getAlbum().getName()));
			} else {
				newPath = newPath.replace(albumPlaceholder, "Unknown Album");
			}
		}
		
		final String diskPlaceholder = "{disknum}";
		if(formatString.contains(diskPlaceholder)) {
			if(track.getDiskNum() != -1) {
				newPath = newPath.replace(diskPlaceholder, makeSafe(String.format("%02d", track.getDiskNum())));
			} else {
				newPath = newPath.replace(diskPlaceholder, makeSafe("01"));
			}
		}
		
		final String trackPlaceholder = "{tracknum}";
		if(formatString.contains(trackPlaceholder)) {
			if(track.getTrackNum() != -1) {
				newPath = newPath.replace(trackPlaceholder, makeSafe(String.format("%02d", track.getTrackNum())));
			} else {
				newPath = newPath.replace(trackPlaceholder, makeSafe("00"));
			}
		}
		
		final String songPlaceholder = "{song}";
		if(formatString.contains(songPlaceholder)) {
			if(track.getName() != null && !track.getName().isEmpty()) {
				newPath = newPath.replace(songPlaceholder, makeSafe(track.getName()));
			} else {
				newPath = newPath.replace(songPlaceholder, makeSafe("Unknown Track"));
			}
		}
		
		return newPath;
	}
	
	public String makeSafe(String unsafe) {
		final String replacement = "";
		String safe = unsafe.replaceAll("(\\?|\\\\|\\*|:|>|<|/|\\.|\")", replacement);
		return safe;
	}
	
}
