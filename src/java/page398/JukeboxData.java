package page398;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class JukeboxData
{
    public static void main(String[] args)
    {
        List<Song> songs = new Songs().getSongs();

        List<String> genres = songs.stream()
                .map(s -> s.getGenre())
                .collect(Collectors.toList());
        System.out.println("Genres:");
        System.out.println(genres);
        System.out.println();

        List<String> distinctGenres = songs.stream()
                .map(s -> s.getGenre())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct genres:");
        System.out.println(distinctGenres);
        System.out.println();

        Map<String, Long> genreCount = songs.stream()
                .map(s -> s.getGenre())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("genreCount = " + genreCount);

    }

}
