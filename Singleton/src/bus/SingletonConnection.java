package bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection
{
    private static SingletonConnection instance = null;

    private SingletonConnection() { } //default constructor must be private

    public static SingletonConnection getInstance() //singular construction
    {
        if (instance == null)
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
        String username = "system";
        String password = "password";
        String service = "localhost";
        String url = "jdbc:oracle:thin:";

        return myConnection = DriverManager.getConnection(url + username + "/" + password + "@" + service);
    }
}
