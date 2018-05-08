package spanishToEnglish;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpanRunner
{
	public static void main( String args[] ) throws IOException
	{
		SpanishToEnglish translator = new SpanishToEnglish();
		
		String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/" +  "spanishToEnglish/" + "spantoeng.dat";
		Scanner fl = new Scanner(new File(absPath));

		int translations = fl.nextInt(); fl.nextLine();
		
		for(int i = 0; i <= translations; i++) {
			translator.putEntry(fl.nextLine());
		}
		
		while(fl.hasNextLine()) {
			System.out.println(translator.translate(fl.nextLine()));
		}
		
		fl.close();
		
	}
}
