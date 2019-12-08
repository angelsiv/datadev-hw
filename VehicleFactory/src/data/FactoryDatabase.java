package data;
import bus.*;
import java.sql.*;

public class FactoryDatabase
{
    public FactoryDatabase() {}

    public static Exception createTable(Connection currentConnection) throws SQLException
    {
        Statement databaseStatement = null;
        String sqlString = "create table Vehicle (serial_number number primary key not null, make varchar(50), model varchar(50), type varchar(15), mileage number)";
        databaseStatement = currentConnection.createStatement();
        databaseStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws  SQLException
    {
        return null;
    }

    public static Exception alterTable(int serialNumber, Connection currentConnection) throws SQLException
    {
        return null;
    }

    public static Exception dropTable(Connection currentConnection) throws SQLException
    {
        return null;
    }

    public static int insertData(Vehicle vehicle) throws SQLException
    {
        return 0;
    }

    public static int deleteData(Vehicle vehicle) throws SQLException
    {
        return 0;
    }

    public static int deleteData(int serialNumber) throws SQLException
    {
        return 0;
    }

    public static Vehicle searchData(int serialNumber) throws SQLException
    {
        return null;
    }

    public static Vehicle searchData(String make) throws SQLException
    {
        return null;
    }
}
