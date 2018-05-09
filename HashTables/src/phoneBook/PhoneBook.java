package phoneBook;

import java.util.Arrays;
import java.util.LinkedList;

public class PhoneBook {
	
	private LinkedList<PhoneEntry>[] data;
	
	public PhoneBook() {
		this(10);
	}
	
	public PhoneBook(int numSlots) {
		this.data = new LinkedList[numSlots];
	}
	
	
	public void display() {
		System.out.println(Arrays.toString(this.data));
	}
	
	
	public int getCapacity() {
		return this.data.length;
	}
	
	
	public int size() {
		int c = 0;
		for(LinkedList<PhoneEntry> e: this.data) {
			if(e != null && !e.isEmpty()) {
				c++;
			}
		}
		return c;
	}
	
	public int getNumberOfNulls() {
		int c = 0;
		for(LinkedList<PhoneEntry> e: this.data) {
			if(e == null) {
				c++;
			}
		}
		return c;
	}
	
	public int getLongestList() {
		int c = 0;
		for(LinkedList<PhoneEntry> e: this.data) {
			if(e != null) {
				if(c < e.size()) {
					c = e.size();
				}
			}
		}
		return c;
	}
	
	public String lookup(String lookfor) {
		for(LinkedList<PhoneEntry> e: this.data) {
			if(e != null) {
				
				for(PhoneEntry p: e) {
					if(p.getName().equalsIgnoreCase(lookfor)) {
						return "" + p.getNumber();
					}
				}
				
			}
		}
		return null;
	}
	
	//changeNumber(String lookfor, String newNumb)
	
	
	
	
}
