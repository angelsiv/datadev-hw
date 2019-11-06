package bus;
import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    public static void writeToFile(ArrayList<Vehicle> list) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("VehiclesData.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Vehicle> readFromFile() throws IOException, ClassNotFoundException
    {
        ArrayList<Vehicle> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream("VehiclesData.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        list = (ArrayList<Vehicle>)ois.readObject();
        ois.close();

        return list;
    }
}
