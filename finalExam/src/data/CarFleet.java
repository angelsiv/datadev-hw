package data;
import bus.*;

import java.sql.*;
import java.util.*;

public class CarFleet
{
    public HashMap<Integer, Car> carList;
    private static CarFleet instance = null;

    public CarFleet() {}

    public static CarFleet getInstance()
    {
        if (instance == null)
        {
            instance = new CarFleet();
        }
        return instance;
    }

    public static void setInstance(CarFleet instance)
    {
        CarFleet.instance = instance;
    }

    public void addCar(Car newCar)
    {
        //System.out.println("\n\t -- ADD NEW CAR -- ");
        carList.put(newCar.getSerialNumber(), newCar);
    }

    public void removeCar(int serialNumber)
    {
        //System.out.println("\n\t -- REMOVE A CAR BY SERIAL NUMBER-- ");
        if(searchCar(serialNumber))
        {
            System.out.println("Removing...");
            carList.remove(serialNumber);
        }
    }

    public void displayCarList()
    {
        System.out.println("\n\t -- CAR LIST -- ");
        for(Car car : carList.values())
        {
            System.out.println(car);
        }
    }

    public boolean searchCar(int serialNumber)
    {
        System.out.println("\n\t Searching for serial number... \n");
        if (carList.containsKey(serialNumber))
        {
            System.out.println("Found car with S#: " + serialNumber);
            System.out.println(carList.get(serialNumber));
            return true;
        }
        else
        {
            System.out.println("No existing car with S#: " + serialNumber);
            return false;
        }
    }

    public void sortCar()
    {
        //can compare using SNComparator too
        ArrayList<Integer> sortedList = new ArrayList<>(carList.keySet()); //get the serial Numbers
        Collections.sort(sortedList);
        System.out.println(sortedList);
    }
}
