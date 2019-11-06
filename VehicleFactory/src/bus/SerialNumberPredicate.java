package bus;
import java.util.Comparator;

public class SerialNumberPredicate implements Comparator<Vehicle>
{
    @Override
    public int compare(Vehicle v1, Vehicle v2)
    {
        if (v1.getSerialNumber() < v2.getSerialNumber())
        {
            return -1;
        }
        else if (v1.getSerialNumber() > v2.getSerialNumber())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
