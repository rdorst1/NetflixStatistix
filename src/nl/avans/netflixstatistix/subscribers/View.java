package nl.avans.netflixstatistix.subscribers;

import nl.avans.netflixstatistix.programs.Episode;
import nl.avans.netflixstatistix.programs.Program;

public class View
{
    private Program program;
    private Episode episode;
    private int perc;

    public View(Program program, Episode episode, int perc)
    {
        this.program = program;
        this.episode = episode;
        this.perc = perc;
    }

    public Program getProgram()
    {
        return program;
    }

    public Episode getEpisode()
    {
        return episode;
    }

    public int getPercentageSeen()
    {
        return perc;
    }
}

