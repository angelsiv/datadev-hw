package client;
import bus.*;
import data.*;

import data.SingletonConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CompanyTester
{
    public static void main(String[] args) throws SQLException
    {
        /*
        SingletonConnectionDB.getConnection();
        Scanner scan = new Scanner(System.in);

        ///Display Students
        Statement myStatement = null;
        ResultSet myResultSet = null;

        String sqlStmt = "SELECT * FROM student";
        myStatement = SingletonConnectionDB.getConnection().createStatement();
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
        myPreparedStatement = SingletonConnectionDB.getConnection().prepareStatement(sqlStmt);
        myPreparedStatement.setInt(1, id);
        myPreparedStatement.setString(2, name);

        myPreparedStatement.executeUpdate();
        SingletonConnectionDB.getConnection().commit();
        */

        try {
            System.out.println("\n\n......Adding a Student  to the table Student.........\n");
            Student newStudent = new Student(1, "alex", Type.Parttime);
            String msg;
            if (Student.add(newStudent) > 0) {
                msg = ".......Student added with success........";
            } else {
                msg = "...Studentnot added with success...";
            }

            System.out.println(msg);
            System.out.println("\n\n............ Display all students............\n");
            HashMap<Integer, Student> hashMapStudents = Student.getList();
            Iterator var5 = hashMapStudents.values().iterator();

            while(var5.hasNext()) {
                Student aStudent = (Student)var5.next();
                System.out.println(aStudent);
            }
        } catch (SQLException var6) {
            System.out.println(var6.getMessage());
        } catch (Exception var7) {
            System.out.println(var7.getMessage());
        }

        System.out.println("\n\t END APPLICATION");
        System.exit(0);
    }
}
