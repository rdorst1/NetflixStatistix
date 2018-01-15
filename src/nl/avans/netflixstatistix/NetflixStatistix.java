package nl.avans.netflixstatistix;

import nl.avans.netflixstatistix.database.Database;
import nl.avans.netflixstatistix.programs.ProgramDB;
import nl.avans.netflixstatistix.subscribers.Subscribers;
import nl.avans.netflixstatistix.ui.UserInterface;

public  class NetflixStatistix
{
    private static UserInterface userInterface;
    private static Database database;
    private static ProgramDB programs;
    private static Subscribers subscribers;

    public static void init()
    {
        System.out.println("Database laden...");
        database = new Database();
        System.out.println("ProgramDB laden...");
        programs = new ProgramDB();
        System.out.println("Subscribers laden...");
        subscribers = new Subscribers();
        System.out.println("Userinterface laden...");
        userInterface = new UserInterface();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                userInterface.setVisible(true);
            }
        });
        System.out.println("Alles geladen...");
    }

    public static Database getDatabase()
    {
        return database;
    }

    public static UserInterface getUserInterface()
    {
        return userInterface;
    }

    public static ProgramDB getPrograms() { return programs; }

    public static Subscribers getSubscribers() { return subscribers; }
}
