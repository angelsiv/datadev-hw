package client;

import bus.*;

import java.util.ArrayList;

public class FactoryTester
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
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

        list.sort(mileageComparator);

        System.out.println("After Sorting");
        for(Vehicle item : list)
        {
            System.out.println(item);
        }
    }
}
