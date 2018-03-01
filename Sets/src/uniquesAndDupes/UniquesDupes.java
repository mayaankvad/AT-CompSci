package uniquesAndDupes;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class UniquesDupes {
	
	
	public static Set<String> getUniques(String input) {
		Set<String> uniques = new TreeSet<String>();

		uniques.addAll(Arrays.asList(input.split(" ")));
		
		return uniques;
	}

	public static Set<String> getDupes(String input) {
		Set<String> uniques = new TreeSet<String>();
		Set<String> dupes = new TreeSet<String>();

		for(String i: input.split(" ")) {
			if(!uniques.add(i)) {
				dupes.add(i);
			}
		}
		
		return dupes;
	}
	
	
	
}
