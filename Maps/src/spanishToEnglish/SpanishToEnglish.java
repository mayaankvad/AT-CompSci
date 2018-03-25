package spanishToEnglish;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class SpanishToEnglish
{
	private Map<String,String> pairs;

	public SpanishToEnglish()
	{
		this.pairs = new TreeMap<String, String>();
	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		this.pairs.put(list[0], list[1]);
	}

	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";

		while(chop.hasNext()) {
			output += this.pairs.get(chop.next()) + " ";
		}
		
		chop.close();
		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}