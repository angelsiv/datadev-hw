package client;

import bus.*;

public class CalculatorTesterv1 {

	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		
		System.out.print(calculator);
		
		calculator.SetNumber1(15);
		calculator.SetNumber2(52);
		
		System.out.print(calculator);
		
		System.out.print("\n\n Sum: " + calculator.Add());
	}

}
