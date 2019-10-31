package client;
import bus.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tester
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<Person> listFromConsole = new ArrayList<>();
        ArrayList<Person> listFromFile = new ArrayList<>();

        listFromConsole.add(new Person(1000, "Angeline"));
        listFromConsole.add(new Person(1001, "Carole"));

        System.out.println(listFromFile);

        FileHandler.writeToFile(listFromConsole);
        listFromFile= FileHandler.readFromFile();

        System.out.println("\n Data From Compiler...\n");
        for (Person person : listFromConsole)
        {
            System.out.println(person);
        }
        System.out.println("\n Data From File...\n");
        for (Person person : listFromFile)
        {
            System.out.println(person);
        }
    }
}
