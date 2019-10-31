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
        ArrayList<Person> personList = new ArrayList<>();
        ArrayList<Person> listFromFile = new ArrayList<>();

        personList.add(new Person(1000, "Angeline"));
        personList.add(new Person(1001, "Carole"));

        //Write to serialize file person.ser
        FileOutputStream fos = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(personList);

        //Read from serialize file person.ser
        FileInputStream fis = new FileInputStream("persons.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        listFromFile = (ArrayList<Person>)ois.readObject();

        System.out.println(listFromFile);

        System.out.println("\n Data From Compiler...\n");
        for (Person person : personList)
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
