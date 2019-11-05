package bus;

import java.time.temporal.ValueRange;

public class ExceptionHandler
{
    //To verify that the user input is an integer
    public static boolean isDigit(String value)
    {
        try
        {
            int choice = Integer.parseInt(value);
            if (choice > 0 && choice <= 4)
            {
                System.out.println("Entered successfully...\n");
                return true;
            }
            else //this is not functioning
            {
                System.out.println("Error: Invalid choice.");
                return false;
            }
            /*System.out.println("Entered successfully...\n");
            return true;*/
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Error: your input contains non-numeral characters.");
            return false;
        }
    }

    /*
    public static boolean isValidChoice(int value)
    {
        try
        {
            if (value > 0 && value <= 4)
            {
                System.out.println("Entered successfully...\n");
                return true;
            }
            else //this is not functioning
            {
                //System.out.println("Error: Invalid choice.");
                return false;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
            System.out.println("Error: Invalid choice. Please choose between 1 and 4");
            return false;
        }
    }*/
}
