package nl.avans.netflixstatistix.subscribers;

import java.sql.Date;
import java.util.ArrayList;

public class Profile
{
    private int id;
    private String name;
    private int age;
    private ArrayList<View> viewlog;

    public Profile(int id, String name, int age, ArrayList<View> views)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.viewlog = views;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public ArrayList<View> getViews()
    {
        return this.viewlog;
    }
}
