package turntable.pickup;

import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TestTrack {

	private File sourceDir;
	
	@Before
	public void setUp() {
		this.sourceDir = new File(System.getProperty("test.album.dir"));
	}
	
	@Test
	public void testInitializeFromFile() {
		File f = new File(this.sourceDir, "01 Capricorn (A Brand New Name).mp3");
		Album album = new Album();
		Track track = new Track(f);
		album.addTrack(track);
		
		Assert.assertEquals("30 Seconds to Mars", album.getArtist());
	}
	
	@Test
	public void testInitializeFromFile2() {
		File f = new File(this.sourceDir, "The xx_01_Intro.mp3");
		Album album = new Album();
		Track track = new Track(f);
		album.addTrack(track);
	}

}
