package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static DBConnection instance = null;
    private DBConnection() {}

    public static DBConnection getInstance()
    {
        if(instance == null)
        {
            instance = new DBConnection();
        }
        return instance;
    }

    public static void setInstance(DBConnection instance)
    {
        DBConnection.instance = instance;
    }

    public static Connection getConnection() throws SQLException
    {
        Connection myConnection = null;
        String username = "sys as sysdba";
        String password = "a439641d";
        String service = "localhost";
        String url = "jdbc:oracle:thin:";

        myConnection = DriverManager.getConnection(url + username + "/" + password + "@" + service);
        //System.out.println("Connection established...");

        return myConnection;
    }
}
