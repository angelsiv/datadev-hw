package bus;
import java.io.Serializable;

public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    long id;
    String name;

    public Person() { }

    public Person(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public long getID()
    {
        return this.id;
    }

    public void setID(long value) throws Exception
    {
        if(!String.valueOf(value).matches("^\\d{4}$"))
        {
            throw new Exception("Only 4 digits");
        }
        this.id = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String value) throws Exception
    {
        if(!name.matches("^ [A-Z] {1} [a-z] {2,15}$]"))
        {
            throw new Exception("Must be letters only");
        }
        this.name = value;
    }

    public String toString()
    {
        return "ID: " + this.id + " | Name: " + this.name;
    }
}
