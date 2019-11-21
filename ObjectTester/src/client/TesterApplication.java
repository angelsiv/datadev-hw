package client;

import bus.*;
import data.*;

import java.sql.*;
import java.util.Scanner;

public class TesterApplication
{
    public static void main(String[] args) throws SQLException
    {
        SingletonConnection.getConnection();
        Scanner scan = new Scanner(System.in);

        ///Display Students
        Statement myStatement = null;
        ResultSet myResultSet = null;

        String sqlStmt = "SELECT * FROM student";
        myStatement = SingletonConnection.getConnection().createStatement();
        myResultSet = myStatement.executeQuery(sqlStmt);

        while(myResultSet.next())
        {
            int id = myResultSet.getInt(1);
            String name = myResultSet.getString(2);
            System.out.println(id + " | " + name);
        }

        ///Insert a New Student
        System.out.println("ID ? : ");
        int id = scan.nextInt();
        System.out.println("Name ? : ");
        String name = scan.next();

        sqlStmt = "Insert into student values (?, ?)";
        PreparedStatement myPreparedStatement = null;
        myPreparedStatement = SingletonConnection.getConnection().prepareStatement(sqlStmt);
        myPreparedStatement.setInt(1, id);
        myPreparedStatement.setString(2, name);

        myPreparedStatement.executeUpdate();
        SingletonConnection.getConnection().commit();
    }
}
