package client;
import bus.*;
import data.*;

/* THIS IS A FUNCTION TESTER ONLY*/

public class CarTester
{
    public static void main(String[] args)
    {
        //Testing printing V
        Car c1 = new Car();
        System.out.println(c1);

        //Testing clone function V
        SportCar s1 = new SportCar();
        s1.setBrand("brands1");
        s1.setGasConsumption(1002.0f);
        SportCar s2 = new SportCar(s1);

        System.out.println(s1);
        System.out.println(s2);

        //Testing Race Car V
        RaceCar r1 = new RaceCar();
        r1.setSerialNumber(101);
        System.out.println(r1);
    }
}
