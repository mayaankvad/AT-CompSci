package mathSet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MathSetRunner {
	public static void main(String args[]) throws IOException {

		final String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/" +  "mathSet/" + "mathsetdata.dat";
		
		// =======
		System.out.println("********************************");
		System.out.println("*    USING JAVA API TreeSet    *");
		System.out.println("********************************");
	
		Scanner fl = new Scanner(new File(absPath));

		while (fl.hasNextLine()) {
			MathSet s = new MathSet(fl.nextLine(), fl.nextLine());
			System.out.println("\n---");
			System.out.println(s);
			System.out.println("Union " + s.union());
			System.out.println("intersection " + s.intersection());
			System.out.println("difference A-B " + s.differenceAMinusB());
			System.out.println("difference B-A " + s.differenceBMinusA());
			System.out.println("Symmetric difference " + s.symmetricDifference());
		}

		
		
		//* ======= 
		System.out.println("\n\n*****************************************************************");
		System.out.println("*     USING CUSTOM IMPLEMENTED HashSet (UNSTABLE; UNORDERED)    *");
		System.out.println("*****************************************************************");
		
		Scanner fl2 = new Scanner(new File(absPath));
		while (fl2.hasNextLine()) {
			MathSetUsingCustomSet s = new MathSetUsingCustomSet(fl2.nextLine(), fl2.nextLine());
			System.out.println("\n---");
			System.out.println(s);
			System.out.println("Union " + s.union());
			System.out.println("intersection " + s.intersection());
			System.out.println("difference A-B " + s.differenceAMinusB());
			System.out.println("difference B-A " + s.differenceBMinusA());
			System.out.println("Symmetric difference " + s.symmetricDifference());
		}
		fl2.close();
		// */

		fl.close();
	}
}
