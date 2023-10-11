/**
 * @author chris - chtutje@dmacc.edu & Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */


/*
package model;

import javax.persistence.*;

@Entity(name = "song")
@Table(name = "song")
public class Song extends Album { // child of Album
	@Id // Creating foreign key for many to one relationship
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String songName;

	@ManyToOne // Creating many to one relationship with Album
	@JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID", nullable = false)
	private Album album = new Album();

	public Song() { // default constructor
		super();
		songName = "Unknown Song";
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
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void displaySong() { // display() method
		System.out.println("Song ID: " + getSongId());
		System.out.println("Song Name: " + getSongName()); 
		System.out.println("Album Name: " + getAlbumName());
		System.out.println("Album ID: " + getAlbumId());
		System.out.println("Band Name: " + getBandName());
	}
}

*/