package bus;

import java.io.Serializable;

//Source for regex: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#lt

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

    public void setSerialNumber(int value) //will be assigned a random unique int
    {
        this.serialNumber = value;
    }

    public String getMake()
    {
        return this.make;
    }

    public void setMake(String value) throws Exception
    {
        if(!String.valueOf(value).matches("[a-zA-Z0-9]*"))
        {
            throw new Exception("Error: Must be non-numerical input");
        }
        this.make = value;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String value) throws Exception
    {
        if(!String.valueOf(value).matches("[a-zA-Z0-9]*"))
        {
            throw new Exception("Error: Must be non-numerical input");
        }
        this.model = value;
    }

    public int getTripCounter()
    {
        return tripCounter;
    }

    public void setTripCounter(int value) throws Exception
    {
        if(!String.valueOf(value).matches("\\d+"))
        {
            throw new Exception("Error: Must only contain digits");
        }
        this.tripCounter = value;
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
