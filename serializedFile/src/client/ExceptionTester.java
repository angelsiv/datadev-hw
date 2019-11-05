package client;
import bus.*;

import java.util.Scanner;

public class ExceptionTester
{
    public static void main(String[] args)
    {
        Person p1 = new Person();
        Scanner scan = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n id:");
            try
            {
                System.out.println("\n id: ");
                p1.setID(scan.nextInt());
                break;
            }
            catch(NumberFormatException nEx)
            {
                System.out.print("Must be digit only");
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        while(true)
        {
            System.out.println("\n id:");
            try
            {
                System.out.println("\n name: ");
                p1.setName(scan.next());
                break;
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
