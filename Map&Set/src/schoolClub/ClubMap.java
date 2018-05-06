package schoolClub;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ClubMap {
	
	private HashMap<String, TreeSet<Student>> data;

	public ClubMap() {
		this.data = new HashMap<String, TreeSet<Student>>();
	}

	public boolean add(String club, Student student) {
		club = club.toLowerCase();
		if(this.data.get(club) == null) {
			this.data.put(club, new TreeSet<Student>());
		}
		return this.data.get(club).add(student);
	}
	
	public Set<Student> getClub(String club) {
		return this.data.get(club.toLowerCase());
	}
	
	public String toString() {
		return this.data.toString()
				.replaceAll(",", "\n")
				.replaceAll("=", ":\n")
				.replaceAll("\\{|\\}|\\[|\\]|\\)", "")
				.replaceAll("\\(", "\t");
	}
	
}
