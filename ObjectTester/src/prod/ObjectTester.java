package prod;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.DriverManager;
import java.util.Scanner;

public class ObjectTester {
    public static void main(String[] args) throws SQLException
    {
        Scanner scan = new Scanner(System.in);

        Connection myConnection = null;
        String username = "sys as sysdba";
        String pwd = "a439641d";
        String service = "localhost";
        String url = "jdbc:oracle:thin:";

        myConnection = DriverManager.getConnection(url + username + "/" + pwd + "@" + service);
        System.out.println("Connection established...");

        String sqlQuery = "select * from student";
        Statement myStatement = null;
        ResultSet myResultSet = null;

        myStatement = myConnection.createStatement();
        myResultSet = myStatement.executeQuery(sqlQuery);

        while(myResultSet.next())
        {
            String id = myResultSet.getString(1);
            String name = myResultSet.getString(2);
            System.out.println(id + "|" + name);
        }

        System.out.println("\n input new student \n");
        System.out.println("id: ");
        int stud_id = scan.nextInt();
        scan.nextLine();
        System.out.println("name: ");
        String stud_name = scan.nextLine();

        String sqlSmt = "insert into student values(?, ?)";
        PreparedStatement myPrepStmt = null;
        myPrepStmt = myConnection.prepareStatement(sqlSmt);
        myPrepStmt.setInt(1, stud_id);
        myPrepStmt.setString(2, stud_name);
        myPrepStmt.executeUpdate();

        //myConnection.commit();
        myConnection.close();
        System.out.println("\n\n End ojdbc application\n\n");
    }
}
