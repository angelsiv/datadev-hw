package bus;

public class Employee extends Member
{
	private double annualSalary;
	
	public Employee()
	{
		super();
		this.annualSalary = 0.00;
	}
	
	public Employee(long id, String fn, String ln, double annualSalary, Date date)
	{
		super(id, fn, ln, Type.Employee, date);
		this.annualSalary = annualSalary;
	}
	
	public double getAnnualSalary()
	{
		return this.annualSalary;
	}
	
	public void setAnnualSalary(double value)
	{
		this.annualSalary = value;
	}
	
	public String toString()
	{
		return super.toString() + " - " + this.annualSalary + " - Payment: " + calculatePayment();
	}
	
	public double calculatePayment()
	{
		return this.annualSalary;
	}
	
}
