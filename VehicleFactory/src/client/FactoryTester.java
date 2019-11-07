package client;

import bus.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
FACTORY TESTER IS USED FOR FUNCTION TESTING
 */

public class FactoryTester
{
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Vehicle> list = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {
        System.out.println("\t##TESTER APP##\n\n");

        MileagePredicate mileageComparator = new MileagePredicate();

        GasVehicle gVTest = new GasVehicle();
        gVTest.setSerialNumber(837);
        gVTest.setMake("MakeTest");
        gVTest.setModel("ModelTest");
        gVTest.setTripCounter(10);
        gVTest.setFuelConsumed(2);

        ElectricVehicle eVTest = new ElectricVehicle();
        eVTest.setSerialNumber(123);
        eVTest.setMake("MakeTest");
        eVTest.setModel("ModelTest");
        eVTest.setTripCounter(20);
        eVTest.setKWPowerConsumed(5);

        ElectricVehicle eVTest2 = new ElectricVehicle();
        eVTest2.setSerialNumber(345);
        eVTest2.setMake("MakeTest");
        eVTest2.setModel("ModelTest");
        eVTest2.setTripCounter(12);
        eVTest2.setKWPowerConsumed(2);

        list.add(gVTest);
        list.add(eVTest);
        list.add(eVTest2);


        System.out.println("Before Sorting");
        for(Vehicle item : list)
        {
            System.out.println(item);
        }

        /*
        list.sort(mileageComparator);

        System.out.println("After Sorting");
        for(Vehicle item : list)
        {
            System.out.println(item);
        }
        */

        int userInput;
        Vehicle searchedVehicle;

        System.out.print("SERIAL#: ");
        userInput = scan.nextInt();

        searchedVehicle = searchVehicle(userInput);
        System.out.print(searchedVehicle);
    }

    private static Vehicle searchVehicle(int serialNumber)
    {
        Vehicle searchedVehicle = null;
        for (Vehicle element : list)
        {
            if (serialNumber == element.getSerialNumber())
            {
                System.out.println(String.format("\nVehicle with serial number '%s' found: \n", serialNumber));
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
}
