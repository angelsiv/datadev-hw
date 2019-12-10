package bus;

import java.time.LocalDate;

public class RaceCar extends SportCar implements IClonableCar
{
    private float powerConsumption;

    //default constructor
    public RaceCar()
    {
        super();
        this.powerConsumption = 0.0f;
    }

    //constructor with parameters
    public RaceCar(int serialNumber, String brand, String model, int numberOfSeats, LocalDate madeDate, float gasConsumption, float powerConsumption)
    {
        super(serialNumber, brand, model, numberOfSeats, madeDate, gasConsumption);
        this.powerConsumption = powerConsumption;
    }

    //copy constructor
    public RaceCar(RaceCar raceCarCopy)
    {
        super(raceCarCopy.getSerialNumber(), raceCarCopy.getBrand(), raceCarCopy.getModel(), raceCarCopy.getNumberOfSeats(), raceCarCopy.getMadeDate(), raceCarCopy.getGasConsumption());
        this.powerConsumption = raceCarCopy.powerConsumption;
    }

    //getters and setters
    public float getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(float powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public Car clone() {
        return new RaceCar(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| Power Consumed: %s ", this.powerConsumption);
    }


}
