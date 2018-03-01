package oddsAndEvens;

import java.util.Set;
import java.util.TreeSet;

public class OddEvenSets {
	
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets() {
		this("");
	}

	public OddEvenSets(String line) {
		this.odds = new TreeSet<Integer>();
		this.evens = new TreeSet<Integer>();

		for (String i : line.split(" ")) {

			int n = Integer.valueOf(i);
			if (n % 2 == 0) {
				this.evens.add(n);
			} else {
				this.odds.add(n);
			}

		}

	}

	public String toString() {
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}
