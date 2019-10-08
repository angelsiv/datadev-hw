package bus;

public class Member 
{
	//All attributes for parent class
	private int id;
	private String firstName;
	private String lastName;
	private PersonnelType type;
	private double salary;
	
	//Default constructor
	public Member() 
	{
		this.id = 0;
		this.setType(PersonnelType.Undefined);
		this.setSalary(0.00);
	}
	
	public Member(int id, String fn, String ln, PersonnelType type, double salary)
	{
		this.id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.type = type;
		this.salary = salary;
	}

	//Setter and getters for each attributes
	public int getId() 
	{
		return id;
	}

	public void setId(int value) 
	{
		this.id = value;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String value)
	{
		this.firstName = value;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String value) 
	{
		this.lastName = value;
	}

	public PersonnelType getType() 
	{
		return type;
	}

	public void setType(PersonnelType value) 
	{
		this.type = value;
	}

	public double getSalary() 
	{
		return salary;
	}

	public void setSalary(double value) 
	{
		this.salary = value;
	}
	
	//Override to string
	public String toString()
	{
		return this.id + " | " + "Name: " + this.lastName + " " + this.firstName + " | " + "Salary: " + this.salary + " | "
		+ "Position: " + this.type + " | ";
	}
}
