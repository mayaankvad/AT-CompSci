package acronyms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Acronyms
{
	private Map<String, String> acronymTable;

	public Acronyms()
	{
		this.acronymTable = new HashMap<String, String>();
	}

	public void putEntry(String entry)
	{
		String[] e = entry.split(" - ");
		this.acronymTable.put(e[0], e[1]);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output = "";

		while(chop.hasNext()) {
			String s = chop.next();
			
			String key = s.replaceAll("[\\p{Punct}&&[^']]+", "");
			
			if(this.acronymTable.containsKey(key)) {
				output += this.acronymTable.get(key) + " ";
			}
			else {
				output += s + " ";
			}
			
		}

		chop.close();
		return output;
	} 

	public String toString()
	{
		return this.acronymTable.toString();
	}
}