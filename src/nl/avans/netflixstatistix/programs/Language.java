package nl.avans.netflixstatistix.programs;

public class Language
{
    private String code;
    private String name;

    public Language(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public String getCode()
    {
        return this.code;
    }

    public String getName()
    {
        return this.name;
    }
}
