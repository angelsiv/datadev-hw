package bus;
import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    public static void writeToFile(ArrayList<Member> list) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("MemberDatabase.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Member> readFromFile() throws IOException, ClassNotFoundException
    {
        ArrayList<Member> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream("MemberDatabase.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        list = (ArrayList<Member>)ois.readObject();
        ois.close();

        return list;
    }
}
