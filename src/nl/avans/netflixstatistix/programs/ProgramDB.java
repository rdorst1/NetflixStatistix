package nl.avans.netflixstatistix.programs;

import nl.avans.netflixstatistix.NetflixStatistix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ProgramDB
{
    private HashMap<String, Language> languages;
    private HashMap<Integer, Program> programs;

    public ProgramDB()
    {
        this.init();
    }

    public String[] getNames(Class<? extends Program> c)
    {
        ArrayList<String> names = new ArrayList<>();
        for(Program p : this.programs.values())
        {
            if(!c.isInstance(p))
                continue;
            names.add(p.getId() + ". " + p.getTitle());
        }
        return names.toArray(new String[]{});
    }

    public Series getSeries(int id)
    {
        return (Series) this.getProgram(id, Series.class);
    }

    public Movie getMovie(int id)
    {
        return (Movie) this.getProgram(id, Movie.class);
    }

    public Program getProgram(int id, Class<? extends Program> c)
    {
        try {
            for (Program p : this.programs.values()) {
                if (!c.isInstance(p))
                    continue;
                if (p.getId() == id)
                    return p;
            }
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Movie getMovieUnder16()
    {
        Movie m = null;
        for(Program p : this.programs.values())
        {
            if(Movie.class.isInstance(p))
            {
                Movie mm = (Movie) p;
                if(mm.getAgeminimum() >= 16)
                    continue;
                if(m == null)
                    m = mm;
                else if(mm.getTotalLength() > m.getTotalLength())
                    m = mm;
            }
        }
        return m;
    }

    public void init()
    {
        if(this.languages != null)
            this.languages.clear();
        else
            this.languages = new HashMap<>();
        if(this.programs != null)
            this.programs.clear();
        else
            this.programs = new HashMap<>();

        Connection con = NetflixStatistix.getDatabase().getConnection();
        try
        {
            PreparedStatement languageQuery = con.prepareStatement("SELECT code, name FROM languages");
            ResultSet languageset = languageQuery.executeQuery();
            while(languageset.next())
            {
                Language language = new Language(languageset.getString("code"), languageset.getString("name"));
                this.languages.put(language.getCode(), language);
            }
            languageset.close();

            PreparedStatement ps = con.prepareStatement("SELECT programs.* FROM programs");
            ResultSet set = ps.executeQuery();
            while(set.next())
            {
                int id = set.getInt("id");
                String title = set.getString("title");
                String genreval = set.getString("genre");
                String lanval = set.getString("language");
                int ageminimum = set.getInt("ageminimum");
                boolean isMovie = set.getInt("ismovie") == 1;

                Genre genre = Genre.valueOf(genreval.toUpperCase());
                Language language = this.languages.get(lanval);

                if(genre == null || language == null)
                    continue;

                if(isMovie)
                {
                    PreparedStatement ps2 = con.prepareStatement("SELECT movies.* FROM movies WHERE program = ?");
                    ps2.setInt(1, id);
                    ResultSet set2 = ps2.executeQuery();
                    if(!set2.next())
                        continue; // Film staat verkeerd in database, niet in het systeem toevoegen
                    int movieLength = set2.getInt("length");

                    ps2.close();

                    Movie m = new Movie(id, title, genre, language, ageminimum, movieLength);
                    this.programs.put(id, m);
                    continue;
                }
                else // Het is een serie
                {
                    HashMap<String, Episode> episodes = new HashMap<>();
                    PreparedStatement ps3 = con.prepareStatement("SELECT episodes.program, episodes.episodeid, episodes.title, episodes.length, AVG(views.length) AS av FROM episodes INNER JOIN views ON views.program = episodes.program WHERE episodes.program = ? GROUP BY episodes.program, episodes.episodeid, episodes.title, episodes.length;");
                    ps3.setInt(1, id);
                    ResultSet set3 = ps3.executeQuery();
                    while(set3.next())
                    {
                        String eid = set3.getString("episodeid");
                        String etitle = set3.getString("title");
                        int length = set3.getInt("length");
                        int av = set3.getInt("av"); // average view length
                        int ap = av * 100 / length;

                        Episode e = new Episode(id, eid, etitle, length, ap);
                        episodes.put(eid, e);
                    }

                    Series s = new Series(id, title, language, genre, ageminimum, episodes);
                    this.programs.put(id, s);
                    continue;
                }

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
