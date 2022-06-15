
class Episode
{

    int seriesNumber;
    int episodeNumber;

    void skipIntro()
    {
        System.out.println("Skipping intro...");
    }

    void skipToNext()
    {
        System.out.println("Loading next episode...");
    }

    void play()
    {
        System.out.println("Playing episode...");
    }
}
