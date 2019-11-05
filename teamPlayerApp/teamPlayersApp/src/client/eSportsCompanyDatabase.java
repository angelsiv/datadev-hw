package client;
import bus.*;

import java.io.IOException;
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
	//private static ArrayList<Member> savedPersonnelList = new ArrayList<Member>();

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		//Retrieve all previously saved data
		personnelList = FileHandler.readFromFile();

		displayMainMenu();
	}

	/*
	BRIEF: Displays the main menu and its available options for the user
	PARAMS: n/a
	OUT: void
	 */
	private static void displayMainMenu() throws IOException, ClassNotFoundException
	{
		//Attributes
		String menuChoice;

		//Main Menu
		System.out.println("\n\n\t-- COMPANY DATABASE --\n\n"
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
		while(!ExceptionHandler.isDigit(menuChoice));

		//Once the user input is valid, allow for switch case
		if (ExceptionHandler.isDigit(menuChoice))
		{
			switch(menuChoice)
			{
				//ADD MEMBER
				case "1": addNewMember();
					break;

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
			saveData();
			displayMainMenu();
		}
	}

	/*
	BRIEF: Displays the current list of members in the database
	PARAMS: n/a
	OUT: void
	 */
	private static void displayDatabase() throws IOException, ClassNotFoundException
	{
		//sortList(savedPersonnelList);
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
	private static void addNewMember() throws IOException, ClassNotFoundException
	{
		String type;
		System.out.println("\t --ADD NEW MEMBER--\n");
		System.out.println("Member Type (player, coach, manager): ");
		type = scanner.next();
		switch(type)
		{
			case "player":
				personnelList.add(createPlayer());
				break;

			case "coach":
				personnelList.add(createCoach());
				break;

			case "manager":
				personnelList.add(createManager());
				break;

			default: break;
		}
		saveData();
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
		newPlayer.setFirstName(scanner.next());
		System.out.println("\nLAST NAME: ");
		newPlayer.setLastName(scanner.next());
		System.out.println("\nSALARY: \n");
		newPlayer.setSalary(scanner.nextDouble());
		System.out.println("\nTEAM NAME: \n");
		newPlayer.setTeamName(scanner.next());

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
		newPlayer.setContractEnd(e_year, e_month, e_day);

		System.out.println("Created: " + newPlayer.getFirstName() + " " + newPlayer.getLastName());
		return newPlayer;
	}

	/*
	BRIEF: Creates a new Coach with user inputs
	PARAMS: n/a
	OUT: Coach
	 */
	private static Coach createCoach()
	{
		Coach newCoach = new Coach();
		newCoach.setType(PersonnelType.Coach);
		newCoach.setId(assignID());

		//User inputs
		System.out.println("\nFIRST NAME: ");
		newCoach.setFirstName(scanner.next());
		System.out.println("\nLAST NAME: ");
		newCoach.setLastName(scanner.next());

		System.out.println("\nSALARY: \n");
		newCoach.setSalary(scanner.nextDouble());
		System.out.println("\nTEAM NAME: \n");
		newCoach.setTeamName(scanner.next());
		System.out.println("\nCOMPANY NAME: \n");
		newCoach.setCompanyName(scanner.next());

		System.out.println("\n CONTRACT START: YEAR: ");
		int s_year = scanner.nextInt();
		System.out.println("\n CONTRACT START: MONTH (1-12): ");
		int s_month = scanner.nextInt();
		System.out.println("\n CONTRACT START: DAY: ");
		int s_day = scanner.nextInt();
		newCoach.setContractStart(s_year, s_month, s_day);

		System.out.println("\n CONTRACT END: YEAR: ");
		int e_year = scanner.nextInt();
		System.out.println("\n CONTRACT END: MONTH (1-12): ");
		int e_month = scanner.nextInt();
		System.out.println("\n CONTRACT END: DAY: ");
		int e_day = scanner.nextInt();
		newCoach.setContractEnd(e_year, e_month, e_day);

		System.out.println("Created: " + newCoach.getFirstName() + " " + newCoach.getLastName());
		return newCoach;
	}

	/*
	BRIEF: Creates a new Manager with user inputs
	PARAMS: n/a
	OUT: Manager
	 */
	private static Manager createManager()
	{
		Manager newManager = new Manager();
		newManager.setType(PersonnelType.Manager);
		newManager.setId(assignID());

		//User inputs
		System.out.println("\nFIRST NAME: ");
		newManager.setFirstName(scanner.next());
		System.out.println("\nLAST NAME: ");
		newManager.setLastName(scanner.next());
		System.out.println("\nSALARY: \n");
		newManager.setSalary(scanner.nextDouble());
		System.out.println("\nSPONSOR: \n");
		newManager.setSponsoredCompany(scanner.next());

		System.out.println("Created: " + newManager.getFirstName() + " " + newManager.getLastName());
		return newManager;
	}

	/*
	BRIEF: Removes an existing member by ID number from the personnel list
	PARAMS: n/a
	OUT: void
	 */
	private static void removeMember() throws IOException, ClassNotFoundException
	{
		System.out.println("\t -- REMOVE PERSONNEL --\n");
		System.out.println("Enter ID: ");
		int idNumber = scanner.nextInt();
		Member memberToRemove = null;

		for (Member member : personnelList)
		{
			if(idNumber % member.getId() == 0)
			{
				memberToRemove = member; //found
				break;
			}
			else
			{
				System.out.println("Member with ID number [" + idNumber + "] does not exist.");
			}
		}
		if(memberToRemove != null)
		{
			System.out.println("Removing: " + memberToRemove);
			personnelList.remove(memberToRemove);
		}
	}

	/*
	BRIEF: Sorts an ArrayList of type Member by ID in descending order
	PARAMS: ArrayList<Member>
	OUT: void
	 */
	private static void sortList(ArrayList<Member> list) throws IOException, ClassNotFoundException
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

	/*
	BRIEF: Saves all changes made to the database to MemberDatabase.ser file
	PARAMS: n/a
	OUT: void
	 */
	private static void saveData() throws IOException, ClassNotFoundException
	{
		FileHandler.writeToFile(personnelList);
		/*for (Member member : personnelList)
		{
			System.out.println(member + "\n");
		}*/
		System.out.println("Saved..");
	}
}
