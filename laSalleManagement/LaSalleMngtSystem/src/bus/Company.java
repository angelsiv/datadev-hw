package bus;
import java.util.ArrayList;

public class Company
{
	private ArrayList<Member> memberList;
	
	public Company()
	{
		memberList = new ArrayList<Member>();
	}
	
	public ArrayList<Member> getMemberList()
	{
		return this.memberList;
	}
	
	public ArrayList<Member> setMemberList(ArrayList<Member> list)
	{
		return this.memberList = list;
	}
	
	public void add(Member element)
	{
		this.memberList.add(element);
	}
	
	public void remove(Member element)
	{
		this.memberList.remove(element);
	}
	
	public void remove(int index)
	{
		this.memberList.remove(index);
	}
	
	public int getSize()
	{
		return this.memberList.size();
	}
}
