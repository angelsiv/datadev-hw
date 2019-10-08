package bus;

public class Calculator extends Object
{
	//Your calculator should have two private numbers
	private int operand1;
	private int operand2;
	private String operation;
	public int result;
	
	//the default constructor
	public Calculator()
	{
		//initialize the default values to the attributes here
	}
	
	public Calculator(int n1, int n2, String op)
	{
		this.operand1 = n1;
		this.operand2 = n2;
		this.operation = op;
	}
	
	public int getNumber() { return this.operand1; }
	
	public void setNumber1(int value) { this.operand1 = value; }
	
	public int getNumber2() { return this.operand2; }
	
	public void setNumber2(int value) { this.operand2 = value; }
	
	public void setOperation(String operation)
	{
		switch(operation)
		{
		case "+": result = add(this.operand1, this.operand2); break;
		case "-": result = sub(this.operand1, this.operand2); break;
		case "*": result = mul(this.operand1, this.operand2); break;
		case "/": result = div(this.operand1, this.operand2); break;
		case "%": result = mod(this.operand1, this.operand2); break;
		default: System.out.print("Invalid operation"); break;
		}
	}
	
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
	
	public String toString()
	{
		return "Calculator [First number =" + operand1 + ", Second number = " + operand2 + " ]\n"
				+ "Result: " + result;
	}
}
