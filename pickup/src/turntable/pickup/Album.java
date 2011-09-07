package turntable.pickup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album {

	private String year;
	private String name;
	private String artist;
	private String genre;
	private int numTracks;
	
	Map<String, Integer> yearMap;
	Map<String, Integer> nameMap;
	Map<String, Integer> artistMap;
	Map<String, Integer> genreMap;
	Map<Integer, Integer> numTracksMap;
	
	private List<Track> tracks;
	
	public Album() {
		this.tracks = new ArrayList<Track>();
		this.numTracks = -1;
		
		this.yearMap = new HashMap<String, Integer>();
		this.nameMap = new HashMap<String, Integer>();
		this.artistMap = new HashMap<String, Integer>();
		this.genreMap = new HashMap<String, Integer>();
		this.numTracksMap = new HashMap<Integer, Integer>();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public void setPossibleYear(String year) {
		this.setYear(this.handlePossibleSet(year, this.yearMap));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPossibleName(String name) {
		this.setName(this.handlePossibleSet(name, this.nameMap));
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setPossibleArtist(String artist) {
		this.setArtist(this.handlePossibleSet(artist, this.artistMap));
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setPossibleGenre(String genre) {
		this.setGenre(this.handlePossibleSet(genre, this.genreMap));
	}

	public String getGenre() {
		return genre;
	}

	public int getNumTracks() {
		return numTracks;
	}

	public void setNumTracks(int numTracks) {
		this.numTracks = numTracks;
	}
	
	public void setPossibleNumTracks(int numTracks) {
		// Ignore if not set
		if(numTracks != -1) {
			this.setNumTracks(this.handlePossibleSet(numTracks, this.numTracksMap));
		}
	}
	
	public void addTrack(Track track) {
		this.tracks.add(track);
		track.setAlbum(this);
		track.initializeFromFile();
	}
	
	public void removeTrack(Track track) {
		this.tracks.remove(track);
		track.setAlbum(null);
	}
	
	public List<Track> getTracks() {
		return this.tracks;
	}
	
	protected <T> T handlePossibleSet(T possibleValue, Map<T, Integer> map) {
		if(map.containsKey(possibleValue)) {
			map.put(possibleValue, map.get(possibleValue) + 1);
		} else {
			map.put(possibleValue, 1);
		}
		
		int max = 0;
		T value = null;
		for(T attemptedValue : map.keySet()) {
			if(map.get(attemptedValue) > max) {
				max = map.get(attemptedValue);
				value = attemptedValue;
			}
		}
		
		return value;
	}
}
