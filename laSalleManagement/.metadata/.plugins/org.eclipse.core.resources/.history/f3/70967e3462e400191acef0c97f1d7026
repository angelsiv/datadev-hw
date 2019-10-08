package bus;
import java.util.ArrayList;

public class Student extends Member
{
	private double feesPerSession;
	private ArrayList<Courses> courseList;
	
	public double getFeesPerSession()
	{
		return this.feesPerSession;
	}
	
	public void setFeesPerSession(double value)
	{
		this.feesPerSession = value;
	}
	
	public double calculatePayment()
	{
		return this.feesPerSession;
	}
	
	public void addCourse(Courses value)
	{
		this.courseList.add(value);
	}
	
	public Student()
	{
		super(); //equivalence of invoking base class
		this.feesPerSession = 0.00;
		this.courseList = null;
	}
	
	public Student(long id, String fn, String ln, double feesPerSession, ArrayList<Courses> courseList, Date date)
	{
		super(id, fn, ln, Type.Student, date); //send these parameters to the super class this class extends to
		this.feesPerSession = feesPerSession;
		this.courseList = courseList;
	}
	
	public String toString()
	{
		return super.toString() + " - " + this.feesPerSession + " - Payment: " + calculatePayment();
	}
}
