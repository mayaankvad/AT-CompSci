package gridCounter;

public class GridRunner {
	
	public static void main(String[] args) {
		Grid grid = new Grid(12, 12, new String[] { "A", "E", "I", "O", "U" });
		System.out.println(grid);
		System.out.println("A count == " + grid.findMax("A"));
		System.out.println("E count == " + grid.findMax("E"));
		System.out.println("I count == " + grid.findMax("I"));

		System.out.println("\n\n");
		grid.setGrid(11, 6, new String[] { "X", "Y", "Z", "7", "8", "2" });
		System.out.println(grid);
		System.out.println("X count == " + grid.findMax("X"));
		System.out.println("2 count == " + grid.findMax("2"));
		System.out.println("Z count == " + grid.findMax("Z"));
	}
	
}