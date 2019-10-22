package client;
import bus.*;
import com.sun.deploy.security.SelectableSecurityManager;

import javax.print.ServiceUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FactoryTester
{


    public static void main(String[] args)
    {
        /*
        To effectively manage the stock of vehicles, you must implement the following tasks:
1.	Adding a new vehicle into a list of vehicles.
2.	Searching for a vehicle by serial number.
3.	Removing a specific vehicle from the list of vehicles.
4.	Listing vehicles, listing gasoline vehicles, listing electric vehicles
         */
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int menuChoice;

        //Main Menu
        do
        {
            DisplayMainMenu();
            System.out.print("\nSelect option (1 - 4): ");
            menuChoice = scan.nextInt();
        }
        while (menuChoice < 0 && menuChoice > 5);

        switch(menuChoice)
        {
            case 1: addVehicle(vehicleList);
            case 2: removeVehicle(vehicleList);
            case 3: displayVehicleList(vehicleList);
            case 4: ExitApplication();
            default: break;
        }
    }

    public static void DisplayMainMenu()
    {
        System.out.print("\t\n--MAIN MENU--");
    }

    public static void addVehicle(ArrayList<Vehicle> list)
    {
        list.add(vehicle);
        System.out.print("Successfully added a new Vehicle");
    }

    public static void removeVehicle(ArrayList<Vehicle> list)
    {
        System.out.println("\t\n--REMOVE VEHICLE--");
    }

    public static void displayVehicleList(ArrayList<Vehicle> list)
    {
        updateVehicleSorting(list);
        for (Vehicle element: list)
        {
            System.out.println(element);
        }
    }

    public static void updateVehicleSorting(ArrayList<Vehicle> list)
    {
        SerialNumberComparator serialNumberComparator = new SerialNumberComparator();
        list.sort(serialNumberComparator);
    }

    public static void ExitApplication()
    {
        System.exit(0);
    }
}
