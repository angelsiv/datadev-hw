package bus;
import java.time.*;

//Source for the use of LocalDate: https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/

public class Player extends Member
{
	private String teamName;
	private LocalDate contractStart;
	private LocalDate contractEnd;
	
	//default constructor
	public Player()
	{
		super();
		this.teamName = null;
		this.contractStart = LocalDate.now();
	}
	public Player(String teamName, LocalDate contractStart, LocalDate contractEnd)
	{
		this.teamName = teamName;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
	}
	
	//Getters and setters for each attributes
	public void setContractStart(int year, int month, int day)
	{
		this.contractStart = LocalDate.of(year, month, day);
	}
	
	public LocalDate getContactStart()
	{
		return this.contractStart;
	}
	
	public void setContractEnd(int year, int month, int day)
	{
		this.contractEnd = LocalDate.of(year, month, day);
	}
	
	public LocalDate getContractEnd()
	{
		return this.contractEnd;
	}
	
	//Override to string
	public String toString()
	{
		return this.contractStart + " | ";
	}
}
