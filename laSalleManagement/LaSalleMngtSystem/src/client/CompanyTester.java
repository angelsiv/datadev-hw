package client;
import bus.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class CompanyTester {

	public static void main(String[] args) 
	{
		ArrayList<IPayable> iPayableList = new ArrayList<IPayable>();
		//add 3 things to list
		DecimalFormat twoDecimal = new DecimalFormat("$ 0.00");
		
		for(IPayable element: iPayableList)
		{
			if(element instanceof Student)
			{
				System.out.println(element + "\nPayment: " + twoDecimal.format(element.calculatePayment()));
			}
			else if (element instanceof Employee)
			{
				System.out.println(element + "\nPayment: " + twoDecimal.format(element.calculatePayment()));
			}
			else if (element instanceof Customer)
			{
				System.out.println(element + "\nPayment: " + twoDecimal.format(element.calculatePayment()));
			}
		}
	}

}
