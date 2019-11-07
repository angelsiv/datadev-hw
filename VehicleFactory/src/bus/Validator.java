package bus;

//This is the exception handler for user inputs in menus/switch cases
public class Validator
{
    //Default attributes for user input bounds
    private static int MIN_INPUT = 0;
    private static int MAX_INPUT = 0;

    /*
    BRIEF: Verifies if the String is a digit or not and that it is within the allowed bound. Catches error when string is not a digit
    PARAMS: String
    OUT: boolean
     */
    public static boolean isValidUserInput(String input)
    {
        try //verify that input can be parsed to integer
        {
            int userInput = Integer.parseInt(input);

            if (userInput >= MIN_INPUT && userInput <= MAX_INPUT) //verify that the digit is an existing choice
            {
                System.out.println("...\n");
                return true;
            }
            else //user selected non-existent choice
            {
                System.out.println("Error: Invalid choice.");
                return false;
            }
        }
        catch (Exception e) //catch non-digit user inputs
        {
            System.out.println(e);
            System.out.println("Error: your input contains non-numeral characters.");
            return false;
        }
    }

    /*
    BRIEF: Allows to modify user input bounds for different switch cases
    PARAMS: int, int
    OUT: void
     */
    public static void setBoundsForUserInput(int min, int max)
    {
        MIN_INPUT = min;
        MAX_INPUT = max;
    }

    /*
    BRIEF: Verifies that the string input contains digits only
    PARAMS: String
    OUT: boolean
     */
    public static boolean isDigit(String input)
    {
        try
        {
            int userInput = Integer.parseInt(input);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Error: your input contains non-numeral characters.");
            return false;
        }
    }
}
