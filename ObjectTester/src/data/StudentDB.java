package data;
import bus.*;
import java.sql.*;
import java.util.HashMap;

public class StudentDB
{
    ///this should have the functions for inserting, removing and update student with the SQL commands.
    public StudentDB() {}

    public static Exception createTable(Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "create table Student (id number primary key not null , name varchar(50), type varchar(15))";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception getTableDescription(Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "desc Student; ";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception alterTable(int id, Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "alter  table Student add constraint pk_id primary key(id);";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static Exception dropTable(Connection currentConnection) throws SQLException {
        Statement currentStatement = null;
        String sqlString = "drop table Student;";
        currentStatement = currentConnection.createStatement();
        currentStatement.execute(sqlString);
        currentConnection.commit();
        currentConnection.close();
        return null;
    }

    public static HashMap<Integer, Student> getList() throws SQLException {
        HashMap<Integer, Student> maListe = new HashMap();
        Connection myConnection = SingletonConnectionDB.getConnection();
        String query = "select * from Student";
        Statement myStatement = myConnection.createStatement();
        ResultSet resultSet = myStatement.executeQuery(query);

        while(resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            Type type = resultSet.getString("type") == "FullTime" ? Type.Fulltime : Type.Parttime;
            Student aStudent = new Student(Integer.parseInt(id), name, type);
            maListe.put(aStudent.getId(), aStudent);
        }

        myConnection.close();
        return maListe;
    }

    public static int insert(Student aStudent) throws SQLException {
        //int succes = true;
        Connection myConnection = SingletonConnectionDB.getConnection();
        Statement myStatement = myConnection.createStatement();
        String requete = "insert into Student (id, name, type)values (" + aStudent.getId() + "," + "'" + aStudent.getName() + "'" + "," + "'" + aStudent.getType() + "'" + ")";
        int success = myStatement.executeUpdate(requete);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static int delete(Student aStudent) throws SQLException {
        //int success = true;
        Connection myConnection = SingletonConnectionDB.getConnection();
        Statement myStatement = myConnection.createStatement();
        String requete = "delete from Student where id=" + aStudent.getId();
        int success = myStatement.executeUpdate(requete);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static int delete(int key) throws SQLException {
        //int success = true;
        Connection myConnection = SingletonConnectionDB.getConnection();
        Statement myStatement = myConnection.createStatement();
        String requete = "delete from Student where id=" + key;
        int success = myStatement.executeUpdate(requete);
        myConnection.commit();
        myConnection.close();
        return success;
    }

    public static Student search(int key) throws SQLException {
        Connection myConnection = SingletonConnectionDB.getConnection();
        Statement myStatement = myConnection.createStatement();
        String request = "SELECT * FROM Student WHERE ID = " + key + " ;";
        ResultSet myResultSet = myStatement.executeQuery(request);
        Student aStudent = null;
        Type type = myResultSet.getString("type") == "FullTime" ? Type.Fulltime : Type.Parttime;
        if (myResultSet.next()) {
            aStudent = new Student(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getString("type") == "FullTime" ? Type.Fulltime : Type.Parttime);
        }

        return aStudent;
    }

    public static Student search(String key) throws SQLException {
        Connection myConnection = SingletonConnectionDB.getConnection();
        Statement myStatement = myConnection.createStatement();
        String request = "SELECT * FROM Student WHERE name = " + key + " ;";
        ResultSet myResultSet = myStatement.executeQuery(request);
        Student aStudent = null;
        if (myResultSet.next()) {
            aStudent = new Student(myResultSet.getInt("id"), myResultSet.getString("name"), myResultSet.getString("type") == "FullTime" ? Type.Fulltime : Type.Parttime);
        }
        return aStudent;
    }

    public static int update(String value) {
        return 0;
    }
}
