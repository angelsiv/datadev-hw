package client;

import bus.*;
import java.util.Scanner;

public class CalculatorTesterv2 {

	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		
		float result = 0;
		char operator;
		
		System.out.print("\n\t Calculator\n");
		
		System.out.print("\n Input first number: ");
		calculator.SetNumber1(scanner.nextFloat());
		
		System.out.print(" Input second number: ");
		calculator.SetNumber2(scanner.nextFloat());
		
		do {
			System.out.print("\n Input operator(+, -, *, /, %): ");
			operator = scanner.next().charAt(0);
		} while(operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%');
		
		switch(operator) {
		case '+':
			result = calculator.Add();
			System.out.print("\n\t" + calculator.GetNumber1() + " + " + calculator.GetNumber2() + " = ");
			break;
		case '-':
			result = calculator.Substrac();
			System.out.print("\n\t" + calculator.GetNumber1() + " - " + calculator.GetNumber2() + " = ");
			break;
		case '*':
			result = calculator.Multiply();
			System.out.print("\n\t" + calculator.GetNumber1() + " * " + calculator.GetNumber2() + " = ");
			break;
		case '/':
			result = calculator.Divide();
			System.out.print("\n\t" + calculator.GetNumber1() + " / " + calculator.GetNumber2() + " = ");
			break;
		case '%':
			result = calculator.Module();
			System.out.print("\n\t" + calculator.GetNumber1() + " % " + calculator.GetNumber2() + " = ");
			break;
		default:
			break;
		}
		
		System.out.print(result);	
	}

}
