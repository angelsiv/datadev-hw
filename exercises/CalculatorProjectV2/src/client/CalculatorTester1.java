package client;
import bus.*;

public class CalculatorTester1 {

	public static void main(String[] args) 
	{
		Calculator c1 = new Calculator();
		System.out.println(c1);
		
		c1.setNumber1(77);
		c1.setNumber2(2);
		
		System.out.println(c1);
		System.out.println("Sum= " + c1.add());
	}

}
