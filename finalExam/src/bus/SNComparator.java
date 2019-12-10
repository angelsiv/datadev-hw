package bus;
import java.util.Comparator;

public class SNComparator implements Comparator<Car>
{
    @Override
    public int compare(Car c1, Car c2) {
        if (c1.getSerialNumber() < c2.getSerialNumber())
        {
            return -1;
        }
        else if (c1.getSerialNumber() > c2.getSerialNumber())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
