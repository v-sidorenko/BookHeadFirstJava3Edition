package page398;

import java.util.*;
import java.util.stream.*;

public class JukeboxStreams
{
    public static void main(String[] args)
    {
        List<Song> songs = new Songs().getSongs();
        List<Song> rockSongs = songs.stream()
                .filter(s -> s.getGenre().toLowerCase().contains("rock"))
                .collect(Collectors.toList());
        System.out.println("Rock songs:");
        System.out.println(rockSongs);
        System.out.println();

        List<Song> theBeatlesSongs = songs.stream()
                .filter(s -> s.getArtist().equals("The Beatles"))
                .collect(Collectors.toList());
        System.out.println("The Betles songs:");
        System.out.println(theBeatlesSongs);
        System.out.println();

        List<Song> firstHSongs = songs.stream()
                .filter(s -> s.getTitle().toLowerCase().startsWith("h"))
                .collect(Collectors.toList());
        System.out.println("Start with \"H\" songs:");
        System.out.println(firstHSongs);
        System.out.println();

        List<Song> older1995Songs = songs.stream()
                .filter(s -> s.getYear() > 1995)
                .collect(Collectors.toList());
        System.out.println("More recent than 1995 songs:");
        System.out.println(older1995Songs);
        System.out.println();
    }
}
