package bus;

public class GasVehicle extends Vehicle
{
    private float fuelConsumed;

    //Getters and Setters
    public float getFuelConsumed()
    {
        return fuelConsumed;
    }

    public void setFuelConsumed(float value) throws Exception
    {
        if(!String.valueOf(value).matches("[+-]?([0-9]*[.])?[0-9]+"))
        {
            throw new Exception("Error: Must only contain digits");
        }
        this.fuelConsumed = value;
    }

    //Default constructor
    public GasVehicle()
    {
        super();
        this.fuelConsumed = 0;
    }

    public GasVehicle(int serialNumber, String make, String model, float fuelConsumed)
    {
        super(serialNumber, make, model);
        this.fuelConsumed = fuelConsumed;
    }

    public void makeTrip(int tripCounter, float fuelConsumed)
    {
        super.makeTrip(tripCounter);
        this.fuelConsumed = fuelConsumed;
    }

    @Override
    public float getMilesPerGallon()
    {
        return this.tripCounter/this.fuelConsumed;
    }

    @Override
    public String toString()
    {
        return super.toString() + String.format("Mileage: %s", this.getMilesPerGallon());
    }
}
