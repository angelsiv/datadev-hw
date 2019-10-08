package client;
import java.util.Scanner;

public class LaSalleCompany {
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String input = new String();
		System.out.println("Input string: ");
		input = scan.nextLine();
		isDigit(input);
	}
	
	public static void isDigit(String value)
	{
		try
		{
			Double.parseDouble(value);
			System.out.println("This is a digit");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("This is not a digit");
		}
	}
}
