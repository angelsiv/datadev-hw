package bus;

public class Coach extends Player
{
    private String companyName;

    //Default constructor
    public Coach()
    {
        super();
        this.companyName = null;
    }

    public Coach(String companyName)
    {
        this.companyName = companyName;
    }

    //Getters and Setters
    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String value)
    {
        this.companyName = value;
    }

    public String toString()
    {
        return super.toString() + "Company: " + this.companyName + " | ";
    }
}
