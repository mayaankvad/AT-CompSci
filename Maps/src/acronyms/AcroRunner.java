package acronyms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		
		final String absPath = System.getProperty("user.dir") + "\\src\\acronyms\\" + "acro.dat";
		final Scanner fl = new Scanner(new File(absPath));
		
		Acronyms acro = new Acronyms();
		
		int data = fl.nextInt(); fl.nextLine();
		for(int i = 0; i < data; i++) {
			acro.putEntry(fl.nextLine());
		}
		
		
		while(fl.hasNextLine()) {
			String s = acro.convert(fl.nextLine());	
			System.out.println(s);
		}


		fl.close();
		
		
	}
}