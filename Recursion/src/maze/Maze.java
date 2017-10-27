package maze;

public class Maze {
	private char[][] maze;
	private int row, column;
	private int steps;

	public Maze(char[][] m, int i, int j) {
		maze = m;
		row = i;
		column = j;
		steps = 0;
	}

	public int getIExit() {
		return row;
	}

	public int getJExit() {
		return column;
	}

	public void display() {
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[0].length; c++) {
				System.out.print(maze[r][c] + " ");
			}
			System.out.println();
		}
	}

	public boolean findExit() {

		return findExit(row, column, 0);
	}

	public boolean findExit(int r, int c, int count) {
		if (r < 0 || c < 0 || r > maze.length || c > maze[0].length) {
			count = 0;
			return false;
		}
		if (maze[r][c] == ' ' && ((r == 0 || r == maze.length - 1) || (c == 0 || c == maze[0].length - 1))) {

			row = r;
			column = c;

			return true;
		}

		if (maze[r][c] == ' ' || maze[r][c] == '.') {
			maze[r][c] = '0';
			count++;

			return (findExit(r + 1, c, count) || findExit(r - 1, c, count) || findExit(r, c + 1, count)
					|| findExit(r, c - 1, count));
		}
		steps = count;

		return false;
	}

	public int getSteps() {
		return steps;
	}

}


