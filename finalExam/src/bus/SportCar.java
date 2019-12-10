package bus;

import data.SportCarDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

public class SportCar extends Car implements IClonableCar
{
    private float gasConsumption;

    //default constructor
    public SportCar()
    {
        super();
        this.gasConsumption = 0.0f;
    }

    //constructor with parameters
    public SportCar(int serialNumber, String brand, String model, int numberOfSeats, LocalDate madeDate, float gasConsumption)
    {
        super(serialNumber, brand, model, numberOfSeats, madeDate);
        this.gasConsumption = gasConsumption;
    }

    //copy constructor
    public SportCar(SportCar sportCarCopy)
    {
        super(sportCarCopy.getSerialNumber(), sportCarCopy.getBrand(), sportCarCopy.getModel(), sportCarCopy.getNumberOfSeats(), sportCarCopy.getMadeDate());
        this.gasConsumption = sportCarCopy.getGasConsumption();
    }

    //getters and setters
    public float getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(float gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    @Override
    public Car clone() {
        return new SportCar(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Gas Consumed: %s ", this.gasConsumption);
    }

    //SQL Statements
    public static HashMap<Long, Car> getList() throws SQLException {
        return SportCarDB.getList();
    }

    public static int add(Car current) throws SQLException {
        return SportCarDB.insert(current);
    }

    public static int remove(Car current) throws SQLException {
        return SportCarDB.delete(current);
    }

    public static Car search(long key) throws SQLException {
        return SportCarDB.search(key);
    }

    public static int modify(String value) {
        return SportCarDB.update(value);
    }

    public static Exception createTable(Connection myConnection) throws SQLException {
        return SportCarDB.createTable(myConnection);
    }
}
