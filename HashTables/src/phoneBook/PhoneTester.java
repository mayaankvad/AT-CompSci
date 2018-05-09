package phoneBook;

public class PhoneTester
{

    public static void main(String[] args)
    {
   	 PhoneBook b = new PhoneBook();
   	 b.load();
   	 b.display();
   	 
   	 b.changeNumber("Price", "1111111");
   	 PhoneEntry h = new PhoneEntry("SantaClaus", "7165100");
   	 b.add(h);
   	 b.display();
   	 System.out.println("Capacity: " + b.getCapacity() + "\nSize: " + b.getSize() + "\nLongest list length: " + b.getLongestList() + "\nNull entries: " + b.getNumberOfNulls());
    }

}