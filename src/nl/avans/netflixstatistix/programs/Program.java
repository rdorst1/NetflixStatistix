package nl.avans.netflixstatistix.programs;

public abstract class Program
{
    private int id;
    private String title;
    private Genre genre;
    private Language language;
    private boolean isMovie;
    private int ageminimum;

    public Program(int id, String title, Genre genre, Language language, int ageminimum, boolean isMovie)
    {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.isMovie = isMovie;
        this.ageminimum = ageminimum;
    }

    public abstract int getTotalLength();

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public boolean isMovie()
    {
        return isMovie;
    }

    public Language getLanguage()
    {
        return language;
    }

    public int getAgeminimum()
    {
        return ageminimum;
    }
}
