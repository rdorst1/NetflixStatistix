package nl.avans.netflixstatistix.programs;

public class Episode
{
    private int seriesId;
    private String id;
    private String title;
    private int length;
    private int avgPercentage;

    public Episode(int seriesId, String id, String title, int length, int avgPercentage)
    {
        this.seriesId = seriesId;
        this.id = id;
        this.title = title;
        this.length = length;
        this.avgPercentage = avgPercentage;
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public int getLength()
    {
        return length;
    }

    public int getAvgPercentage()
    {
        return this.avgPercentage;
    }

    public int getSeriesId()
    {
        return seriesId;
    }
}
