package com.philippa;

import domain.Albums;
import domain.PlayList;
import domain.Song;

import java.util.Scanner;

/**
 * Menu class executes menu and handles menu selection.
 */
public class Menu {

    // member fields
    private static final Scanner scanner = new Scanner(System.in);
    private static final PlayList playList = new PlayList();
    private static final Albums albums = new Albums();


    /**
     * Executes and handles menu options.
     */
    public static void executeMainMenu() {
        boolean exit = false;

        do {
            printMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addAlbum();
                    break;
                case "2":
                    addSongsToAlbum();
                    break;
                case "3":
                    listAlbums();
                    break;
                case "4":
                    addSongToPlaylist();
                    break;
                case "5":
                    listPlaylist();
                    break;
                case "6":
                    playlistMenu();
                    playList.playMusic();
                    break;
                case "x":
                    exit = true;
                    break;
                default:
                    System.out.println("Menu option not recognised.");
            }
        } while (!exit);

    }

    /**
     * Prints menu options to console.
     */
    private static void printMainMenu() {
        System.out.println("\n*****\t\t\tMenu Options\t\t\t*****");
        System.out.println("\n1. Add album");
        System.out.println("2. Add songs to existing album");
        System.out.println("3. List available albums");
        System.out.println("4. Add song to playlist");
        System.out.println("5. List playlist");
        System.out.println("6. Open play music menu");
        System.out.println("x. Quit");
        System.out.println("Choose option:");
    }

    /**
     * Prints play playlist options to console
     */
    public static void playlistMenu() {
        System.out.println("\n*****\t\t\tPlayList Options\t\t\t*****");
        System.out.println("1. Skip forwards to next song");
        System.out.println("2. Skip backwards to previous song");
        System.out.println("3. Replay current song");
        System.out.println("4. Remove current song");
        System.out.println("x. Quit");
        System.out.println("\n Choose option:");
    }

    /**
     * Adds an album to the Album objects ArrayList.
     */
    private static void addAlbum() {
        System.out.println("Enter artist:");
        String artist = scanner.nextLine().toUpperCase();
        System.out.println("Enter album name:");
        String name = scanner.nextLine().toUpperCase();
        if (albums.addAlbumToCollection(artist, name)) {
            System.out.println("Album added.");
        } else {
            System.out.println("Album already on record.");
            listAlbums();
        }
    }

    /**
     * Add songs to an existing album.
     */
    private static void addSongsToAlbum() {
        System.out.println("Enter the artist:");
        String artist = scanner.nextLine().toUpperCase();
        System.out.println("Enter the album title:");
        String title = scanner.nextLine().toUpperCase();
        boolean isAlbum = albums.addSongsToExistingAlbum(artist, title);
        if (!isAlbum) {
            System.out.println("No album called " + title + " by " + artist + " exists.");
        }
    }

    /**
     * Prints albums within album array list to console.
     */
    private static void listAlbums() {
        albums.printAlbums();
    }

    /**
     * Add a song to the playlist provided the song exists.
     */
    private static void addSongToPlaylist() {
        System.out.println("Enter artist:");
        String artist = scanner.nextLine().toUpperCase();
        System.out.println("Enter song name:");
        String title = scanner.nextLine().toUpperCase();
        // check song exists
        Song song = albums.checkTrackExists(artist, title);

        if (song != null) {
            playList.addSong(song);
            System.out.println("Song successfully added to playlist");
        } else {
            System.out.println("Error: song not added.  Check artist and song exist in the list of albums.");
        }
    }

    /**
     * Prints songs on playlist to console.
     */
    private static void listPlaylist() {
        playList.listSongs();
    }
}
