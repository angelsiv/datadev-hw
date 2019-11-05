package bus;

public class Manager extends Member
{
    private String sponsoredCompany;

    public Manager()
    {
        super();
        this.setType(PersonnelType.Manager);
        this.sponsoredCompany = null;
    }

    public Manager(String sponsoredCompanies)
    {
        this.sponsoredCompany = sponsoredCompanies;
    }

    public String getSponsoredCompany()
    {
        return sponsoredCompany;
    }

    public void setSponsoredCompany(String value)
    {
        this.sponsoredCompany = value;
    }

    public String toString()
    {
        return super.toString() + "Sponsor: " + this.sponsoredCompany + " | ";
    }
}
