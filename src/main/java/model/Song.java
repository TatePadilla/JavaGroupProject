/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */
package model;

class Song extends Album { //child of Album
    private String songName;
    
    public Song() { //default constructor
        super(); 
        songName = "Unknown Song";
    }

    public Song(String albumName, String bandName, String songName) { //parameter constructor
        super(albumName, bandName); 
        this.songName = songName;
    }

    public String getSongName() { //getters and setters
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
    
    public void displaySong() { //display() method
        System.out.println("Song Name: " + songName);
        System.out.println("Album Name: " + getAlbumName()); 
        System.out.println("Band Name: " + getBandName());   
    }
}