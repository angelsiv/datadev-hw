package bus;

public class Validator
{
    try
    {
        Double.parseDouble();
        System.out.println("This is a digit");
    }
		catch(Exception e)
    {
        System.out.println(e);
        System.out.println("This is not a digit");
    }
}
