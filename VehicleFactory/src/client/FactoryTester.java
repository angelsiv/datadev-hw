package client;

import bus.*;

public class FactoryTester
{
    public static void main(String[] args)
    {
        GasVehicle gVTest = new GasVehicle();
        gVTest.setSerialNumber(837);
        gVTest.setMake("MakeTest");
        gVTest.setModel("ModelTest");

        System.out.println(gVTest);
    }
}
