package autoParts;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;
	
	public PartList()
	{
		this.partsMap = new TreeMap<Part, Integer>();
	}
	
	public PartList(String fileName)
	{
		this();
		try
		{
			final Scanner file = new Scanner(new File(fileName));
			//add code here to read from the file 
			//and add Parts to the map
			
			while(file.hasNextLine()) {
				String line = file.nextLine();
				if(!line.equals("")) {
					
					Part p = new Part(line);
					int num = 1;
					
					if(this.partsMap.containsKey(p)) {
						num = this.partsMap.get(p) + 1;
						this.partsMap.put(p, num);
					}
					
					this.partsMap.put(p, num);
					
				}
			}
		
			file.close();
		}
		catch(Exception e)  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
	}
	
	public String toString()
	{
		String out = "";	
		for(Map.Entry<Part, Integer> e: this.partsMap.entrySet()) {
			out += e.getKey() + " - " + e.getValue() + "\n";		
		}
		return out;
	}
}