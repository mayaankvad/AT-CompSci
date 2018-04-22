package tablesOfInts.project2;

import java.util.LinkedList;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class HashTable {

	private LinkedList[] table;

	public HashTable() {
		table = new LinkedList[10];
	}

	public void add(Object obj) {
		int i = obj.hashCode();

		if (this.table[i] == null) {
			this.table[i] = new LinkedList();
		}

		this.table[i].add(obj);

	}

	public String toString() {
		String output = "HASHTABLE\n";

		for (int i = 0; i < this.table.length; i++) {
			String o = (this.table[i] != null) ? this.table[i].toString() : "[]";
			output += "BUCKET " + i + " " + o + "\n";
		}

		return output;
	}

}