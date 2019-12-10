package data;

import bus.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SportCarDB
{
    public SportCarDB() {}

    public static Exception createTable(Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "create table Car(serialNumber number primary key not null , brand varchar(50), model varchar(50))";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "desc Car; ";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static HashMap<Long, Car> getList() throws SQLException {
        HashMap<Long, Car> mapList = new HashMap();
        Connection myConnection = DBConnection.getConnection();
        String query = "select * from Car";
        Statement myStatement = myConnection.createStatement();
        ResultSet resultSet = myStatement.executeQuery(query);

        while(resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            Car aCar = new Car();
            mapList.put((long) aCar.getSerialNumber(), aCar);
        }
        myConnection.close();
        return mapList;
    }

    public static int insert(Car current) throws SQLException
    {
        Connection myConnection = DBConnection.getConnection();
        Statement myStatement = myConnection.createStatement();
        String request = "insert into Car (id, brand, model)values (" + current.getSerialNumber() + "," + "'" + current.getBrand() + "'" + "," + "'" + current.getModel() + "'" + ")";
        int success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static int delete(Car current) throws SQLException
    {
        Connection myConnection = DBConnection.getConnection();
        Statement myStatement = myConnection.createStatement();
        String request = "delete from Car where id=" + current.getSerialNumber();
        int success = myStatement.executeUpdate(request);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static Car search(long key) throws SQLException
    {
        Connection myConnection = DBConnection.getConnection();
        Statement myStatement = myConnection.createStatement();
        String request = "SELECT * FROM Car WHERE ID = " + key + " ;";
        ResultSet myResultSet = myStatement.executeQuery(request);
        Car aCar = null;

        if (myResultSet.next()) {
            aCar = new Car();
        }
        return aCar;
    }

    public static int update(String value) {
        return 0;
    }
}
