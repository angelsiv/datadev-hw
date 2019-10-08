package bus;

public class Calculator {

	private float number1;
	private float number2;
	
	public Calculator() {
		
	}
	
	public Calculator(float value1, float value2) {
		this.number1 = value1;
		this.number2 = value2;
	}
	
	public void SetNumber1(float value) { this.number1 = value; }
	public float GetNumber1() { return this.number1; }
	public void SetNumber2(float value) { this.number2 = value; }
	public float GetNumber2() { return this.number2; }
	
	public String toString() {
		return "\n Number 1 : "  + this.number1 + " | Number 2 : " + this.number2;
	}
	
	public float Add(float value1, float value2) {
		return value1 + value2;
	}
	
	public float Add() {
		return this.number1 + this.number2;
	}
	
	public float Substrac(float value1, float value2) {
		return value1 - value2;
	}
	
	public float Substrac() {
		return this.number1 - this.number2;
	}
	
	public float Multiply(float value1, float value2) {
		return value1 * value2;
	}
	
	public float Multiply() {
		return this.number1 * this.number2;
	}
	
	public float Divide(float value1, float value2) {
		if(value2 == 0) {
			return -1;
		}
		else
			return value1 / value2;
	}
	
	public float Divide() {
		if(this.number2 == 0) {
			return -1;
		}
		else
			return this.number1 / this.number2;
	}
	
	public float Module(float value1, float value2) {
		return value1 % value2;
	}
	
	public float Module() {
		return this.number1 % this.number2;
	}
}
