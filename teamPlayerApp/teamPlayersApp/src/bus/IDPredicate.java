package bus;
import java.util.Comparator;

public class IDPredicate implements Comparator<Member>
{
    @Override
    public int compare(Member m1, Member m2)
    {
        if (m1.getId() < m2.getId())
        {
            return -1;
        }
        else if (m1.getId() > m2.getId())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
