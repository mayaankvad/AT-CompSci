package uniquesAndDupes;

public class Tester {

	public static void main(String[] args){

		String[] testCases = new String[] { 
				"a b c d e f g h a b c d e f g h i j k",
				"one two three one two three six seven one two",
				"1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6",
		};

		
		for (String s : testCases) {
			System.out.print("Original List:" + s + "\n");
			System.out.print("Uniqies:" + UniquesDupes.getUniques(s) + "\n");
			System.out.print("Dupes:" + UniquesDupes.getDupes(s) + "\n\n");
		}
		

	}

}
