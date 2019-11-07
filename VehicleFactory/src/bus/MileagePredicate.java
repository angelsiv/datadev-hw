package bus;

import java.util.Comparator;

public class MileagePredicate implements Comparator<Vehicle>
{
    @Override
    public int compare(Vehicle v1, Vehicle v2) //compares in a decreasing order
    {
        if(v1.getMilesPerGallon() < v2.getMilesPerGallon())
        {
            return 1;
        }
        else if(v1.getMilesPerGallon() > v2.getMilesPerGallon())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
