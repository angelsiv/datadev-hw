package client;
import bus.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Database Development Project -- Vehicle Factory Application by Angeline Siv
 * Code is similarly based off my 'teamPlayersApp Project' (eSportsCompanyDatabase Project) with extra optimization
 */

public class FactoryApplication
{
    //Scanner to scan for user inputs
    private static Scanner scan = new Scanner(System.in);

    //Global variables
    private static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private static ArrayList<Integer> alreadyUsedIDs = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //Retrieve serialized file
        //vehicleList = FileHandler.readFromFile(); //file doesn't exist yet so will break code

        //Main Menu
        displayMainMenu();
    }

    /*
    BRIEF: Displays the main menu which the user can interact with
    PARAMS: n/a
    OUT: void
     */
    private static void displayMainMenu() throws IOException, ClassNotFoundException
    {
        //Attributes
        String userInput;
        Validator.setBoundsForUserInput(1, 4); //this menu has options from 1 to 4

        do
        {
            //Print available options
            System.out.println("\t--MAIN MENU--\n");
            System.out.println("1. Add Vehicle\n");
            System.out.println("2. Remove Vehicle\n");
            System.out.println("3. Display Vehicle List\n");
            System.out.println("4. Exit\n\n");
            System.out.println("\nSelect option (1 - 4): ");
            userInput = scan.next();
        }
        while (!Validator.isDigit(userInput)); //verify options

        //after making sure input is valid
        if(Validator.isDigit(userInput))
        {
            switch(userInput)
            {
                case "1": addVehicle(); break;
                case "2": removeVehicle(); break;
                case "3": displayVehicleList(); break;
                case "4": ExitApplication(); break;
                default: break;
            }
            saveData();
            displayMainMenu();
        }
    }

    //1.	Adding a new vehicle into a list of vehicles.
    private static void addVehicle() throws IOException, ClassNotFoundException
    {
        //Attributes
        String userInput;
        Validator.setBoundsForUserInput(1, 2);

        //Display user choices
        do
        {
            System.out.println("\t -- ADD NEW VEHICLE --\n");
            System.out.println("1. Gas Vehicle\n");
            System.out.println("2. Electric Vehicle\n");
            System.out.println("\nSelect option (1 - 2): ");
            userInput = scan.next();
        }
        while (!Validator.isDigit(userInput));

        if(Validator.isDigit(userInput))
        {
            switch(userInput)
            {
                case "1": vehicleList.add(createGasVehicle()); break;
                case "2": vehicleList.add(createElectricVehicle()); break;
                default: break;
            }
            saveData();
        }
    }

    private static GasVehicle createGasVehicle()
    {
        GasVehicle newGVehicle = new GasVehicle();

        //User inputs here

        System.out.print("Successfully added a new Gas Vehicle");
        return newGVehicle;
    }

    private static ElectricVehicle createElectricVehicle()
    {
        ElectricVehicle newEVehicle = new ElectricVehicle();

        //User inputs here

        System.out.print("Successfully added a new Electric Vehicle");
        return newEVehicle;
    }

    //3.	Removing a specific vehicle from the list of vehicles.
    private static void removeVehicle()
    {
        System.out.println("\t\n--REMOVE VEHICLE--");
    }

    //4.	Listing vehicles, listing gasoline vehicles, listing electric vehicles
    private static void displayVehicleList()
    {
        //display current unedited list
        for (Vehicle element: vehicleList)
        {
            System.out.println(element);
        }

        //func to sort list
        updateVehicleSorting(vehicleList);
        // func to search by id using SerialNumberComparator
        // func to list gas or electric only using instanceof
    }

    //2.	Searching for a vehicle by serial number.
    private static void searchVehicle()
    {

    }

    /*
    BRIEF: Sorts a list of vehicles by their ID using SerialNumberPredicate
    PARAMS: ArrayList<Vehicle>
    OUT: void
     */
    private static void updateVehicleSorting(ArrayList<Vehicle> list)
    {
        SerialNumberPredicate serialNumberComparator = new SerialNumberPredicate();
        list.sort(serialNumberComparator);
    }

    /*
    BRIEF: Saves user data to using file serialization
    PARAMS: n/a
    OUT: void
     */
    private static void saveData() throws IOException, ClassNotFoundException
    {
        //use stream input/output
        System.out.print("Saving data...");
    }

    /*
    BRIEF: Allows to terminate application/console
    PARAMS: n/a
    OUT: void
     */
    private static void ExitApplication()
    {
        System.out.println("Exiting application confirmed...");
        System.exit(0);
    }
}
