package relatives;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Relatives {
	private Map<String, Set<String>> map;

	public Relatives() {
		this.map = new TreeMap<String, Set<String>>();
	}

	public void setPersonRelative(String line) {
		String[] personRelative = line.split(" ");

		if (!this.map.containsKey(personRelative[0])) {
			this.map.put(personRelative[0], new TreeSet<String>());
		}

		this.map.get(personRelative[0]).add(personRelative[1]);
	}

	public String getRelatives(String person) {
		return (this.map.get(person) != null) ? this.map.get(person).toString() : "";
	}

	public String toString() {
		String output = "";

		for (Map.Entry<String, Set<String>> o : this.map.entrySet()) {
			output += o.getKey() + " is related to: " + this.getRelatives(o.getKey()) + "\n";
		}

		return output;
	}
}