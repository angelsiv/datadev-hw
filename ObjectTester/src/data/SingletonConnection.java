package data;

import java.sql.*;

public class SingletonConnection
{
    private static SingletonConnection instance = null;
    private SingletonConnection() {}

    public static SingletonConnection getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public static void setInstance(SingletonConnection instance)
    {
        SingletonConnection.instance = instance;
    }

    public static Connection getConnection() throws SQLException
    {
        Connection myConnection = null;
        String username = "sys as sysdba";
        String password = "a439641d";
        String service = "localhost";
        String url = "jdbc:oracle:thin:";

        myConnection = DriverManager.getConnection(url + username + "/" + password + "@" + service);
        System.out.println("Connection established...");

        return myConnection;
    }
}
