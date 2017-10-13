package gridCounter;

public class Grid {
	private String[][] grid;

	public Grid() {
		this(0, 0, null);
	}

	public Grid(int rows, int cols, String[] vals) {
		this.setGrid(rows, cols, vals);
	}

	public void setGrid(int rows, int cols, String[] vals) {
		this.grid = new String[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				this.grid[r][c] = vals[((int) (Math.random() * vals.length))];
			}
		}
	}

	public int findMax(String val) {
		boolean[][] visited = new boolean[grid.length][grid.length];
		
		int run  = 0;
		
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				
				int i = findMax(r, c, val, visited);
				
				if(i > run) {
					run = i;
				}
				
			}
		}
		
		
		return run;

	}

	
	private int findMax(int r, int c, String search, boolean visited[][]) {
		boolean ir = inRange(r, 0, grid.length -1) && inRange(c, 0, grid[r].length -1);
		if( !ir ) {
			return 0;
		}
		else {
			
			if(!visited[r][c] && grid[r][c].equals(search)) {
				visited[r][c] = true;
				return 1 + findMax(r + 1, c, search, visited)
						 + findMax(r - 1, c, search, visited)
						 + findMax(r, c + 1, search, visited)
						 + findMax(r, c - 1, search, visited);
			}
			return 0;
		}
		
		
	}

	public String toString() {
		String res = "";
		for (String[] r : this.grid) {
			for (String c : r) {
				res += c + " ";
			}
			res += "\n";
		}
		return res;
		// return Arrays.deepToString(this.grid);
	}

	private boolean inRange(int test, int min, int max) {
		return (test >= min) && (test <= max);
	}
	
	
}