package turntable.pickup;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;

public class Track {

	private File file;
	private String name;
	private String artist;
	private int trackNum;
	private int diskNum;
	private Album album;
	
	public Track(File file) {
		this.setFile(file);
		this.trackNum = -1;
		this.diskNum = -1;		
	}
	
	public void initializeFromFile() {
		try {
			MP3File mp3File = (MP3File)AudioFileIO.read(this.getFile());
						
			if(mp3File.hasID3v2Tag()) {
				ID3v24Tag tag = mp3File.getID3v2TagAsv24();
				
				this.setName(readStringFrame(tag, FieldKey.TITLE));
				this.setArtist(readStringFrame(tag, FieldKey.ARTIST));
				this.setTrackNum(readIntFrame(tag, FieldKey.TRACK));
				this.setDiskNum(readIntFrame(tag, FieldKey.DISC_NO));
				
				this.getAlbum().setPossibleYear(readStringFrame(tag, FieldKey.YEAR));
				this.getAlbum().setPossibleName(readStringFrame(tag, FieldKey.ALBUM));
				this.getAlbum().setPossibleArtist(readStringFrame(tag, FieldKey.ALBUM_ARTIST));
				this.getAlbum().setPossibleGenre(readStringFrame(tag, FieldKey.GENRE));
				this.getAlbum().setPossibleNumTracks(readIntFrame(tag, FieldKey.TRACK_TOTAL));
				
			} else if(mp3File.hasID3v1Tag()) {
				ID3v1Tag tag = (ID3v1Tag)mp3File.getTag();
				
				this.setName(readStringFrame(tag, FieldKey.TITLE));
				this.setArtist(readStringFrame(tag, FieldKey.ARTIST));
				this.setTrackNum(readIntFrame(tag, FieldKey.TRACK));
				this.setDiskNum(1);
				
				this.getAlbum().setPossibleYear(readStringFrame(tag, FieldKey.YEAR));
				this.getAlbum().setPossibleName(readStringFrame(tag, FieldKey.ALBUM));
				this.getAlbum().setPossibleGenre(readStringFrame(tag, FieldKey.GENRE));
				this.getAlbum().setPossibleNumTracks(0);
			}
			
		} catch(InvalidAudioFrameException ex) {
			ex.printStackTrace();
		} catch(ReadOnlyFileException ex) {
			ex.printStackTrace();
		} catch (CannotReadException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (TagException ex) {
			ex.printStackTrace();
		}
	}
	
	public void setTagsFromProperties() {
		try {
			MP3File mp3File = (MP3File)AudioFileIO.read(this.getFile());
			
			if(this.getDiskNum() == -1) {
				this.setDiskNum(1);
			}
			
			ID3v24Tag tag24 = new ID3v24Tag();
			ID3v11Tag tag11 = new ID3v11Tag();
			
			// Track stuff
			this.writeIfSet(tag24, FieldKey.TITLE, this.getName());
			this.writeIfSet(tag11, FieldKey.TITLE, this.getName());
			
			this.writeIfSet(tag24, FieldKey.ARTIST, this.getArtist());
			this.writeIfSet(tag11, FieldKey.ARTIST, this.getArtist());
			
			this.writeIfSet(tag24, FieldKey.TRACK, this.getTrackNum());
			this.writeIfSet(tag11, FieldKey.TRACK, this.getTrackNum());
			
			this.writeIfSet(tag24, FieldKey.DISC_NO, this.getDiskNum());
			
			// Album Stuff
			this.writeIfSet(tag24, FieldKey.YEAR, this.getAlbum().getYear());
			this.writeIfSet(tag11, FieldKey.YEAR, this.getAlbum().getYear());
			
			this.writeIfSet(tag24, FieldKey.ALBUM, this.getAlbum().getName());
			this.writeIfSet(tag11, FieldKey.ALBUM, this.getAlbum().getName());
			
			this.writeIfSet(tag24, FieldKey.ALBUM_ARTIST, this.getAlbum().getArtist());
			
			this.writeIfSet(tag24, FieldKey.GENRE, this.getAlbum().getGenre());
			this.writeIfSet(tag11, FieldKey.GENRE, this.getAlbum().getGenre());
			
			this.writeIfSet(tag24, FieldKey.TRACK_TOTAL, this.getAlbum().getNumTracks());
			
			mp3File.setID3v1Tag(tag11);
			mp3File.setID3v2Tag(tag24);
			
			mp3File.commit();
			
		} catch (CannotWriteException ex) {
			ex.printStackTrace();
		} catch (CannotReadException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (TagException ex) {
			ex.printStackTrace();
		} catch (ReadOnlyFileException ex) {
			ex.printStackTrace();
		} catch (InvalidAudioFrameException ex) {
			ex.printStackTrace();
		}
	}
	
	private String readStringFrame(Tag tag, FieldKey key) {
		String value = "";
		try {
			value = tag.getFirst(key);
		} catch(Exception ex) { }
		return value;
	}
	
	private int readIntFrame(Tag tag, FieldKey key) {
		String stringVal = readStringFrame(tag, key);
		
		if(stringVal != null && !stringVal.isEmpty()) {
			int value = -1;
			try {
				value = Integer.parseInt(stringVal);
			} catch (NumberFormatException ex) {
				// Do nothing
			}
			return value;
		} else {
			return -1;
		}
	}
	
	private void writeIfSet(Tag tag, FieldKey key, int value) throws FieldDataInvalidException {
		if(value != -1) {
			writeIfSet(tag, key, Integer.toString(value));
		}
	}
	
	private void writeIfSet(Tag tag, FieldKey key, String value) throws FieldDataInvalidException {
		if(value != null && !value.isEmpty()) {
			tag.setField(key, value);
		}
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(int trackNum) {
		this.trackNum = trackNum;
	}

	public int getDiskNum() {
		return diskNum;
	}

	public void setDiskNum(int diskNum) {
		this.diskNum = diskNum;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public String toString() {
		return this.file.getName();
	}
	
}
