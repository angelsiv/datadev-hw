package client;
import bus.*;
import java.util.ArrayList;
import java.util.Scanner;

public class eSportsCompanyDatabase {

	public static void main(String[] args) 
	{
		//Attributes
		String menuChoice;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> personnelList = new ArrayList<Member>();
		
		//Main Menu
		System.out.println("\t-- COMPANY DATABASE --\n\n" 
		+ "1. Add new personnel\n" 
		+ "2. Remove existing personnel\n"
		+ "3. View current Database\n"
		+ "4. Exit\n\n");
		
		//Asks for an user input while the precedent input is not valid
		do
		{
			System.out.println("Input choice (1-4): \n");
			menuChoice = scanner.next();
		}
		while(!isDigit(menuChoice));
		
		//Once the user input is valid, allow for switch case
		if (isDigit(menuChoice))
		{
			switch(menuChoice)
			{
			case "1": //add member
			break; 
			
			case "2": //remove member
			break;
			
			case "3": displayDatabase();
			break;
			
			case "4": System.out.println("Exiting Program...");
			System.exit(0);
			break;
			
			default: break;
			}
		}
	}
	
	public static void displayDatabase()
	{
		System.out.println("\t -- DATABASE -- \n");
	}
	
	public static Member addNewMember()
	{
		return new Member();
	}
	
	public static Member removeMember()
	{
		return new Member();
	}
	
	//To verify that the user input is an integer
	public static boolean isDigit(String value)
	{
		try
		{
			int choice = Integer.parseInt(value);
			if (choice > 0 || choice <= 4)
			{
				System.out.println("Entered successfully...\n");
				return true;
			}
			else //this is not functioning
			{
				System.out.println("Error: Invalid choice.");
				return false;
			}
			try
			{
				value.contains()
			}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("Error: Invalid choice. Please choose between 1 and 4");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("Error: your input contains non-numeral characters.");
			return false;
		}


	}
}
