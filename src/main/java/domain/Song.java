package domain;

/**
 * Template for songs to be contained within object of album class.
 */
public class Song {

    // instance fields
    private String title;
    private double duration;

    // constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    // getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // other methods

    public static Song createSong(String title, double duration) {
        return new Song(title, duration);
    }

    @Override
    public String toString() {
        return "\n" + this.title + " : " + this.duration;
    }
}
