package turntable.stylus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import turntable.pickup.Album;
import turntable.pickup.Pickup;
import turntable.pickup.Track;

public class StylusFrame extends GeneratedStylusFrame {

	private static final long serialVersionUID = 1L;

	protected Pickup pickup;
	protected Album album;
	protected Track currentTrack;
	
	public StylusFrame() {
		super();
		this.pickup = new Pickup();
		
		setLoaded(false);
		addLoadButtonListener();
		addExecuteButtonListener();
		addTrackListListener();
	}
	
	public void display() {
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
	}
	
	protected void loadButtonClicked() {
		album = pickup.constructAlbumFromDirectory(new File(fromDirField.getText()));
		
		for(Track track : album.getTracks()) {
			trackListModel.addElement(track);
		}
		
		albumNameField.setText(this.album.getName());
		albumArtistField.setText(this.album.getArtist());
		albumGenreFeild.setText(this.album.getGenre());
		albumYearField.setText(this.album.getYear());
		albumTotalTracksField.setText(Integer.toString(this.album.getNumTracks()));
		
		setLoaded(true);
	}
	
	protected void execButtonClicked() {
		saveCurrentTrackInfo();
		saveCurrentAlbumInfo();
		
		pickup.writeAlbumToDirectory(new File(outDirField.getText()), album);
		
		setLoaded(false);
		this.album = null;
		this.currentTrack = null;
	}
	
	protected void trackSelectionChanged(int newIndex) {
		Track newTrack = (Track)this.trackListModel.get(newIndex);
		
		saveCurrentTrackInfo();
		this.currentTrack = newTrack;
		
		trackNameField.setText(this.currentTrack.getName());
		trackArtistField.setText(this.currentTrack.getArtist());
		trackNumberField.setText(Integer.toString(this.currentTrack.getTrackNum()));
		trackDiskNumberField.setText(Integer.toString(this.currentTrack.getDiskNum()));
	}
	
	protected void saveCurrentTrackInfo() {
		if(this.currentTrack != null) {
			this.currentTrack.setName(getStringFieldValue(trackNameField, trackNameCheck));
			this.currentTrack.setArtist(getStringFieldValue(trackArtistField, trackArtistCheck));
			this.currentTrack.setTrackNum(getIntFieldValue(trackNumberField, trackNumberCheck));
			this.currentTrack.setDiskNum(getIntFieldValue(trackDiskNumberField, trackDiskNumberCheck));
		}
	}
	
	protected void saveCurrentAlbumInfo() {
		if(this.album != null) {
			this.album.setName(getStringFieldValue(albumNameField, albumNameCheck));
			this.album.setArtist(getStringFieldValue(albumArtistField, albumArtistCheck));
			this.album.setGenre(getStringFieldValue(albumGenreFeild, albumGenreCheck));
			this.album.setYear(getStringFieldValue(albumYearField, albumYearCheck));
			this.album.setNumTracks(getIntFieldValue(albumTotalTracksField, albumTotalTracksCheck));
		}
	}
	
	private String getStringFieldValue(JTextField field, JCheckBox checkbox) {
		String retVal;
		if(checkbox.isSelected()) {
			retVal = field.getText();
		} else {
			retVal = null;
		}
		checkbox.setSelected(true);
		return retVal;
	}
	
	private int getIntFieldValue(JTextField field, JCheckBox checkbox) {
		String textValue = getStringFieldValue(field, checkbox);
		if(textValue != null) {
			return Integer.parseInt(textValue);
		} else {
			return -1;
		}
	}
	
	protected void setLoaded(boolean loaded) {
		this.loadFromDirButton.setEnabled(!loaded);
		this.fromDirField.setEnabled(!loaded);
		
		this.outDirField.setEnabled(loaded);
		this.executeButton.setEnabled(loaded);
		
		if(!loaded) {
			this.trackListModel.clear();
		}
		this.trackList.setEnabled(loaded);
		
		this.trackArtistCheck.setEnabled(loaded);
		this.trackArtistField.setEnabled(loaded);
		this.trackNameCheck.setEnabled(loaded);
		this.trackNameField.setEnabled(loaded);
		this.trackNumberCheck.setEnabled(loaded);
		this.trackNumberField.setEnabled(loaded);
		this.trackDiskNumberCheck.setEnabled(loaded);
		this.trackDiskNumberField.setEnabled(loaded);
		
		this.albumNameCheck.setEnabled(loaded);
		this.albumNameField.setEnabled(loaded);
		this.albumArtistCheck.setEnabled(loaded);
		this.albumArtistField.setEnabled(loaded);
		this.albumGenreCheck.setEnabled(loaded);
		this.albumGenreFeild.setEnabled(loaded);
		this.albumYearCheck.setEnabled(loaded);
		this.albumYearField.setEnabled(loaded);
		this.albumTotalTracksCheck.setEnabled(loaded);
		this.albumTotalTracksField.setEnabled(loaded);
	}
	
	protected void addLoadButtonListener() {
		this.loadFromDirButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadButtonClicked();
			}
		});
	}
	
	protected void addExecuteButtonListener() {
		this.executeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execButtonClicked();
			}
		});
	}
	
	protected void addTrackListListener() {
		this.trackList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					trackSelectionChanged(((JList)e.getSource()).getSelectedIndex());
				}
			}
		});
	}

}
