package bus;

public abstract class Vehicle implements IMileageEfficiency
{
    //Attributes
    private int serialNumber;
    private String make;
    private String model;
    protected float tripCounter;

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

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public float getTripCounter()
    {
        return tripCounter;
    }

    public void setTripCounter(float tripCounter)
    {
        this.tripCounter = tripCounter;
    }

    //Default constructor
    public Vehicle()
    {
        this.tripCounter = 0;
    }

    public Vehicle(int serialNumber, String make, String model, float tripCounter)
    {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.tripCounter = tripCounter;
    }

    //Common behaviours
    public void makeTrip()
    {

    }

    //Override to String
    public String toString()
    {
        return "";
    }
}
