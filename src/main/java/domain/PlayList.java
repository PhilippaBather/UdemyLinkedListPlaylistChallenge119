package domain;

import com.philippa.Menu;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Class defines a playlist contained of songs within an album object of Album class.
 */
public class PlayList {

    // member fields
    //private static final Albums albums = new Albums();

    // instance fields
    LinkedList<Song> playlist;

    // constructor

    public PlayList() {
        this.playlist = new LinkedList<>();
    }

    // getters and setters

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }


    // other methods

    /**
     * Adds a song to the playlist.
     */
    public void addSong(Song song) {
        playlist.add(song);
    }

    /**
     * Prints playlist to console.
     */
    public void listSongs() {
        System.out.println("==========\t\tPLAYLIST\t\t==========");
        ListIterator<Song> listIterator = playlist.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
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
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("Playlist  is empty; add songs at MAIN MENU.");
        } else {
            System.out.println("Now playing... " + listIterator.next());
        }

        while(!quit) {
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    Menu.playlistMenu();
                    break;
                case "1":
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing..." + listIterator.next());
                    } else {
                        System.out.println("Reached end of playlist.");
                    }
                    break;
                case "2":
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing..." + listIterator.previous());
                    } else {
                        System.out.println("Now at the start of the playlist.");
                    }
                    break;
                case "3":
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
            System.out.println("Enter 0 for playlist play options.");
        }
        Menu.executeMainMenu();
    }

}
