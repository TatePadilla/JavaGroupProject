/**
 * @author chris - chtutje@dmacc.edu & Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */

package model;

import java.util.List;

import javax.persistence.*;

@Entity(name = "album")
@Table(name = "album")
public class Album {
	// Creating foreign key for one to many relationship
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int albumId;
	private String albumName;
	private String bandName;

	// Creating one to many relationship with songs
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Song> song;

	public Album() { // default constructor
		albumName = "Unknown Album";
		bandName = "Unknown Band";
	}
	

	public int getAlbumId() { // getters and setters
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public void displayAlbum() { // bonus display() method
		System.out.println("Album ID: " + albumName); //Does this need to be getAlbumName or just albumName???
		System.out.println("Album Name: " + albumName);
		System.out.println("Band Name: " + bandName);
	}

}
