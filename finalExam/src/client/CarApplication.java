package client;
import bus.Car;
import bus.SportCar;
import data.CarFleet;
import data.FileHandler;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/*THIS IS THE MAIN APPLICATION WHICH MANAGES CAR INFORMATION (PART I: Q6)*/

public class CarApplication
{
    //Global variables
    private static Scanner scanner = new Scanner(System.in);
    private static CarFleet carFleet = new CarFleet();

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //FileHandler.writeToFile(carFleet.carList); used once to create the file

        //retrieve serialized file
        FileHandler.readFromFile();

        //display menu
        displayMenu();
    }

    private static void displayMenu() throws SQLException {
        //Attributes
        int userInput;

        System.out.println("\n\t-- MAIN MENU --\n");
        System.out.println
                ("1. Add a new car\n" +
                "2. Remove existing car\n" +
                "3. View list of cars\n " +
                "4. Exit application\n");

        do //verify user option exists
        {
            System.out.println("Choose an option (1-4): ");
            userInput = scanner.nextInt();
        } while (userInput < 0 && userInput >= 4);


        switch(userInput)
        {
            case 1: carFleet.addCar(createCar()); break;
            case 2: removeCar(); break;
            case 3: carFleet.displayCarList(); SportCar.getList(); break;
            case 4: exitApp(); break;
            default: break;
        }
    }

    public static Car createCar() throws SQLException {
        System.out.println("Creating new sport car...");
        Car newCar = new SportCar();
        SportCar.add(newCar); //add to DB
        return newCar;
    }

    public static void removeCar() throws SQLException {
        int userInput;
        System.out.println("Enter SN: ");
        userInput = scanner.nextInt();
        SportCar.remove(carFleet.carList.get(userInput));
        carFleet.removeCar(userInput);
    }

    private static void exitApp()
    {
        System.out.println("\n\t Exiting application... ");
        System.exit(0);
    }

    //Write to fleet.ser file
    private static void saveData() throws IOException
    {
        FileHandler.writeToFile(carFleet.carList);
    }
}
