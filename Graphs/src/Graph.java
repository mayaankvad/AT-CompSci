import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Graph
{
	private TreeMap<String, String> map;
	private boolean yahOrNay;

	public Graph(String line)
	{
	}

	public boolean contains(String letter)
	{
	   return true;
	}

	public void check(String first, String second, String placesUsed)
	{
	}

	public String toString()
	{
		return "";
	}


	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("graph1.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			//add code here
		}
	}



}