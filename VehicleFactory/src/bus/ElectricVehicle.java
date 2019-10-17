package bus;

public class ElectricVehicle extends Vehicle
{
    private float KWPowerConsumed;

    //Getters and Setters
    public float getKWPowerConsumed()
    {
        return KWPowerConsumed;
    }

    public void setKWPowerConsumed(float KWPowerConsumed)
    {
        this.KWPowerConsumed = KWPowerConsumed;
    }

    //Default constructor
    public ElectricVehicle()
    {
        super();
        this.KWPowerConsumed = 0;
    }

    public ElectricVehicle(int serialNumber, String make, String model, float KWPowerConsumed)
    {
        super(serialNumber, make, model);
        this.KWPowerConsumed = KWPowerConsumed;
    }

    public void makeTrip(float KWPowerConsumed)
    {
        super.makeTrip(tripCounter);
        this.KWPowerConsumed = KWPowerConsumed;
    }

    @Override
    public float getMilesPerGallon()
    {
        return this.tripCounter/this.KWPowerConsumed;
    }

    @Override
    public String toString()
    {
        return "";
    }
}
