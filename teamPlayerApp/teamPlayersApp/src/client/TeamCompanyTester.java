package client;
import bus.*;
import java.util.Scanner;
import java.time.*;

public class TeamCompanyTester {

	//My example is an eSports Company, with players, which are part of a team, with a coach and a manager
	// This is only the tester where I trial code
	
	public static void main(String[] args) 
	{
		Member person1 = new Member();
		System.out.println(person1);
		Player playerTest = new Player();
		Player playerTest2 = new Player();
		playerTest2.setContractStart(2019, 10, 12);
		
		System.out.println(playerTest2);
	}
	
	
	public static void isDigit(String value)
	{
		try
		{
			Double.parseDouble(value);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
