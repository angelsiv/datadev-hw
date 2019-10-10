package bus;
import java.util.ArrayList;

public class Teacher extends Employee
{
	private ArrayList<Courses> courseList;
	
	public Teacher()
	{
		super();
		this.courseList = null;
	}
	
	public Teacher(long id, String fn, String ln, double annualSalary, Date date, ArrayList<Courses> courseList)
	{
		super(id, fn, ln, annualSalary, date);
		this.courseList = courseList;
	}
	
	public void addCourse(Courses value)
	{
		this.courseList.add(value);
	}
	
	public String toString()
	{
		return "|";
	}
}
