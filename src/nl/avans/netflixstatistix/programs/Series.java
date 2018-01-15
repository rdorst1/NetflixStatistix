package nl.avans.netflixstatistix.programs;

import java.util.HashMap;

public class Series extends Program
{
    private HashMap<String, Episode> episodes;

    public Series(int id, String title, Language language, Genre genre, int ageminimum, HashMap<String, Episode> episodes)
    {
        super(id, title, genre, language, ageminimum, false);

        this.episodes = episodes;
    }

    public HashMap<String, Episode> getEpisodes()
    {
        return this.episodes;
    }

    @Override
    public int getTotalLength()
    {
        int i = 0;
        for(Episode e : this.episodes.values())
        {
            i += e.getLength();
        }
        return i;
    }
}
