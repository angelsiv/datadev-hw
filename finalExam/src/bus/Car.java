package bus;

import com.sun.javafx.binding.StringFormatter;

import java.time.LocalDate;

public class Car implements IClonableCar
{
    private int serialNumber;
    private String brand;
    private String model;
    private int numberOfSeats;
    private LocalDate madeDate;

    //Default constructor
    public Car()
    {
        this.serialNumber = 0;
        this.brand = null;
        this.model = null;
        this.numberOfSeats = 0;
        this.madeDate = LocalDate.now();
    }

    //Constructors with parameters
    public Car(int serialNumber, String brand, String model, int numberOfSeats, LocalDate madeDate)
    {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.madeDate = madeDate;
    }

    //Copy constructor
    public Car(Car carCopy)
    {
        this.serialNumber = carCopy.getSerialNumber();
        this.brand = carCopy.getBrand();
        this.model = carCopy.getModel();
        this.numberOfSeats = carCopy.numberOfSeats;
        this.madeDate = carCopy.madeDate;
    }

    //Getters and setters
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDate getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(LocalDate madeDate) {
        this.madeDate = madeDate;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

    @Override
    public String toString() {
        return String.format("S#: %s | Brand: %s | Model: %s | Seats: %s | Made Date: %s ",
                this.serialNumber, this.brand, this.model, this.numberOfSeats, this.madeDate);
    }
}
