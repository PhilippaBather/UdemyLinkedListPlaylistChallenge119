package domain;

import java.util.ArrayList;
import java.util.List;

public class Albums {

    // instance fields
    private final List<Record> albumsList;

    // constructor

    public Albums() {
        this.albumsList = new ArrayList<>();
    }

    // other methods

    /**
     * Add an album to the AlbumList object containing an ArrayList of albums.
     * @param artist name of group/artist
     * @param title of track
     */
    public boolean addAlbumToCollection(String artist, String title) {
        int index = getIndexValue(artist, title);
        if (index == -1) {
            albumsList.add(new Record(artist, title));
            index = getIndexValue(artist, title);
            albumsList.get(index).addSongsToAlbum();
            return true;
        }
        return false;
    }

    /**
     * Add songs to an existing album provided it exists
     * @param artist specified by user
     * @param title specified by user
     * @return boolean isAdded
     */
    public boolean addSongsToExistingAlbum(String artist, String title) {
        // check album of specified artist exists
        int index = getIndexValue(artist, title);
        if (index != -1) {  // if exists add songs
            albumsList.get(index).addSongsToAlbum();
            return true;
        }
        return false;
    }

    /**
     * Prints lists of albums within the AlbumList object's ArrayList of albums
     * to console.
     */
    public void printAlbums()  {
        System.out.println("==========\t\tALBUMS IN COLLECTION\t\t==========");
        for (Record record :
             albumsList) {
            System.out.println(record);
        }
    }

    /**
     * Checks for a given song by a specified artist exists within the album
     * ArrayList.
     * @param artist of song
     * @param title of song
     * @return boolean isArtist
     */
    public Song checkTrackExists(String artist, String title) {
        for (Record record :
                this.albumsList) {
            if (record.getArtist().equals(artist)) {
                return record.checkSongExists(title);
            }
        }
        return null;
    }

    /**
     * Gets the index value of a given album according to album and artist's name.
     * @param artist of album
     * @param title of album
     * @return int index value of album
     */
    private int getIndexValue(String artist, String title) {
        for (Record record :
             albumsList) {
            if (record.getArtist().equals(artist) && record.getName().equals(title)) {
                return albumsList.indexOf(record);
            }
        }
        return -1;
    }
}
