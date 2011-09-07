package turntable.stylus;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;

public class GeneratedStylusFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	protected JPanel jContentPane = null;
	protected JPanel fromDirPanel = null;
	protected JLabel fromDirLabel = null;
	protected JTextField fromDirField = null;
	protected JButton loadFromDirButton = null;
	protected JPanel outDirPanel = null;
	protected JLabel outDirLabel = null;
	protected JTextField outDirField = null;
	protected JButton executeButton = null;
	protected JTabbedPane infoPane = null;
	protected JPanel trackPanel = null;
	protected JPanel albumPanel = null;
	protected JLabel albumNameLabel = null;
	protected JTextField albumNameField = null;
	protected JLabel albumArtistLabel = null;
	protected JTextField albumArtistField = null;
	protected JLabel albumYearLabel = null;
	protected JTextField albumYearField = null;
	protected JCheckBox albumNameCheck = null;
	protected JCheckBox albumArtistCheck = null;
	protected JCheckBox albumYearCheck = null;
	protected JLabel albumTotalTracksLabel = null;
	protected JTextField albumTotalTracksField = null;
	protected JCheckBox albumTotalTracksCheck = null;
	protected JLabel albumGenreLabel = null;
	protected JTextField albumGenreFeild = null;
	protected JCheckBox albumGenreCheck = null;
	protected JLabel trackNameLabel = null;
	protected JTextField trackNameField = null;
	protected JCheckBox trackNameCheck = null;
	protected JLabel trackArtistLabel = null;
	protected JTextField trackArtistField = null;
	protected JCheckBox trackArtistCheck = null;
	protected JLabel trackNumberLabel = null;
	protected JLabel trackDiskNumberLabel = null;
	protected JTextField trackNumberField = null;
	protected JTextField trackDiskNumberField = null;
	protected JCheckBox trackNumberCheck = null;
	protected JCheckBox trackDiskNumberCheck = null;
	protected JPanel trackListPanel = null;
	protected JList trackList = null;
	
	protected DefaultListModel trackListModel = new DefaultListModel();
	
	/**
	 * This is the default constructor
	 */
	public GeneratedStylusFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(531, 412);
		this.setContentPane(getJContentPane());
		this.setTitle("Turntable");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getFromDirPanel(), BorderLayout.NORTH);
			jContentPane.add(getOutDirPanel(), BorderLayout.SOUTH);
			jContentPane.add(getInfoPane(), BorderLayout.EAST);
			jContentPane.add(getTrackListPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes fromDirPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getFromDirPanel() {
		if (fromDirPanel == null) {
			fromDirLabel = new JLabel();
			fromDirLabel.setText("Source Directory");
			fromDirPanel = new JPanel();
			fromDirPanel.setLayout(new FlowLayout());
			fromDirPanel.add(fromDirLabel, null);
			fromDirPanel.add(getFromDirField(), null);
			fromDirPanel.add(getLoadFromDirButton(), null);
		}
		return fromDirPanel;
	}

	/**
	 * This method initializes fromDirField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFromDirField() {
		if (fromDirField == null) {
			fromDirField = new JTextField();
			fromDirField.setPreferredSize(new Dimension(250, 20));
		}
		return fromDirField;
	}

	/**
	 * This method initializes loadFromDirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLoadFromDirButton() {
		if (loadFromDirButton == null) {
			loadFromDirButton = new JButton();
			loadFromDirButton.setText("Load");
		}
		return loadFromDirButton;
	}

	/**
	 * This method initializes outDirPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getOutDirPanel() {
		if (outDirPanel == null) {
			outDirLabel = new JLabel();
			outDirLabel.setText("Base Output Directory");
			outDirPanel = new JPanel();
			outDirPanel.setLayout(new FlowLayout());
			outDirPanel.add(outDirLabel, null);
			outDirPanel.add(getOutDirField(), null);
			outDirPanel.add(getExecuteButton(), null);
		}
		return outDirPanel;
	}

	/**
	 * This method initializes outDirField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOutDirField() {
		if (outDirField == null) {
			outDirField = new JTextField();
			outDirField.setPreferredSize(new Dimension(250, 20));
		}
		return outDirField;
	}

	/**
	 * This method initializes executeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExecuteButton() {
		if (executeButton == null) {
			executeButton = new JButton();
			executeButton.setText("Save");
		}
		return executeButton;
	}

	/**
	 * This method initializes infoPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getInfoPane() {
		if (infoPane == null) {
			infoPane = new JTabbedPane();
			infoPane.setPreferredSize(new Dimension(300, 200));
			infoPane.addTab("Track", null, getTrackPanel(), null);
			infoPane.addTab("Album", null, getAlbumPanel(), null);
		}
		return infoPane;
	}

	/**
	 * This method initializes trackPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getTrackPanel() {
		if (trackPanel == null) {
			
			trackPanel = new JPanel();
			trackPanel.setLayout(new GridBagLayout());
			
			final int xMargin = 5;
			final int yMargin = 5;
			final Insets padding = new Insets(yMargin, xMargin, yMargin, xMargin);
			
			// Track Name Label
			trackNameLabel = new JLabel();
			trackNameLabel.setText("Name");
			GridBagConstraints gridBagConstraintsTrackNameLabel = new GridBagConstraints();
			gridBagConstraintsTrackNameLabel.gridx = 0;
			gridBagConstraintsTrackNameLabel.gridy = 0;
			gridBagConstraintsTrackNameLabel.anchor = GridBagConstraints.EAST;
			trackPanel.add(trackNameLabel, gridBagConstraintsTrackNameLabel);
			
			// Track Name Field
			GridBagConstraints gridBagConstraintsTrackNameField = new GridBagConstraints();
			gridBagConstraintsTrackNameField.fill = GridBagConstraints.BOTH;
			gridBagConstraintsTrackNameField.insets = padding;
			gridBagConstraintsTrackNameField.gridx = 1;
			gridBagConstraintsTrackNameField.gridy = 0;
			gridBagConstraintsTrackNameField.weightx = 1.0;
			trackPanel.add(getTrackNameField(), gridBagConstraintsTrackNameField);
			
			// Track Name Checkbox
			GridBagConstraints gridBagConstraintsTrackNameCheck = new GridBagConstraints();
			gridBagConstraintsTrackNameCheck.gridx = 2;
			gridBagConstraintsTrackNameCheck.gridy = 0;
			trackPanel.add(getTrackNameCheck(), gridBagConstraintsTrackNameCheck);
			
			// Track Artist Label
			trackArtistLabel = new JLabel();
			trackArtistLabel.setText("Artist");
			GridBagConstraints gridBagConstraintsTrackArtistLabel = new GridBagConstraints();
			gridBagConstraintsTrackArtistLabel.gridx = 0;
			gridBagConstraintsTrackArtistLabel.gridy = 1;
			gridBagConstraintsTrackArtistLabel.anchor = GridBagConstraints.EAST;
			trackPanel.add(trackArtistLabel, gridBagConstraintsTrackArtistLabel);
			
			// Track Artist Field
			GridBagConstraints gridBagConstraintsTrackArtistField = new GridBagConstraints();
			gridBagConstraintsTrackArtistField.fill = GridBagConstraints.BOTH;
			gridBagConstraintsTrackArtistField.insets = padding;
			gridBagConstraintsTrackArtistField.gridx = 1;
			gridBagConstraintsTrackArtistField.gridy = 1;
			trackPanel.add(getTrackArtistField(), gridBagConstraintsTrackArtistField);
			
			// Track Artist Checkbox
			GridBagConstraints gridBagConstraintsTrackArtistCheck = new GridBagConstraints();
			gridBagConstraintsTrackArtistCheck.gridx = 2;
			gridBagConstraintsTrackArtistCheck.gridy = 1;
			trackPanel.add(getTrackArtistCheck(), gridBagConstraintsTrackArtistCheck);
			
			// Track Number Label
			trackNumberLabel = new JLabel();
			trackNumberLabel.setText("Track Number");
			GridBagConstraints gridBagConstraintsTrackNumberLabel = new GridBagConstraints();
			gridBagConstraintsTrackNumberLabel.gridx = 0;
			gridBagConstraintsTrackNumberLabel.gridy = 2;
			gridBagConstraintsTrackNumberLabel.anchor = GridBagConstraints.EAST;
			trackPanel.add(trackNumberLabel, gridBagConstraintsTrackNumberLabel);
			
			// Track Number Field
			GridBagConstraints gridBagConstraintsTrackNumberField = new GridBagConstraints();
			gridBagConstraintsTrackNumberField.fill = GridBagConstraints.VERTICAL;
			gridBagConstraintsTrackNumberField.insets = padding;
			gridBagConstraintsTrackNumberField.gridx = 1;
			gridBagConstraintsTrackNumberField.gridy = 2;
			gridBagConstraintsTrackNumberField.anchor = GridBagConstraints.WEST;
			trackPanel.add(getTrackNumberField(), gridBagConstraintsTrackNumberField);
			
			// Track Number Check
			GridBagConstraints gridBagConstraintsTrackNumberCheck = new GridBagConstraints();
			gridBagConstraintsTrackNumberCheck.gridx = 2;
			gridBagConstraintsTrackNumberCheck.gridy = 2;
			trackPanel.add(getTrackNumberCheck(), gridBagConstraintsTrackNumberCheck);
			
			// Track Disk Number Label
			trackDiskNumberLabel = new JLabel();
			trackDiskNumberLabel.setText("Disk Number");
			GridBagConstraints gridBagConstraintsTrackDiskNumberLabel = new GridBagConstraints();
			gridBagConstraintsTrackDiskNumberLabel.gridx = 0;
			gridBagConstraintsTrackDiskNumberLabel.gridy = 3;
			gridBagConstraintsTrackDiskNumberLabel.anchor = GridBagConstraints.EAST;
			trackPanel.add(trackDiskNumberLabel, gridBagConstraintsTrackDiskNumberLabel);
			
			// Track Disk Number Field
			GridBagConstraints gridBagConstraintsTrackDiskNumberField = new GridBagConstraints();
			gridBagConstraintsTrackDiskNumberField.fill = GridBagConstraints.VERTICAL;
			gridBagConstraintsTrackDiskNumberField.insets = padding;
			gridBagConstraintsTrackDiskNumberField.gridx = 1;
			gridBagConstraintsTrackDiskNumberField.gridy = 3;
			gridBagConstraintsTrackDiskNumberField.anchor = GridBagConstraints.WEST;
			trackPanel.add(getTrackDiskNumberField(), gridBagConstraintsTrackDiskNumberField);
			
			// Track Disk Number Check
			GridBagConstraints gridBagConstraintsTrackDiskNumberCheck = new GridBagConstraints();
			gridBagConstraintsTrackDiskNumberCheck.gridx = 2;
			gridBagConstraintsTrackDiskNumberCheck.gridy = 3;
			trackPanel.add(getTrackDiskNumberCheck(), gridBagConstraintsTrackDiskNumberCheck);
		}
		return trackPanel;
	}

	/**
	 * This method initializes albumPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getAlbumPanel() {
		if (albumPanel == null) {
			
			albumPanel = new JPanel();
			albumPanel.setLayout(new GridBagLayout());
			
			final int xMargin = 5;
			final int yMargin = 5;
			final Insets padding = new Insets(yMargin, xMargin, yMargin, xMargin);
			
			// Album Name Label
			albumNameLabel = new JLabel();
			albumNameLabel.setText("Name");
			GridBagConstraints gridBagConstraintsAlbumNameLabel = new GridBagConstraints();
			gridBagConstraintsAlbumNameLabel.gridx = 0;
			gridBagConstraintsAlbumNameLabel.gridy = 0;
			gridBagConstraintsAlbumNameLabel.anchor = GridBagConstraints.EAST;
			albumPanel.add(albumNameLabel, gridBagConstraintsAlbumNameLabel);
			
			// Album Name Field
			GridBagConstraints gridBagConstraintsAlbumNameField = new GridBagConstraints();
			gridBagConstraintsAlbumNameField.fill = GridBagConstraints.BOTH;
			gridBagConstraintsAlbumNameField.insets = padding;
			gridBagConstraintsAlbumNameField.gridx = 1;
			gridBagConstraintsAlbumNameField.gridy = 0;
			gridBagConstraintsAlbumNameField.weightx = 1.0;
			albumPanel.add(getAlbumNameField(), gridBagConstraintsAlbumNameField);
			
			// Album Name Checkbox
			GridBagConstraints gridBagConstraintsAlbumNameCheck = new GridBagConstraints();
			gridBagConstraintsAlbumNameCheck.gridx = 2;
			gridBagConstraintsAlbumNameCheck.gridy = 0;
			albumPanel.add(getAlbumNameCheck(), gridBagConstraintsAlbumNameCheck);
			
			// Album Artist Label
			albumArtistLabel = new JLabel();
			albumArtistLabel.setText("Artist");
			GridBagConstraints gridBagConstraintsAlbumArtistLabel = new GridBagConstraints();
			gridBagConstraintsAlbumArtistLabel.gridx = 0;
			gridBagConstraintsAlbumArtistLabel.gridy = 1;
			gridBagConstraintsAlbumArtistLabel.anchor = GridBagConstraints.EAST;
			albumPanel.add(albumArtistLabel, gridBagConstraintsAlbumArtistLabel);
			
			// Album Artist Field
			GridBagConstraints gridBagConstraintsAlbumArtistField = new GridBagConstraints();
			gridBagConstraintsAlbumArtistField.fill = GridBagConstraints.BOTH;
			gridBagConstraintsAlbumArtistField.insets = padding;
			gridBagConstraintsAlbumArtistField.gridx = 1;
			gridBagConstraintsAlbumArtistField.gridy = 1;
			albumPanel.add(getAlbumArtistField(), gridBagConstraintsAlbumArtistField);
			
			// Album Artist Checkbox
			GridBagConstraints gridBagConstraintsAlbumArtistCheckbox = new GridBagConstraints();
			gridBagConstraintsAlbumArtistCheckbox.gridx = 2;
			gridBagConstraintsAlbumArtistCheckbox.gridy = 1;
			albumPanel.add(getAlbumArtistCheck(), gridBagConstraintsAlbumArtistCheckbox);
			
			// Album Genre Label
			albumGenreLabel = new JLabel();
			albumGenreLabel.setText("Genre");
			GridBagConstraints gridBagConstraintsAlbumGenreLabel = new GridBagConstraints();
			gridBagConstraintsAlbumGenreLabel.gridx = 0;
			gridBagConstraintsAlbumGenreLabel.gridy = 2;
			gridBagConstraintsAlbumGenreLabel.anchor = GridBagConstraints.EAST;
			albumPanel.add(albumGenreLabel, gridBagConstraintsAlbumGenreLabel);
			
			// Album Genre Field
			GridBagConstraints gridBagConstraintsAlbumGenreField = new GridBagConstraints();
			gridBagConstraintsAlbumGenreField.fill = GridBagConstraints.BOTH;
			gridBagConstraintsAlbumGenreField.insets = padding;
			gridBagConstraintsAlbumGenreField.gridx = 1;
			gridBagConstraintsAlbumGenreField.gridy = 2;
			albumPanel.add(getAlbumGenreFeild(), gridBagConstraintsAlbumGenreField);
			
			// Album Genre Checkbox
			GridBagConstraints gridBagConstraintsAlbumGenreCheck = new GridBagConstraints();
			gridBagConstraintsAlbumGenreCheck.gridx = 2;
			gridBagConstraintsAlbumGenreCheck.gridy = 2;
			albumPanel.add(getAlbumGenreCheck(), gridBagConstraintsAlbumGenreCheck);
			
			// Album Year Label
			albumYearLabel = new JLabel();
			albumYearLabel.setText("Year");
			GridBagConstraints gridBagConstraintsAlbumYearLabel = new GridBagConstraints();
			gridBagConstraintsAlbumYearLabel.gridx = 0;
			gridBagConstraintsAlbumYearLabel.gridy = 3;
			gridBagConstraintsAlbumYearLabel.anchor = GridBagConstraints.EAST;
			albumPanel.add(albumYearLabel, gridBagConstraintsAlbumYearLabel);
			
			// Album Year Field
			GridBagConstraints gridBagConstraintsAlbumYearField = new GridBagConstraints();
			gridBagConstraintsAlbumYearField.fill = GridBagConstraints.VERTICAL;
			gridBagConstraintsAlbumYearField.insets = padding;
			gridBagConstraintsAlbumYearField.gridx = 1;
			gridBagConstraintsAlbumYearField.gridy = 3;
			gridBagConstraintsAlbumYearField.anchor = GridBagConstraints.WEST;
			albumPanel.add(getAlbumYearField(), gridBagConstraintsAlbumYearField);
			
			// Album Year Checkbox
			GridBagConstraints gridBagConstraintsAlbumYearCheck = new GridBagConstraints();
			gridBagConstraintsAlbumYearCheck.gridx = 2;
			gridBagConstraintsAlbumYearCheck.gridy = 3;
			albumPanel.add(getAlbumYearCheck(), gridBagConstraintsAlbumYearCheck);
			
			// Album Total Tracks Label
			albumTotalTracksLabel = new JLabel();
			albumTotalTracksLabel.setText("Total Tracks");
			GridBagConstraints gridBagConstraintsAlbumTotalTracksLabel = new GridBagConstraints();
			gridBagConstraintsAlbumTotalTracksLabel.gridx = 0;
			gridBagConstraintsAlbumTotalTracksLabel.gridy = 4;
			gridBagConstraintsAlbumTotalTracksLabel.anchor = GridBagConstraints.EAST;
			albumPanel.add(albumTotalTracksLabel, gridBagConstraintsAlbumTotalTracksLabel);
			
			// Album Total Tracks Field
			GridBagConstraints gridBagConstraintsAlbumTotalTracksField = new GridBagConstraints();
			gridBagConstraintsAlbumTotalTracksField.fill = GridBagConstraints.VERTICAL;
			gridBagConstraintsAlbumTotalTracksField.insets = padding;
			gridBagConstraintsAlbumTotalTracksField.gridx = 1;
			gridBagConstraintsAlbumTotalTracksField.gridy = 4;
			gridBagConstraintsAlbumTotalTracksField.anchor = GridBagConstraints.WEST;
			albumPanel.add(getAlbumTotalTracksField(), gridBagConstraintsAlbumTotalTracksField);
			
			// Album Total Tracks Checkbox
			GridBagConstraints gridBagConstraintsAlbumTotalTracksCheck = new GridBagConstraints();
			gridBagConstraintsAlbumTotalTracksCheck.gridx = 2;
			gridBagConstraintsAlbumTotalTracksCheck.gridy = 4;
			albumPanel.add(getAlbumTotalTracksCheck(), gridBagConstraintsAlbumTotalTracksCheck);
		}
		return albumPanel;
	}

	/**
	 * This method initializes albumNameField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlbumNameField() {
		if (albumNameField == null) {
			albumNameField = new JTextField();
			albumNameField.setMinimumSize(new Dimension(200, 20));
			albumNameField.setPreferredSize(new Dimension(200, 20));
		}
		return albumNameField;
	}

	/**
	 * This method initializes albumArtistField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlbumArtistField() {
		if (albumArtistField == null) {
			albumArtistField = new JTextField();
			albumArtistField.setMinimumSize(new Dimension(200, 20));
			albumArtistField.setPreferredSize(new Dimension(200, 20));
		}
		return albumArtistField;
	}

	/**
	 * This method initializes albumYearField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlbumYearField() {
		if (albumYearField == null) {
			albumYearField = new JTextField();
			albumYearField.setPreferredSize(new Dimension(40, 20));
			albumYearField.setMinimumSize(new Dimension(40, 20));
		}
		return albumYearField;
	}

	/**
	 * This method initializes albumNameCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAlbumNameCheck() {
		if (albumNameCheck == null) {
			albumNameCheck = new JCheckBox();
			albumNameCheck.setSelected(true);
		}
		return albumNameCheck;
	}

	/**
	 * This method initializes albumArtistCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAlbumArtistCheck() {
		if (albumArtistCheck == null) {
			albumArtistCheck = new JCheckBox();
			albumArtistCheck.setSelected(true);
		}
		return albumArtistCheck;
	}

	/**
	 * This method initializes albumYearCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAlbumYearCheck() {
		if (albumYearCheck == null) {
			albumYearCheck = new JCheckBox();
			albumYearCheck.setSelected(true);
		}
		return albumYearCheck;
	}

	/**
	 * This method initializes albumTotalTracksField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlbumTotalTracksField() {
		if (albumTotalTracksField == null) {
			albumTotalTracksField = new JTextField();
			albumTotalTracksField.setPreferredSize(new Dimension(40, 20));
			albumTotalTracksField.setMinimumSize(new Dimension(40, 20));
		}
		return albumTotalTracksField;
	}

	/**
	 * This method initializes albumTotalTracksCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAlbumTotalTracksCheck() {
		if (albumTotalTracksCheck == null) {
			albumTotalTracksCheck = new JCheckBox();
			albumTotalTracksCheck.setSelected(true);
		}
		return albumTotalTracksCheck;
	}

	/**
	 * This method initializes albumGenreFeild	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlbumGenreFeild() {
		if (albumGenreFeild == null) {
			albumGenreFeild = new JTextField();
			albumGenreFeild.setMinimumSize(new Dimension(200, 20));
			albumGenreFeild.setPreferredSize(new Dimension(200, 20));
		}
		return albumGenreFeild;
	}

	/**
	 * This method initializes albumGenreCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAlbumGenreCheck() {
		if (albumGenreCheck == null) {
			albumGenreCheck = new JCheckBox();
			albumGenreCheck.setSelected(true);
		}
		return albumGenreCheck;
	}

	/**
	 * This method initializes trackNameField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTrackNameField() {
		if (trackNameField == null) {
			trackNameField = new JTextField();
			trackNameField.setMinimumSize(new Dimension(200, 20));
			trackNameField.setPreferredSize(new Dimension(200, 20));
		}
		return trackNameField;
	}

	/**
	 * This method initializes trackNameCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getTrackNameCheck() {
		if (trackNameCheck == null) {
			trackNameCheck = new JCheckBox();
			trackNameCheck.setSelected(true);
		}
		return trackNameCheck;
	}

	/**
	 * This method initializes trackArtistField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTrackArtistField() {
		if (trackArtistField == null) {
			trackArtistField = new JTextField();
			trackArtistField.setMinimumSize(new Dimension(200, 20));
			trackArtistField.setPreferredSize(new Dimension(200, 20));
		}
		return trackArtistField;
	}

	/**
	 * This method initializes trackArtistCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getTrackArtistCheck() {
		if (trackArtistCheck == null) {
			trackArtistCheck = new JCheckBox();
			trackArtistCheck.setSelected(true);
		}
		return trackArtistCheck;
	}

	/**
	 * This method initializes trackNumberField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTrackNumberField() {
		if (trackNumberField == null) {
			trackNumberField = new JTextField();
			trackNumberField.setPreferredSize(new Dimension(40, 20));
			trackNumberField.setMinimumSize(new Dimension(40, 20));
		}
		return trackNumberField;
	}

	/**
	 * This method initializes trackDiskNumberField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTrackDiskNumberField() {
		if (trackDiskNumberField == null) {
			trackDiskNumberField = new JTextField();
			trackDiskNumberField.setPreferredSize(new Dimension(40, 20));
			trackDiskNumberField.setMinimumSize(new Dimension(40, 20));
		}
		return trackDiskNumberField;
	}

	/**
	 * This method initializes trackNumberCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getTrackNumberCheck() {
		if (trackNumberCheck == null) {
			trackNumberCheck = new JCheckBox();
			trackNumberCheck.setSelected(true);
		}
		return trackNumberCheck;
	}

	/**
	 * This method initializes trackDiskNumberCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getTrackDiskNumberCheck() {
		if (trackDiskNumberCheck == null) {
			trackDiskNumberCheck = new JCheckBox();
			trackDiskNumberCheck.setSelected(true);
		}
		return trackDiskNumberCheck;
	}

	/**
	 * This method initializes trackListPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getTrackListPanel() {
		if (trackListPanel == null) {
			trackListPanel = new JPanel();
			BorderLayout layout = new BorderLayout();
			trackListPanel.setLayout(layout);
			trackListPanel.add(getTrackList(), BorderLayout.CENTER);
			trackListPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		return trackListPanel;
	}

	/**
	 * This method initializes trackList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getTrackList() {
		if (trackList == null) {
			trackList = new JList(trackListModel);
		}
		return trackList;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
