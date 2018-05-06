package schoolClub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClubMapTester {

	public static void main(String[] args) throws FileNotFoundException {
		
		final String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/" + "/schoolClub/student.txt.txt";
		final Scanner in = new Scanner(new File(absPath));
		
		ClubMap data = new ClubMap();
		
		while(in.hasNextLine()) {
			
			final Scanner line = new Scanner(in.nextLine());
			
			String[] ln = new String[4];
			for(int i = 0; line.hasNext() ;i++) {
				ln[i] = line.next();
			}
			
			final Student s = new Student(ln[1], ln[0], ln[2]);
			data.add(ln[3], s);
			
			line.close();
			
		}
		in.close();
		
		System.out.println(data);
		System.out.println("\n\nMath:\n " + 
				data.getClub("Math").toString()
				.replaceAll(",", "\n")
				.replaceAll("=", ":\n")
				.replaceAll("\\{|\\}|\\[|\\]|\\)", "")
				.replaceAll("\\(", "\t"));
		
	}
	
	
}
