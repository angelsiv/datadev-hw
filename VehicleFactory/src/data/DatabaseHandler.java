package data;
import java.sql.*;

public class DatabaseHandler
{
    private static DatabaseHandler instance = null;
    public DatabaseHandler() {}

    public static DatabaseHandler getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public static void setInstance(DatabaseHandler instance)
    {
        DatabaseHandler.instance = instance;
    }

    public static Connection establishDatabaseConnection() throws SQLException
    {
        Connection connectionToDatabase = null;
        String username = "sys as sysdba";
        String password = "system";
        String service = "localhost";
        String url = "jdbc:oracle:thin";

        connectionToDatabase = DriverManager.getConnection(url + username + "/" + password + "@" + service);

        return connectionToDatabase;
    }
}
