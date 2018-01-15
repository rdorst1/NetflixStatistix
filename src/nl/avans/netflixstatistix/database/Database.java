package nl.avans.netflixstatistix.database;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

public class Database
{

    public Database()
    {
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=netflix;integratedSecurity=true;";

        Connection con = null;


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            if(con == null || con.isClosed())
            {
                System.out.println("Could not establish database connection");
                return;
            }
            this.connection = con;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispose()
    {
        try
        {
            this.connection.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }

    private Connection connection;

    public Connection getConnection()
    {
        return this.connection;
    }

}