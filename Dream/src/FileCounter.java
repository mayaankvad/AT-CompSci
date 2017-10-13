// Mayaank Vadlamani and Bharath Hegde

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@SuppressWarnings("resource")
public class FileCounter {

	int wordCount;
	TreeMap<String, Integer> listByFrequency;
	Map<String, Integer> freqList;

	public FileCounter(String filename) {
		File file = new File(filename);
		Scanner inFile;
		freqList = new TreeMap<String, Integer>();
		wordCount = 0;

		try {
			inFile = new Scanner(file);

			while (inFile.hasNextLine()) {

				String phrase = inFile.nextLine();
				phrase = phrase.replaceAll("[\\p{Punct}&&[^']]+", "");
				String[] words = phrase.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (words[i].equals("sixtythree")) {
						words[i] = "sixty-three";
					}

					if (!words[i].equals("")) {
						wordCount++;
						words[i] = words[i].substring(0,
								(words[i].indexOf("'") > 1 ? words[i].indexOf("'") : words[i].length()));

						if (freqList.containsKey(words[i].toLowerCase())) {

							freqList.put(words[i].toLowerCase(), freqList.get(words[i].toLowerCase()) + 1);
						} else {
							freqList.put(words[i].toLowerCase(), 1);
						}
					}
				}

			}

			listByFrequency = new TreeMap<String, Integer>(new ValueComparator(freqList));
			listByFrequency.putAll(freqList);

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

	}

	public boolean containsKey(String query) {
		for (Map.Entry<String, Integer> entry : listByFrequency.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(query)) {
				return true;
			}
		}
		return false;
	}

	public void lookup(String query) {
		System.out.println();
		query = query.toLowerCase();

		if (containsKey(query)) {

			int iterations = 1;
			int rank = 1;

			ArrayList<String> otherWords = new ArrayList<String>();

			for (Map.Entry<String, Integer> entry : listByFrequency.entrySet()) {

				if (entry.getKey().equalsIgnoreCase(query)) {
					rank = iterations;
				} else if (entry.getValue() == freqList.get(query)) {
					otherWords.add(entry.getKey());
				}

				iterations++;

			}

			System.out.println(query + ": " + freqList.get(query) + " occurences \nrank: " + rank
					+ "\nOther Words with same frequency: \n(" + otherWords.size() + "):  " + otherWords);

		} else {
			System.out.println("not found");
		}

	}

	public void print() {
		System.out.println("Number of Unique Words = " + listByFrequency.size()); // unique
																					// entries
		System.out.println("Total # of words = " + wordCount);

		System.out.println("Top 30 words: ");
		System.out.printf("%4s %s %n", "      Word", "      Frequency");
		int iterations = 1;
		for (Map.Entry<String, Integer> entry : listByFrequency.entrySet()) {
			if (iterations >= 31)
				break;

			System.out.printf("%5s %-10s %d %n", iterations + ")", entry.getKey(), entry.getValue());
			iterations++;
		}

	}
	
	public static String chooseFile(String directory) {
		File f = new File(directory);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

		System.out.println("Choose a file to open: (enter # corresponding to file) ");
		for (int i = 0; i < names.size(); i++)
			System.out.println("[" + i + "]: " + names.get(i));

		Scanner s = new Scanner(System.in);
		System.out.println("~$ ");
		int num = s.nextInt();
	
		return names.get(num);

	}
	

	public static void main(String[] args) {
		// chooses a file from current java project dir.
		String file = chooseFile(System.getProperty("user.dir"));

		FileCounter test = new FileCounter(file);
		test.print();

		Scanner s = new Scanner(System.in);
		System.out.println("\n\nlookup: ");
		String q = s.nextLine();
		test.lookup(q);

	}


}