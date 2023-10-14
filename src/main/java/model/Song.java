/**
 * @author chris - chtutje@dmacc.edu & Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */



package model;


import java.time.LocalDate;

import javax.persistence.*;

@Entity(name = "song")
@Table(name = "song")
public class Song { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String songName;
	private LocalDate songCreatedDate;

	@ManyToOne // Creating many to one relationship with Album
	@JoinColumn(name = "ALBUMID", nullable = false)
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
	
	public LocalDate getSongCreatedDate() {
		return songCreatedDate;
	}

	public void setSongCreatedDate(LocalDate songCreatedDate) {
		this.songCreatedDate = songCreatedDate;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}


}


