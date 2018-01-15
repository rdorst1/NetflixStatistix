package nl.avans.netflixstatistix.programs;

public class Movie extends Program
{
    private int length;

    public Movie(int id, String title, Genre genre, Language language, int ageminimum, int length)
    {
        super(id, title, genre, language, ageminimum, true);
        this.length = length;
    }

    @Override
    public int getTotalLength()
    {
        return this.length;
    }
}
