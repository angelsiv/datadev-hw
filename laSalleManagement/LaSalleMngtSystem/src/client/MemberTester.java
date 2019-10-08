package client;
import bus.*;
import java.util.ArrayList;


public class MemberTester {

	public static void main(String[] args) 
	{
		ArrayList<Student> myStudentList = new ArrayList<Student>();
		ArrayList<Employee> myEmployeeList = new ArrayList<Employee>();
		ArrayList<Member> myMemberList = new ArrayList<Member>();
		
		Student aStudent = new Student();
		Student aStudent2 = new Student(1001, "Carol", "Gabriel", 2300.00, null, new Date(17, 9 ,2019));
		
		Employee anEmployee = new Employee(2000, "Alejandro", "Flores", 79000, new Date(17, 9 ,2019));
		Employee anEmployee2 = new Employee(2001, "Alex", "Lepage", 80000, new Date(17, 9 ,2019));
		
		aStudent.setId(1000);
		aStudent.setFn("Robert");
		aStudent.setLn("Tran");
		aStudent.setFeesPerSession(2000.00);
		aStudent.setType(Type.Student);
		aStudent.setDate(new Date(12, 23, 2093));
		aStudent.addCourse(Courses.GameEngine);
		
		myMemberList.add(aStudent);
		myMemberList.add(aStudent2);
		myMemberList.add(anEmployee);
		myMemberList.add(anEmployee2);
		
		/*
		myStudentList.add(aStudent);
		myStudentList.add(aStudent2); 
		*/
		
		for (Member element : myMemberList)
		{
			if (element instanceof Student)
			{
				myStudentList.add((Student)element);
				System.out.println("Student added");
			}
			else if (element instanceof Employee)
			{
				myEmployeeList.add((Employee)element);
				System.out.println("Employee added");
			}
			
		}
		
		for (Student element : myStudentList)
		{
			System.out.println(element.toString());
		}
		
		for (Employee element : myEmployeeList)
		{
			System.out.println(element.toString());
		}
		
		/*
		System.out.println(aStudent);
		System.out.println(aStudent2);
		System.out.println(anEmployee);
		System.out.println(anEmployee2);
		*/
		System.exit(0);
	}

}
