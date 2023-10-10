/**
 * @author chris - chtutje@dmacc.edu & Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "song")
@Table(name = "song")
class Song extends Album { // child of Album
	@Id // Creating foreign key for many to one relationship
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String songName;

	@ManyToOne // Creating many to one relationship with Album
	@JoinColumn(name = "ALBUMID", nullable = false)
	private Album album = new Album();

	public Song() { // default constructor
		super();
		songName = "Unknown Song";
	}

	public Song(String albumName, String bandName, String songName) { // parameter constructor
		super(albumName, bandName);
		this.songName = songName;
	}

	public int getSongId() { // getters and setters
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public void displaySong() { // display() method
		System.out.println("Song Name: " + songName);
		System.out.println("Album Name: " + getAlbumName());
		System.out.println("Band Name: " + getBandName());
	}
}