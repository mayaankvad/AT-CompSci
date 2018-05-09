package phoneBook;

public class PhoneEntry {

	private String name;
	private int number; 
	
	public PhoneEntry(String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public int hashCode() {
		return this.number;
	}
	
}
