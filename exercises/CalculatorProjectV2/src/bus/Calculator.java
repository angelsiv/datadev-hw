package bus;

public class Calculator 
{
	private int number1;
	private int number2;
	
	public Calculator() {}
	
	public Calculator(int value1, int value2)
	{
		this.number1 = value1;
		this.number2 = value2;
	}
	
	public void setNumber1(int value)
	{
		this.number1 = value;
	}
	
	public int getNumber1()
	{
		return this.number1;
	}
	
	public void setNumber2(int value)
	{
		this.number2 = value;
	}
	
	public int getNumber2()
	{
		return this.number2;
	}
	
	public String ToString()
	{
		return "\n Number1: " + this.number1 + " + " + "Number2: " + this.number2;
	}
	
	public int add(int value1, int value2)
	{
		return value1 + value2;
	}
	
	public int add()
	{
		return this.number1 + this.number2;
	}
}
