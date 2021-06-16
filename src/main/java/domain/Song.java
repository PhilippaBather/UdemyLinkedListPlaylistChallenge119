package domain;

/**
 * Template for songs to be contained within object of record class.
 */
public class Song {

    // instance fields
    private final String title;
    private final double duration;

    // constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    // other methods

    public static Song createSong(String title, double duration) {
        return new Song(title, duration);
    }

    @Override
    public String toString() {
        return this.title + " : " + this.duration;
    }
}
