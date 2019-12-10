package data;

import bus.*;
import java.io.*;
import java.util.HashMap;

public class FileHandler
{
    public static void writeToFile(HashMap<Integer, Car> list) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("fleet.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Car> readFromFile() throws IOException, ClassNotFoundException
    {
        HashMap<Integer, Car> list = new HashMap<Integer, Car>();

        FileInputStream fis = new FileInputStream("fleet.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        list = (HashMap<Integer, Car>)ois.readObject();
        ois.close();

        return list;
    }
}
