package nl.avans.netflixstatistix.subscribers;

import nl.avans.netflixstatistix.NetflixStatistix;
import nl.avans.netflixstatistix.programs.Movie;
import nl.avans.netflixstatistix.programs.Program;
import nl.avans.netflixstatistix.programs.Series;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Subscribers
{
    private HashMap<Integer, Subscriber> list;

    public Subscribers()
    {
        this.init();
    }

    public Subscriber[] getSubscribers()
    {
        return this.list.values().toArray(new Subscriber[]{});
    }

    public ArrayList<Subscriber> getAccountsWithOneProfile()
    {
        ArrayList<Subscriber> l = new ArrayList<>();
        for(Subscriber s : this.list.values())
        {
            if(s.getProfiles().size() == 1)
                l.add(s);
        }
        return l;
    }

    public String[] getSubscriberNames()
    {
        ArrayList<String> names = new ArrayList<>();
        for(Subscriber s : this.list.values())
        {
            String name = s.getId() + ". " + s.getName();
            names.add(name);
        }
        return names.toArray(new String[]{});
    }

    public Subscriber getSubscriber(int id)
    {
        return this.list.get(id);
    }

    public void init()
    {
        this.list = new HashMap<>();
        PreparedStatement ps = null, ps2 = null, ps3 = null;
        ResultSet set = null, set2 = null, set3 = null;
        try
        {
            ps = NetflixStatistix.getDatabase().getConnection().prepareStatement("SELECT * FROM subscribers");
            set = ps.executeQuery();
            while(set.next())
            {
                int id = set.getInt("id");
                String name = set.getString("name");
                String city = set.getString("city");
                String address = set.getString("address");

                HashMap<Integer, Profile> profiles = new HashMap<>();

                ps2 = NetflixStatistix.getDatabase().getConnection().prepareStatement("SELECT id, name, DATEDIFF(yy, birthday, getdate()) AS age FROM profiles WHERE subscriber = ?");
                ps2.setInt(1, id);
                set2 = ps2.executeQuery();
                while(set2.next())
                {
                    int pid = set2.getInt("id");
                    String pname = set2.getString("name");
                    int age = set2.getInt("age");

                    ps3 = NetflixStatistix.getDatabase().getConnection().prepareStatement("SELECT * FROM views WHERE profile = ?");
                    ps3.setInt(1, pid);
                    set3 = ps3.executeQuery();
                    ArrayList<View> views = new ArrayList<>();
                    while(set3.next())
                    {
                        int prog = set3.getInt("program");
                        String epi = set3.getString("episodeid");
                        boolean movie = set3.wasNull();
                        int minutesSeen = set3.getInt("length");
                        View v;
                        if(movie)
                        {
                            Movie m = NetflixStatistix.getPrograms().getMovie(prog);
                            if(m == null)
                                continue;
                            int perc = minutesSeen * 100 / m.getTotalLength();
                            v = new View(m, null, perc);
                        }
                        else
                        {
                            Series s = NetflixStatistix.getPrograms().getSeries(prog);
                            if(s == null)
                                continue;
                            int perc = minutesSeen * 100 / s.getTotalLength();
                            v = new View(s, s.getEpisodes().get(epi), perc);
                        }
                        views.add(v);
                    }
                    set3.close();

                    Profile p = new Profile(pid, pname, age, views);
                    profiles.put(pid, p);
                }
                this.list.put(id, new Subscriber(id, name, city, address, profiles));
                set2.close();
            }
            set.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(ps != null)
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(ps2 != null)
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(ps3 != null)
                try {
                    ps3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
