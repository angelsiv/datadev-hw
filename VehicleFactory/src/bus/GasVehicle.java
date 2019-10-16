package bus;

public class GasVehicle extends Vehicle
{
    private float fuelConsumed;

    @Override
    public void makeTrip() {
        super.makeTrip();
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
