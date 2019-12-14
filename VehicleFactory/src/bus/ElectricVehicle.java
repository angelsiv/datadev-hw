package bus;

//Source for regex for a floating point: https://stackoverflow.com/questions/12643009/regular-expression-for-floating-point-numbers
public class ElectricVehicle extends Vehicle implements ICloneable
{
    private float KWPowerConsumed;

    //Getters and Setters
    public float getKWPowerConsumed()
    {
        return KWPowerConsumed;
    }

    public void setKWPowerConsumed(float value) throws Exception
    {
        if(!String.valueOf(value).matches("[+-]?([0-9]*[.])?[0-9]+"))
        {
            throw new Exception("Error: Must only contain digits");
        }
        this.KWPowerConsumed = value;
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

    //Clone constructor
    public ElectricVehicle(ElectricVehicle electricVehicleCopy)
    {
        super(electricVehicleCopy.getSerialNumber(), electricVehicleCopy.getMake(), electricVehicleCopy.getModel());
        this.KWPowerConsumed = electricVehicleCopy.getKWPowerConsumed();
    }

    public void makeTrip(int tripCounter, float KWPowerConsumed)
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
        return super.toString() + String.format(" | Mileage: %s", this.getMilesPerGallon());
    }

    @Override
    public Vehicle clone()
    {
        return new ElectricVehicle(this);
    }
}
