package chessComplete;

public class ChessComplete {

	private int[][] grid;
	private int steps;

	public ChessComplete(int size) {
		this.grid = new int[size][size];
	}

	public void move(int r, int c) {
		this.move(r, c, 1);
	}

	private boolean move(int r, int c, int count) {
		this.steps++;

		if (!inRange(r) || !inRange(c)) {
			return false;
		}

		if (this.grid[r][c] != 0) {
			return false;
		}

		this.grid[r][c] = count;

		if (count == Math.pow(this.grid.length, 2)) {
			return true;
		}

		if (move(r + 2, c + 1, count + 1) || move(r + 2, c - 1, count + 1) || move(r - 2, c + 1, count + 1)
				|| move(r - 2, c - 1, count + 1) ||

				move(r + 1, c + 2, count + 1) || move(r - 1, c + 2, count + 1) || move(r + 1, c - 2, count + 1)
				|| move(r - 1, c - 2, count + 1)) {

			return true;
		} else {
			this.grid[r][c] = 0;
			count = 0;
			return false;
		}

	}

	public int getSteps() {
		return this.steps;
	}

	private boolean inRange(int test) {
		return (test >= 0) && (test <= this.grid.length - 1);
	}

	public String displayBoard() {
		String res = "";
		for (int[] r : this.grid) {
			for (int c : r) {
				res += c + " ";
			}
			res += "\n";
		}

		System.out.println(res);

		return res;
	}

}
