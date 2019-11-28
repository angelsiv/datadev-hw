package bus;

import data.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class Student
{
    private int id;
    private String name;
    private Type type;

    public Student() {}

    public Student(int id, String name, Type type)
    {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString()
    {
        return String.format(" %s | %s | %s \n", this.id, this.name, this.type);
    }

    public static HashMap<Integer, Student> getList() throws SQLException {
        return StudentDB.getList();
    }

    public static int add(Student aStudent) throws SQLException {
        return StudentDB.insert(aStudent);
    }

    public static int remove(int key) throws SQLException {
        return StudentDB.delete(key);
    }

    public static int remove(Student aStudent) throws SQLException {
        return StudentDB.delete(aStudent);
    }

    public static Student search(int key) throws SQLException {
        return StudentDB.search(key);
    }

    public static Student search(String key) throws SQLException, SQLException {
        return StudentDB.search(key);
    }

    public static int modify(String value) {
        return StudentDB.update(value);
    }

    public static Exception createTable(Connection myConnection) throws SQLException {
        return StudentDB.createTable(myConnection);
    }
}
