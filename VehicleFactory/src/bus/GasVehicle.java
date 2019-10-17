package bus;

public class GasVehicle extends Vehicle
{
    private float fuelConsumed;

    //Getters and Setters
    public float getFuelConsumed()
    {
        return fuelConsumed;
    }

    public void setFuelConsumed(float fuelConsumed)
    {
        this.fuelConsumed = fuelConsumed;
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
    public float getMilesPerGallon() {
        return this.tripCounter/this.fuelConsumed;
    }

    @Override
    public String toString()
    {
        return "";
    }
}
