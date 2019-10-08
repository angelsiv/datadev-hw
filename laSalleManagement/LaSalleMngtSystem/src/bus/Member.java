package bus;

public abstract class Member implements IPayable
{
	//In java, these are called attributes and not properties
	private long id;
	private String fn;
	private String ln;
	private Type type;
	private Date date;

	public long getId()
	{
		return this.id;
	}

	public void setId(long value)
	{
		this.id = value;
	}

	public String getFn()
	{
		return this.fn;
	}

	public void setFn(String value)
	{
		this.fn = value;
	}

	public String getLn()
	{
		return this.ln;
	}

	public void setLn(String value)
	{
		this.ln = value;
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	public void setType(Type value)
	{
		this.type = value;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public void setDate(Date value)
	{
		this.date = value;
	}

	//default constructor
	public Member()
	{
		this.id = 0;
		this.fn = "Undefined";
		this.ln = "Undefined";
	}
	
	public Member(long id, String fn, String ln, Type type, Date date)
	{
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.type = type;
		this.date = date;
	}

	public String toString() 
	{
		return this.id + " " + this.fn + " " + this.ln + " - " + this.type + " | Date: " + this.date + " | ";
	}

}