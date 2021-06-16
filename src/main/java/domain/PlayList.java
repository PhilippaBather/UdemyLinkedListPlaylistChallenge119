package domain;

import com.philippa.Menu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Class defines a playlist contained of songs within an album object of Album class.
 */
public class PlayList {

    // member fields
    private static final String START_PLAYLIST = "Now at the start of the playlist.";
    private static final String NOW_PLAYING = "Now playing...";

    // instance fields
    private final LinkedList<Song> playlist;

    // constructor

    public PlayList() {
        this.playlist = new LinkedList<>();
    }

    // other methods

    /**
     * Adds a song to the playlist.
     * @param song to be added
     */
    public void addSong(Song song) {
        playlist.add(song);
    }

    /**
     * Prints playlist to console.
     */
    public void listSongs() {
        System.out.println("==========\t\tPLAYLIST\t\t==========");
        // replaced ListIterator with iterator as no need to go backwards through the list.
        Iterator<Song> iterator = playlist.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================================");
    }

    /**
     * Manages the music controls to play playlist: play, skip track forwards, skip track
     * backwards, and remove track.
     */
    public void playMusic() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("Playlist  is empty; add songs at MAIN MENU.");
        } else {
            System.out.println("\n" + NOW_PLAYING + listIterator.next());
        }

        while(!quit) {
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    Menu.playlistMenu();
                    break;
                case "1":       // skip forwards to next song
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println(NOW_PLAYING + listIterator.next());
                    } else {
                        System.out.println("Reach end of playlist");
                        forward = false;
                    }
                    break;
                case "2":       // skip backwards to previous song
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(NOW_PLAYING + listIterator.previous());
                    } else {
                        System.out.println(START_PLAYLIST);
                        forward = true;
                    }
                    break;
                case "3":  // replay current track
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println(START_PLAYLIST);
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("Reached end of the list.");
                        }
                    }
                    break;
                case "4":
                    if (!listIterator.hasPrevious()) {
                        listIterator.next();
                        listIterator.remove();
                    } else if (!listIterator.hasNext()) {
                        listIterator.previous();
                        listIterator.remove();
                    } else {
                        listIterator.remove();
                    }
                    System.out.println("Current song removed.");
                    break;
                case "x":
                    System.out.println("Returning to MAIN MENU...");
                    quit = true;
                    break;
                default:
                    System.out.println("Menu option not recognised.");
            }
            System.out.println("\nEnter 0 for playlist play options.");
        }
    }
}
