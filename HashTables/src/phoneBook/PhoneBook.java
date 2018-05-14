package phoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class PhoneBook {

	private LinkedList<PhoneEntry>[] data;

	public PhoneBook() {
		this(10);
	}

	public PhoneBook(int numSlots) {
		this.data = new LinkedList[numSlots];
	}

	public void add(PhoneEntry e) {
		int h = e.hashCode() % this.data.length;

		if (this.data[h] == null) {
			this.data[h] = new LinkedList<PhoneEntry>();
		}
		this.data[h].add(e);
	}

	public void display() {
		System.out.println(Arrays.toString(this.data));
	}

	public int getCapacity() {
		return this.data.length;
	}

	public int size() {
		int c = 0;
		for (LinkedList<PhoneEntry> e : this.data) {
			
			if(e != null ) {
				c += e.size();
			}
			
		}
		return c;
	}

	public int getNumberOfNulls() {
		int c = 0;
		for (LinkedList<PhoneEntry> e : this.data) {
			if (e == null) {
				c++;
			}
		}
		return c;
	}

	public int getLongestList() {
		int c = 0;
		for (LinkedList<PhoneEntry> e : this.data) {
			if (e != null) {
				if (c < e.size()) {
					c = e.size();
				}
			}
		}
		return c;
	}

	public String lookup(String lookfor) {
		for (LinkedList<PhoneEntry> e : this.data) {
			if (e != null) {

				for (PhoneEntry p : e) {
					if (p.getName().equalsIgnoreCase(lookfor)) {
						return "" + p.getNumber();
					}
				}

			}
		}
		return null;
	}

	public boolean changeNumber(String lookfor, String newNumb) {
		for (LinkedList<PhoneEntry> e : this.data) {
			if (e != null) {

				for (PhoneEntry p : e) {
					if (p.getName().equalsIgnoreCase(lookfor)) {
						p.setNumber(newNumb);
						return true;
					}
				}

			}
		}
		return false;
	}

	public void load(String filepath) {
		try {	
			Scanner in = new Scanner(new File(filepath));
			
			while(in.hasNext()) {
				this.add(new PhoneEntry(in.next(), in.next()));
				
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public String toString() {
		return Arrays.toString(this.data);
	}

}
