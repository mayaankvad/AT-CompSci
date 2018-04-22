package tablesOfInts.project1;

import java.util.Scanner;
import java.io.File;

public class HashTableRunner {

	public static void main(String[] args) {

		final String absPath = System.getProperty("user.dir") + "\\src\\tablesOfInts\\project1\\" + "numbers.dat";
		
		try {
			// make a new table
			HashTable table = new HashTable();

			// read from the file &
			// load stuff into the table

			Scanner in = new Scanner(new File(absPath));
			while (in.hasNextLine()) {
				Number n = new Number(Integer.valueOf(in.nextLine().trim()));
				table.add(n);
			}

			// print out the table
			System.out.println(table);

			in.close();
		} catch (Exception e) {
			System.out.println("Houston, we have a problem!");
			e.printStackTrace();
		}

	}

}