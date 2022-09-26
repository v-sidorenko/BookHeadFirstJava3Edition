package page412;

import java.util.*;
import java.util.stream.*;
import page398.*;

class SongSearch
{
    private final List<Song> songs = new Songs().getSongs();

    void printTopFiveSongs()
    {
        List<String> topFive = songs.stream()
                .sorted((s1, s2) -> s1.getTimesPlayed() - s2.getTimesPlayed())
                .map(Song::getTitle)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(topFive);
    }

    void search(String artist)
    {
        Optional<Song> song = songs.stream()
                .filter(s -> s.getArtist().equals(artist))
                .findFirst();
        if(song.isPresent())
        {
            System.out.println(song.get().getTitle());
        } else
        {
            System.out.println("No songs found by: " + artist);
        }
    }
}
