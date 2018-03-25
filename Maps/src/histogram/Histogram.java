package histogram;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Histogram
{
	private Map<String, Integer> histogram;

	public Histogram()
	{
		this.histogram = new TreeMap<String, Integer>();
	}

	public Histogram(String sent)
	{
		this();
		this.setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		Scanner scn = new Scanner(sent);
		while(scn.hasNext()) {
			String key = scn.next();
			
			if(this.histogram.containsKey(key)) {
				int val = this.histogram.get(key);
				this.histogram.put(key, val + 1);
			}
			else  {
				this.histogram.put(key, 1);
			}
		}
		scn.close();
	}

	public String toString()
	{
		String out = "---\n";
		
		for(Map.Entry<String, Integer> o: this.histogram.entrySet()) {
			out += o.getKey() + " ";
			for(int i = 1; i <= o.getValue(); i++) {
				out += "*";
			}
			out += "\n";
		}
		
		
		return out;
	}
}

