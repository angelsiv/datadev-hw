package client;

import java.util.Scanner;
import bus.Calculator; //important

public class CalculatorTesterV2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Calculator c1 = new Calculator();
		Scanner scan = new Scanner(System.in);
		String operation;
		
		System.out.println("Input first number: ");
		c1.setNumber1(scan.nextInt());
		
		System.out.println("Input second number: ");
		c1.setNumber2(scan.nextInt());
		
		System.out.print("\n Select the operation (+, -, *, /, %): ");
		c1.setOperation(scan.next());
		
		System.out.print(c1.toString());
	}

}
