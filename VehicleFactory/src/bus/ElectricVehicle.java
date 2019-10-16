package bus;

public class ElectricVehicle extends Vehicle
{
    private float KWPowerConsumed;

    @Override
    public void makeTrip() {
        super.makeTrip();
    }

    @Override
    public float getMilesPerGallon() {
        return this.tripCounter/this.KWPowerConsumed;
    }

    @Override
    public String toString()
    {
        return "";
    }
}
