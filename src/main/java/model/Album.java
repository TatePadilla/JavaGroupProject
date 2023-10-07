/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */
package model;

class Album {
    private String albumName;
    private String bandName;
    
    public Album() { //default constructor
        albumName = "Unknown Album";
        bandName = "Unknown Band";
    }

    public Album(String albumName, String bandName) { //parameter constructor
        this.albumName = albumName;
        this.bandName = bandName;
    }

    public String getAlbumName() { //getters and setters
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
    
    public void displayAlbum() { //bonus display() method
        System.out.println("Album Name: " + albumName);
        System.out.println("Band Name: " + bandName);
    }
    
}
