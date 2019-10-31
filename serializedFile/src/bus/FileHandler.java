package bus;

import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    public static void writeToFile(ArrayList<Person> list) throws IOException
    {
        //Write to serialize file person.ser
        FileOutputStream fos = new FileOutputStream("person.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(list);
        oos.close();
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Person> readFromFile() throws IOException, ClassNotFoundException
    {
        ArrayList<Person> list = new ArrayList<>();

        //Read from serialize file person.ser
        FileInputStream fis = new FileInputStream("person.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        list = (ArrayList<Person>)ois.readObject();
        ois.close(); //close the stream

        return list;
    }
}
