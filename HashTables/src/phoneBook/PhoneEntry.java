package phoneBook;

public class PhoneEntry {

	private String name;
	private String number; 
	
	public PhoneEntry(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String n) {
		this.number = n;
	}
	
	public String toString() {
		return this.name + ": " + this.number;
	}
	
	public int hashCode() {
		return Integer.valueOf(this.number.replaceAll("-| ", ""));
	}
	
}
