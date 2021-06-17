package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.philippa.ValidateDouble.validateDouble;

public class Record {

    // member fields
    private static final Scanner scanner = new Scanner(System.in);

    // instance fields
    private final String artist;
    private final String name;
    private final List<Song> record;

    // constructor
    public Record(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.record = new ArrayList<>();
    }

    // getters and setters

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    // other methods

    /**
     * Adds a song to an album object within the AlbumList ArrayList.
     * Note: every album must have at least one song on it.
     */
    public void addSongsToAlbum() {
        boolean exit;
        do {   // get song details
            System.out.println("Add a song to the album.");
            System.out.println("Add song title:");
            String title = scanner.nextLine().toUpperCase();
            System.out.println("Add song duration:");
            double duration = validateDouble();     // validate input
            // create song object and add to list if song not already on file
            int index = getIndexValue(title);
            if (index == -1) {
                Song song = Song.createSong(title, duration);
                this.record.add(song);
            } else {  // notify user if already on file
                System.out.println("Song already on record.");
            }
            // identify if user wants to add another song
            System.out.println("Do you want to add another song?  Press 1 for yes or any other key to exit");
            String input = scanner.nextLine();
            exit = (!input.equals("1"));
        } while (!exit);
    }

    /**
     * Checks a song exists the title provided by a user within an album.
     * @param title of song
     * @return int value of song
     */
    public Song checkSongExists(String title) {
        int index = getIndexValue(title);
        if (index != -1) {
            return record.get(index);
        }
        return null;
    }

    /**
     * Returns the index value of a song object within the Album ArrayList of songs.
     * @param title of song
     * @return int index value
     */
    private int getIndexValue(String title) {
        for (Song song:
             this.record) {
            if (song.getTitle().equals(title)) {
                return record.indexOf(song);
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "\n" + this.artist + ", " + this.name + " : " + this.record;
    }
}
