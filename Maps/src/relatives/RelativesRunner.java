package relatives;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RelativesRunner {

	public static void main(String args[]) throws IOException {

		final String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/"
				+ Thread.currentThread().getStackTrace()[1].getClassName().split("\\.")[0] + "/" + "relatives.dat";
		Scanner fl = new Scanner(new File(absPath));
		
		Relatives relatives = new Relatives();
		
		int rels = fl.nextInt(); fl.nextLine();
				
		for(int i = 1; i <= rels; i++) {
			relatives.setPersonRelative(fl.nextLine());
		}
		
		System.out.println(relatives);
		
		while(fl.hasNextLine()) {
			String n = fl.nextLine();
			System.out.println(n + " is related to: " + relatives.getRelatives(n));
		}
		
		fl.close();
	}

}