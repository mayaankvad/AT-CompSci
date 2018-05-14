package phoneBook;

public class PhoneTester {

	public static void main(String[] args) {

		final String absPath = System.getProperty("user.dir").replace("\\", "/") + "/src/" +  "phoneBook/" + "phone.txt";
		
		
		PhoneBook b = new PhoneBook();
		b.load(absPath);
		b.display();
		

		b.changeNumber("Price", "1111111");
		PhoneEntry h = new PhoneEntry("SantaClaus", "7165100");
		b.add(h);
		b.display();
		System.out.println("Capacity: " + b.getCapacity() + "\nSize: " + b.size() + "\nLongest list length: "
				+ b.getLongestList() + "\nNull entries: " + b.getNumberOfNulls());
	}

}