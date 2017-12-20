package histograms2;

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		this.thing = thang;
		this.count = cnt;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount(int cnt)
	{
		this.count = cnt;
	}

	public void setThing(Object obj)
	{
		this.thing = obj;
	}	
	
	public Object getThing()
	{
		return this.thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		
		
		
		return other.thing.equals(this.thing);
	}
	
	public int compareTo(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		
		
		
		return ((ThingCount) other.thing).compareTo(this.thing);
	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}
}