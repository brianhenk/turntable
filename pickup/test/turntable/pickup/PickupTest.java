package turntable.pickup;

import java.io.File;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PickupTest {

	private File sourceDir;
	private File outDir;
	
	@Before
	public void setUp() {
		this.sourceDir = new File(System.getProperty("test.album.dir"));
		this.outDir = new File(this.sourceDir, "testoutput");
		
		if(!this.outDir.exists()) {
			this.outDir.mkdir();
		}
	}
	
	@After
	public void tearDown() {
		this.outDir.delete();
	}
	
	@Test
	public void testConstructAlbumFromDirectoryFile() {
		Pickup pickup = new Pickup();
		Album album = pickup.constructAlbumFromDirectory(this.sourceDir);
		
		Assert.assertEquals("30 Seconds to Mars", album.getArtist());
	}

	@Test
	public void testWriteAlbumToDirectory() {		
		Pickup pickup = new Pickup();
		Album album = pickup.constructAlbumFromDirectory(this.sourceDir);
		album.setGenre("test");
		pickup.writeAlbumToDirectory(this.outDir, album);
	}
	
	@Test
	public void testGetPathFromFormatString() {
		Track track = new Track(null);
		Album album = new Album();
		track.setAlbum(album);		
		
		Pickup pickup = new Pickup();
		String result = null;
		
		result = pickup.getPathFromFormatString(Pickup.DEFAULT_DIR_FORMAT, track);
		Assert.assertEquals("/Unknown Artist/Unknown Album/01-00-Unknown Track", result);
		
		
		track.setName("track");
		track.setDiskNum(1);
		track.setTrackNum(1);
		
		result = pickup.getPathFromFormatString(Pickup.DEFAULT_DIR_FORMAT, track);
		Assert.assertEquals("/Unknown Artist/Unknown Album/01-01-track", result);
		
		track.setArtist("trackArtist");
		
		result = pickup.getPathFromFormatString(Pickup.DEFAULT_DIR_FORMAT, track);
		Assert.assertEquals("/trackArtist/Unknown Album/01-01-track", result);
		
		album.setArtist("albumArtist");
		album.setName("albumName");
		
		result = pickup.getPathFromFormatString(Pickup.DEFAULT_DIR_FORMAT, track);
		Assert.assertEquals("/albumArtist/albumName/01-01-track", result);
		
		track.setName("How \"are\": you? <excellent>");
		
		result = pickup.getPathFromFormatString(Pickup.DEFAULT_DIR_FORMAT, track);
		Assert.assertEquals("/albumArtist/albumName/01-01-How are you excellent", result);
	}

}
