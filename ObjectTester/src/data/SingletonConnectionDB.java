package data;

import java.sql.*;

public class SingletonConnectionDB
{
    private static SingletonConnectionDB instance = null;
    private SingletonConnectionDB() {}

    public static SingletonConnectionDB getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonConnectionDB();
        }
        return instance;
    }

    public static void setInstance(SingletonConnectionDB instance)
    {
        SingletonConnectionDB.instance = instance;
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
