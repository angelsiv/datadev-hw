package client;

import java.util.Scanner;

public class CalculatorTester {
	
	public static int add(int x, int y)
	{
		return x + y;
	}
	
	public static int sub(int x, int y)
	{
		return x - y;
	}
	
	public static int mul(int x, int y)
	{
		return x * y;
	}
	
	public static int div(int x, int y)
	{
		if (y != 0) {
			return x / y;
		}
		else return -1;
	}
	
	public static int mod(int x, int y)
	{
		return x % y;
	}
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("\n\n\t Hello There General Kenobi");
		Scanner scan = new Scanner(System.in);
		int number1, number2, addition, substraction, multiplication, division, modulo;
		
		System.out.print("Enter first number: ");
		number1 = scan.nextInt();
		System.out.print("Enter second number: ");
		number2 = scan.nextInt();
		
		addition = add(number1, number2);
		substraction = sub(number1, number2);
		multiplication = mul(number1, number2);
		division = div(number1, number2);
		modulo = mod(number1, number2);
		
		System.out.println(number1 + " + " + number2 + " = " + addition);
		System.out.println(number1 + " - " + number2 + " = " + substraction);
		System.out.println(number1 + " * " + number2 + " = " + multiplication);
		System.out.println(number1 + " / " + number2 + " = " + division);
		System.out.println(number1 + " % " + number2 + " = " + modulo);
	}

}
