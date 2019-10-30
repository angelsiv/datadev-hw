package bus;

public class Validator {

    public void validate(String value) {
        try
        {
            Double.parseDouble(value);
            System.out.println("This is a digit");
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("This is not a digit");
        }
    }
}
