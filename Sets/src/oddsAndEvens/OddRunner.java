package oddsAndEvens;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OddRunner {
	
	public static void main(String args[]) throws IOException {
		String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/" +  "oddsAndEvens/" + "oddevendata.dat";
		Scanner fl = new Scanner(new File(absPath));

		while (fl.hasNextLine()) {
			System.out.println(new OddEvenSets(fl.nextLine()));
		}
		
		fl.close();

	}
	
	
}