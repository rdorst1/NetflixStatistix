package nl.avans.netflixstatistix.subscribers;

import nl.avans.netflixstatistix.NetflixStatistix;
import nl.avans.netflixstatistix.programs.Episode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Subscriber
{
    private int id;
    private String name;
    private String city;
    private String address;
    private HashMap<Integer, Profile> profiles;

    public Subscriber(int id, String name, String city, String address, HashMap<Integer, Profile> profiles)
    {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.profiles = profiles;
    }

    public int getAverageSeen(Episode e)
    {
        PreparedStatement ps = null;
        try
        {
            ps = NetflixStatistix.getDatabase().getConnection().prepareStatement("SELECT AVG(views.length) AS av FROM views INNER JOIN profiles ON views.profile = profiles.id WHERE views.episodeid = ? AND views.program = ? AND profiles.subscriber = ?");
            ps.setString(1, e.getId());
            ps.setInt(2, e.getSeriesId());
            ps.setInt(3, this.id);
            ResultSet set = ps.executeQuery();
            if(set.next())
            {
                int i = set.getInt("av");
                set.close();
                return i;
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
            return -1;
        }
        finally
        {
            if(ps != null)
                try { ps.close(); } catch(Exception eee) { }
        }
        return -1;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getAddress()
    {
        return this.address;
    }

    public HashMap<Integer, Profile> getProfiles()
    {
        return this.profiles;
    }

}
