package client;
import bus.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
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

    public static void main(String[] args) throws Exception
    {
        //Load serialized file
        vehicleList = FileHandler.readFromFile(); //file doesn't exist yet so will break code

        //Start of the application
        displayMainMenu();
    }

    /*
    BRIEF: Displays the main menu which the user can interact with
    PARAMS: n/a
    OUT: void
     */
    private static void displayMainMenu() throws Exception {
        //Attributes
        String userInput;
        Validator.setBoundsForUserInput(1, 5); //this menu has options from 1 to 5

        do
        {
            //Print available options
            System.out.println("\n\t--MAIN MENU--\n\n"
                    + "1. Make Trip\n"
                    + "2. Add Vehicle\n"
                    + "3. Remove Vehicle\n"
                    + "4. Display Vehicle List\n"
                    + "5. Exit\n");

            System.out.println("\nSelect option (1 - 5): ");
            userInput = scan.next();
        }
        while (!Validator.isValidUserInput(userInput)); //verify options

        //after making sure input is valid
        if(Validator.isValidUserInput(userInput))
        {
            switch(userInput)
            {
                case "1": makeTrip(); break;
                case "2": addVehicle(); break;
                case "3": removeVehicle(); break;
                case "4": displayVehicleList(); displayListOptions(); break;
                case "5": exitApplication(); break;
                default: break;
            }
            saveData();
            displayMainMenu();
        }
    }

    /*
    BRIEF: Allows the user to select any existing vehicle in order to create a trip by setting its trip counter and fuel/power consumed
    PARAMS: n/a
    OUT: void
     */
    private static void makeTrip() throws Exception
    {
        String userInput;
        Vehicle tripVehicle;

        if(vehicleList.size() != 0) //execute if the list is not empty
        {
            System.out.println("\n\t -- CREATE A TRIP -- \n");
            System.out.println("Select a vehicle from the list:");
            displayVehicleList();
            do
            {
                System.out.println("\nEnter a serial number: \n");
                userInput = scan.next();
            }
            while(!Validator.isDigit(userInput));

            if(Validator.isDigit(userInput));
            {
                int serialNumber = Integer.parseInt(userInput);
                tripVehicle = searchVehicle(serialNumber);
                if(tripVehicle == null) //if after searching for a vehicle and it doesn't exist, terminate the function
                {
                    return;
                }

                System.out.println("Set trip counter (mi): \n");
                tripVehicle.setTripCounter(scan.nextInt());
                if(tripVehicle instanceof GasVehicle)
                {
                    System.out.println("Set fuel consumed (gallon): \n");
                    ((GasVehicle) tripVehicle).setFuelConsumed(scan.nextFloat());
                }
                else if(tripVehicle instanceof ElectricVehicle)
                {
                    System.out.println("Set power consumed (KW): \n");
                    ((ElectricVehicle) tripVehicle).setKWPowerConsumed(scan.nextFloat());
                }
                System.out.println("Making trip...");
                System.out.println(tripVehicle);
                saveData();
            }
        }
        else
        {
            System.out.println("Error: No existing vehicles to create a trip\n");
            System.out.println("Returning to main menu...\n");
        }
    }

    /*
    BRIEF: Lets the user select which type of vehicle to add to the list, and adds it to the vehicle list
    PARAMS: n/a
    OUT: void
     */
    private static void addVehicle() throws Exception
    {
        //Attributes
        String userInput;
        Validator.setBoundsForUserInput(1, 2); //only 2 options

        //Display user choices
        do
        {
            System.out.println("\t -- ADD A NEW VEHICLE --\n");
            System.out.println("1. Gas Vehicle\n");
            System.out.println("2. Electric Vehicle\n");
            System.out.println("\nSelect option (1 - 2): ");
            userInput = scan.next();
        }
        while (!Validator.isValidUserInput(userInput));

        if(Validator.isValidUserInput(userInput))
        {
            switch(userInput)
            {
                case "1": vehicleList.add(createGasVehicle()); break;
                case "2": vehicleList.add(createElectricVehicle()); break;
                default: break;
            }
            //saveData();
        }
    }

    private static GasVehicle createGasVehicle() throws Exception
    {
        GasVehicle newGVehicle = new GasVehicle();
        newGVehicle.setSerialNumber(assignID());

        System.out.println("\n\t -- ADDING NEW GAS VEHICLE --\n");
        //User inputs
        System.out.println("Vehicle Make: ");
        newGVehicle.setMake(scan.next());
        System.out.println("Vehicle Model: ");
        newGVehicle.setModel(scan.next());

        System.out.print("Successfully added a new Gas Vehicle\n");
        return newGVehicle;
    }

    private static ElectricVehicle createElectricVehicle() throws Exception
    {
        ElectricVehicle newEVehicle = new ElectricVehicle();
        newEVehicle.setSerialNumber(assignID());

        System.out.println("\n\t -- ADDING NEW ELECTRIC VEHICLE --\n");
        //User inputs
        System.out.println("Vehicle Make: ");
        newEVehicle.setMake(scan.next());
        System.out.println("Vehicle Model: ");
        newEVehicle.setModel(scan.next());

        System.out.print("Successfully added a new Electric Vehicle\n");
        return newEVehicle;
    }

    /*
    BRIEF: Lets user remove a vehicle from the vehicle list identified by its serial number
    PARAMS: n/a
    OUT: void
     */
    private static void removeVehicle() throws IOException
    {
        String userInput;
        do
        {
            System.out.println("\n\t--REMOVE AN EXISTING VEHICLE--\n");
            System.out.println("Enter the serial number of vehicle to remove: \n");
            userInput = scan.next();
        }
        while(!Validator.isDigit(userInput));

        if(Validator.isDigit(userInput))
        {
            int serialNumber = Integer.parseInt(userInput);
            System.out.println(String.format("Removing vehicle #'%s'", serialNumber));
            vehicleList.remove(searchVehicle(serialNumber));
            saveData();
        }
    }

    private static void displayVehicleList() throws Exception
    {
        System.out.println("\n\n\t -- VEHICLE LIST --\n");

        if (vehicleList.size() == 0)
        {
            System.out.println("\t(empty)");
        }

        for (Vehicle element: vehicleList) //loop through each vehicle in the vehicle list
        {
            System.out.println(element);
        }
        //displayListOptions();
    }

    /*
    BRIEF: Lets user sort the vehicle list by a condition, or to search a vehicle by a condition
    PARAMS: n/a
    OUT: void
     */
    private static void displayListOptions() throws Exception
    {
        //Attributes
        String userInput;
        Validator.setBoundsForUserInput(1, 7);

        do
        {
            System.out.println("\n1. Sort by serial number\n");
            System.out.println("2. Sort by gas vehicles only\n");
            System.out.println("3. Sort by electric vehicles only\n");
            System.out.println("4. Sort by mileage\n");
            System.out.println("5. Search a vehicle by serial number\n");
            System.out.println("6. Search a vehicle by brand\n");
            System.out.println("7. Return to the main menu\n");
            System.out.println("\nSelect option (1 - 7): \n");
            userInput =  scan.next();
        }
        while (!Validator.isValidUserInput(userInput));

        if(Validator.isValidUserInput(userInput))
        {
            switch(userInput)
            {
                case "1": sortVehiclesBySerialNumber(vehicleList); break;
                case "2": displayGasVehicles(); break;
                case "3": displayElectricVehicles(); break;
                case "4": sortVehiclesByMileage(vehicleList); break;
                case "5": searchVehicle(); break;
                case "6": searchVehicleByBrand(); break;
                case "7": displayMainMenu(); break;
                default: break;
            }
            displayVehicleList();
            displayListOptions();
        }
    }

    /*
    BRIEF: Searches a vehicle through the vehicle list with a matching serial number input, and returns a Vehicle to use in other functions
    PARAMS: int
    OUT: Vehicle
     */
    private static Vehicle searchVehicle(int serialNumber)
    {
        Vehicle searchedVehicle = null;
        for (Vehicle element : vehicleList)
        {
            if (serialNumber == element.getSerialNumber())
            {
                //System.out.println(String.format("\nVehicle with serial number '%s' found: \n", serialNumber));
                //System.out.println(element);
                searchedVehicle = element;
                break;
            }
        }
        if (searchedVehicle == null)
        {
            System.out.println(String.format("\nVehicle with serial number '%s' does not exist.", serialNumber));
        }
        return searchedVehicle;
    }

    /*
    BRIEF: Searches a vehicle through the vehicle list with a matching serial number input and prints it
    PARAMS: n/a
    OUT: void
     */
    private static void searchVehicle()
    {
        String userInput;

        if(vehicleList.size() == 0)
        {
            System.out.println("Error: No existing vehicles to search for");
        }
        else
        {
            do
            {
                System.out.println("\n\t -- SEARCH VEHICLE BY SERIAL NUMBER --\n");
                System.out.println("Enter a serial number: \n");
                userInput = scan.next();
            }
            while(!Validator.isDigit(userInput));

            if(Validator.isDigit(userInput))
            {
                int serialNumber = Integer.parseInt(userInput);

                for(Vehicle element : vehicleList)
                {
                    if(serialNumber % element.getSerialNumber() == 0)
                    {
                        System.out.print(String.format("\nFound vehicle with serial '%s':\n", serialNumber));
                        System.out.println(element);
                        break;
                    }
                    else
                    {
                        System.out.println(String.format("\nVehicle with serial number '%s' does not exist.\n", serialNumber));
                    }
                }
            }
        }
    }

    /*
    BRIEF: Lists all vehicles of type Gas from the vehicle list
    PARAMS: n/a
    OUT: void
     */
    private static void displayGasVehicles()
    {
        boolean foundAnyGasVehicle = false;

        System.out.println("\n\t Displaying all gas vehicles...\n");
        for(Vehicle element : vehicleList)
        {
            if (element instanceof GasVehicle)
            {
                System.out.println(element);
                foundAnyGasVehicle = true;
            }
        }
        if(!foundAnyGasVehicle)
        {
            System.out.print("Error: No existing gas vehicle\n");
        }
    }

    /*
    BRIEF: Lists all vehicles of type Electric from the vehicle list
    PARAMS: n/a
    OUT: void
     */
    private static void displayElectricVehicles()
    {
        boolean foundAnyElectricVehicle = false;

        System.out.println("\n\t Displaying all electric vehicles...\n");
        for(Vehicle element : vehicleList)
        {
            if (element instanceof ElectricVehicle)
            {
                System.out.println(element);
                foundAnyElectricVehicle = true;
            }
        }
        if (!foundAnyElectricVehicle)
        {
            System.out.print("Error: No existing electric vehicle\n");
        }
    }

    /*
    BRIEF: Sorts a list of vehicles by their mileage in a descending order
    PARAMS: ArrayList<Vehicle>
    OUT: void
     */
    private static void sortVehiclesByMileage(ArrayList<Vehicle> list) throws Exception
    {
        System.out.println("\n\t Sorting by mileage...\n");
        MileagePredicate mileageComparator = new MileagePredicate();
        list.sort(mileageComparator);
        displayVehicleList();
    }

    /*
    BRIEF: Sorts a list of vehicles by their serial number using SerialNumberPredicate
    PARAMS: ArrayList<Vehicle>
    OUT: void
     */
    private static void sortVehiclesBySerialNumber(ArrayList<Vehicle> list) throws Exception
    {
        System.out.println("\n\t Sorting by serial number...\n");
        SerialNumberPredicate serialNumberComparator = new SerialNumberPredicate();
        list.sort(serialNumberComparator);
        displayVehicleList();
    }

    /*
    BRIEF: Searches a vehicle through the vehicle list with a matching vehicle make input and prints them
    PARAMS: n/a
    OUT: void
     */
    private static void searchVehicleByBrand()
    {
        //Attributes
        String userInput;

        System.out.println("\n\t -- SEARCH VEHICLE BY BRAND --\n");
        System.out.println("Enter a brand: \n");
        userInput = scan.next();

        if(vehicleList.size() == 0)
        {
            System.out.println("\nError: No existing vehicles to search for\n");
            return; //return to listing options
        }

        for(Vehicle element : vehicleList)
        {
            if(userInput.equals(element.getMake()))
            {
                System.out.print(String.format("\nFound vehicle(s) of brand '%s':\n", userInput));
                System.out.println(element);
                break;
            }
            else
            {
                System.out.println(String.format("\nVehicle of brand '%s' does not exist.\n", userInput));
            }
        }
    }

    /*
    BRIEF: Saves user data using file serialization
    PARAMS: n/a
    OUT: void
     */
    private static void saveData() throws IOException
    {
        FileHandler.writeToFile(vehicleList);
        System.out.print("Saving data...\n");
    }

    /*
    BRIEF: Returns a random unique integer to use as a unique serial number for vehicles
    PARAMS: n/a
    OUT: int
     */
    private static int assignID()
    {
        Random rand = new Random();
        while(true) //while there is still any available int number to use
        {
            int id = rand.nextInt(99999);
            if(!alreadyUsedIDs.contains(id))
            {
                alreadyUsedIDs.add(id);
                return id;
            }
        }
    }

    /*
    BRIEF: Allows to terminate application/console
    PARAMS: n/a
    OUT: void
     */
    private static void exitApplication()
    {
        System.out.println("Exiting application confirmed...");
        System.exit(0);
    }
}
