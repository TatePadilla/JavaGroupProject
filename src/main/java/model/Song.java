/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 7, 2023
 */
package model;


public class Song {
    private String name;
    private String album;
    private String band;
    
    public Song() {
    }

    public Song(String name, String album, String band) {
        this.name = name;
        this.album = album;
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String Display() {
        return "Song: " + name + ", Album: " + album + ", Band: " + band;
    }

}
