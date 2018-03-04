package mathSet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MathSetRunner {
	public static void main(String args[]) throws IOException {

		String absPath = System.getProperty("user.dir") + "\\src\\mathSet\\" + "mathsetdata.dat";
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

		fl.close();

	}
}
