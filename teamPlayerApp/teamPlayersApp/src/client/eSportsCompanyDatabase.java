package client;
import bus.*;
import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/*
My application is a database for personnel part of an eSports Company. You can view the current database, add new employees (player, coach, manager) and remove them.
 */
public class eSportsCompanyDatabase {

	//Input scanner
	private static Scanner scanner = new Scanner(System.in);

	//Collections
	private static ArrayList<Member> personnelList = new ArrayList<Member>();
	private static ArrayList<Integer> alreadyUsedIDs = new ArrayList<Integer>();

	public static void main(String[] args) 
	{
		//Attributes
		String menuChoice;

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
		while(!Validator.isDigit(menuChoice));

		//Once the user input is valid, allow for switch case
		if (Validator.isDigit(menuChoice))
		{
			switch(menuChoice)
			{
			//ADD MEMBER
			case "1": addNewMember();

			//REMOVE MEMBER
			case "2": removeMember();
			break;

			//DISPLAY DATABASE
			case "3": displayDatabase();
			break;

			//EXIT PROGRAM
			case "4": System.out.println("Exiting Program...");
			System.exit(0);
			break;
			
			default: break;
			}
		}
	}

	/*
	BRIEF: Displays the current list of members in the database
	PARAMS: n/a
	OUT: void
	 */
	private static void displayDatabase()
	{
		sortList(personnelList);
		System.out.println("\t -- DATABASE -- \n");
		for(Member members : personnelList)
		{
			System.out.println(members);
		}
	}

	/*
	BRIEF: Adds new members to the list of personnel
	PARAMS: n/a
	OUT: void
	 */
	private static void addNewMember()
	{
		String type = null;

		System.out.println("\t --ADD NEW MEMBER--\n");
		System.out.println("Member Type (player, coach, manager): ");
		type = scanner.nextLine();
		switch(type)
		{
			case "player":
				personnelList.add(createPlayer());
				break;

			case "coach":
				//create coach
				break;

			case "manager":
				//create manager
				break;

			default: break;
		}
	}

	/*
	BRIEF: Creates a new Player with user inputs
	PARAMS: n/a
	OUT: Player
	 */
	private static Player createPlayer()
	{
		Player newPlayer = new Player();
		newPlayer.setType(PersonnelType.Player);
		newPlayer.setId(assignID());

		//User inputs
		System.out.println("\nFIRST NAME: ");
		newPlayer.setFirstName(scanner.nextLine());
		System.out.println("\nLAST NAME: ");
		newPlayer.setLastName(scanner.nextLine());
		System.out.println("\nSALARY: \n");
		newPlayer.setSalary(scanner.nextDouble());
		System.out.println("\nTEAM NAME: \n");

		System.out.println("\n CONTRACT START: YEAR: ");
		int s_year = scanner.nextInt();
		System.out.println("\n CONTRACT START: MONTH (1-12): ");
		int s_month = scanner.nextInt();
		System.out.println("\n CONTRACT START: DAY: ");
		int s_day = scanner.nextInt();
		newPlayer.setContractStart(s_year, s_month, s_day);

		System.out.println("\n CONTRACT END: YEAR: ");
		int e_year = scanner.nextInt();
		System.out.println("\n CONTRACT END: MONTH (1-12): ");
		int e_month = scanner.nextInt();
		System.out.println("\n CONTRACT END: DAY: ");
		int e_day = scanner.nextInt();
		newPlayer.setContractStart(e_year, e_month, e_day);

		System.out.println("Created: " + newPlayer);
		return newPlayer;
	}

	//create coach func

	//create manager func

	/*
	BRIEF: Removes an existing member by ID number from the personnel list
	PARAMS: n/a
	OUT: void
	 */
	private static void removeMember()
	{
		System.out.println("\t -- REMOVE PERSONNEL --\n");
		System.out.println("Enter ID: ");
		int idNumber = scanner.nextInt();

		for (Member member : personnelList)
		{
			if(idNumber % member.getId() == 0)
			{
				System.out.println("Removing: " + member);
				personnelList.remove(member);
			}
			else
			{
				System.out.println("Member with ID number [" + idNumber + "] does not exist.");
			}
		}
	}

	/*
	BRIEF: Sorts an ArrayList of type Member by ID in descending order
	PARAMS: ArrayList<Member>
	OUT: void
	 */
	private static void sortList(ArrayList<Member> list)
	{
		IDPredicate idComparator = new IDPredicate();
		list.sort(idComparator);
	}

	/*
	BRIEF: Creates a random unique ID number
	PARAMS: n/a
	OUT: int
	 */
	private static int assignID()
	{
		Random rand = new Random();
		while(true)
		{
			int id = rand.nextInt(9999);
			if(!alreadyUsedIDs.contains(id))
			{
				alreadyUsedIDs.add(id);
				return id;
			}
		}
	}
}
