package tablesOfInts.project2;

public class Word {

	private String theValue;

	// write a constructor method
	public Word(String value) {
		this.theValue = value;
	}

	// write the getValue method
	public String getValue() {
		return this.theValue;
	}

	// write the equals method
	@Override
	public boolean equals(Object o) {
		return this.theValue.equals(((Word) o).theValue);
	}

	// write the hashCode method
	public int hashCode() {
		int vowels = 0;

		for (String s : this.theValue.split("")) {
			if (s.toUpperCase().matches("A|E|I|O|U")) {
				vowels++;
			}
		}

		return (vowels * this.theValue.length()) % 10;
	}

	// write the toString method
	public String toString() {
		return this.theValue;
	}

}