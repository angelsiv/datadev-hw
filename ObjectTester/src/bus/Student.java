package bus;

import data.StudentDB;

import java.sql.Connection;

public class Student
{
    private int id;
    private String name;

    public Student() {}

    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
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

    public String toString()
    {
        return String.format(" %s | %s \n", this.id, this.name);
    }

    public static void add(Student s, Connection c)
    {
        //StudentDB.insert(s, c)
    }

    public static void remove(Student s, Connection c)
    {
        //StudentDB.delete(s, c)
    }

    public static void alter(Student s, Connection c)
    {
        //Call student DB to alter
    }

    public static void display(Connection c)
    {

    }
}
