package prod;
import bus.*;

import java.util.Scanner;

public class Tester
{
    public static void main(String[] args)
    {
        System.out.println("Version 2");
        Scanner scan = new Scanner(System.in);

        //Connect
        Connect currentConnection = data.SingletonConnection.getConnection();
        System.out.println("Connected");
    }
}
