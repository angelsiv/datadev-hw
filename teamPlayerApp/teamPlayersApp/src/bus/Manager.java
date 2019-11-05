package bus;

public class Manager extends Member
{
    private String[] sponsoredCompanies;

    public Manager()
    {
        super();
        this.sponsoredCompanies = null;
    }

    public Manager(String[] sponsoredCompanies)
    {
        this.sponsoredCompanies = sponsoredCompanies;
    }

    public String[] getSponsoredCompanies()
    {
        return sponsoredCompanies;
    }

    public void setSponsoredCompanies(String[] value)
    {
        this.sponsoredCompanies = sponsoredCompanies;
    }

    public String toString()
    {
        return super.toString() + "SPONSORS: " + this.sponsoredCompanies + " | ";
    }
}
