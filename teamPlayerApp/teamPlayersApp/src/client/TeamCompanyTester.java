package client;
import bus.*;
import com.sun.deploy.security.SelectableSecurityManager;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class TeamCompanyTester {

	//My example is an eSports Company, with players, which are part of a team, with a coach and a manager
	// This is only the tester where I trial code

	public static ArrayList<Member> list = new ArrayList<>();
	public static ArrayList<Integer> alreadyUsed = new ArrayList<>();
	public static ArrayList<Member> fileList = new ArrayList<>();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Member person1 = new Member();
		//System.out.println(person1);
		Player playerTest = new Player();
		Player playerTest2 = new Player();
		Player playerTest3 = new Player();
		playerTest2.setContractStart(2019, 10, 12);
		//System.out.println(playerTest2);


		/*playerTest.setId(12);
		playerTest2.setId(23);
		playerTest3.setId(7);
		*/
		list.add(playerTest);
		list.add(playerTest2);
		list.add(playerTest3);

		/*
		System.out.println("Before");
		for (Member m : list)
		{
			System.out.println(m);
		}

		IDPredicate idComparator = new IDPredicate();
		list.sort(idComparator);

		System.out.println("After");
		for (Member m : list)
		{
			System.out.println(m);
		}
		*/

		Random rand = new Random();
		playerTest.setId(assignID());
		playerTest2.setId(assignID());
		playerTest3.setId(assignID());

		for (Member m : list) {
			System.out.println(m.getId());
		}

		FileHandler.writeToFile(list);
		fileList= FileHandler.readFromFile();

		System.out.println("\n Data From Compiler...\n");
		for (Member person : list)
		{
			System.out.println(person);
		}
		System.out.println("\n Data From File...\n");
		for (Member person : fileList)
		{
			System.out.println(person);
		}

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

	public static int assignID()
	{
		Random rand = new Random();
		while(true)
		{
			int id = rand.nextInt(10);
			if(!alreadyUsed.contains(id))
			{
				alreadyUsed.add(id);
				return id;
			}
		}
	}

	/*public Integer makeID()
	{
		Random rand = new Random();
		int id = rand.nextInt(9999);

		for (Member member : personnelList)
		{
			if(member.getId() != id)
			{
				return id;
			}
			else //redo loop
			{
				assignID();
			}
		}
		return -1;
	}*/
}
