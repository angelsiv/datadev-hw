package bus;
import java.util.Comparator;

public class SerialNumberComparator implements Comparator<Shape>
{
    @Override
    public int compare(Shape s1, Shape s2) {

        if(s1.getSerialNumber() < s2.getSerialNumber())
        {
            return -1;
        }
        else if (s1.getSerialNumber() > s2.getSerialNumber())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
