package page412;

public class StreamPuzzle
{

    public static void main(String[] args)
    {
        SongSearch songSearch = new SongSearch();
        songSearch.printTopFiveSongs();
        songSearch.search("The Beatles");
        songSearch.search("The Beach Boys");
    }
}
