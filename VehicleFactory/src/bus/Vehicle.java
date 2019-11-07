package bus;

import java.io.Serializable;

public abstract class Vehicle implements IMileageEfficiency, Serializable
{
    //Attributes
    private int serialNumber;
    private String make;
    private String model;
    protected int tripCounter;

    //Getters and Setters
    public int getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(int value)
    {
        this.serialNumber = value;
    }

    public String getMake()
    {
        return this.make;
    }

    public void setMake(String value)
    {
        this.make = value;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getTripCounter()
    {
        return tripCounter;
    }

    public void setTripCounter(int tripCounter)
    {
        this.tripCounter = tripCounter;
    }

    //Default constructor
    public Vehicle()
    {
        this.tripCounter = 0;
    }

    public Vehicle(int serialNumber, String make, String model)
    {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
    }

    //Common behaviours
    public void makeTrip(int tripCounter)
    {
        this.tripCounter = tripCounter;
    }

    //Override to String
    //Source for using string interpolation (format): https://en.wikipedia.org/wiki/String_interpolation#Java
    public String toString()
    {
        return String.format("S#: %s | Make: %s | Model: %s ", this.serialNumber, this.make, this.model);
    }
}
