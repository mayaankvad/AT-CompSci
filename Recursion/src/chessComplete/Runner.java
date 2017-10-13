package chessComplete;

public class Runner {
	
	public static void main(String[] args) {
		ChessComplete one = new ChessComplete(8);
		one.move(0, 0);
		one.displayBoard();
		System.out.print("Recursive method call count: ");
		System.out.printf("%,d", +one.getSteps());
		System.out.println();

	}
	

}
