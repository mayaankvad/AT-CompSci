package sudoku;

// @TODO fix later
public class Sudoku {

	private int[][] grid;
	
	
	public Sudoku(int side) {
		this.grid = new int[side][side];
		//this.grid[0][0] = 0;
		
		for(int r = 0; r < this.grid.length; r++) {
			for(int c = 0; c < this.grid.length; c++) {
				
				this.grid[r][c] = -1;
				
			}
		}
		
		this.solve();
		System.out.println(colContains(2, 0, 0));
	}
	
	
	
	
	public void solve() {
		
		for(int r = 0; r < this.grid.length; r++) {
			for(int c = 0; c < this.grid.length; c++) {
				//System.out.println(this);
				this.grid[r][c] = this.solveSquare(r, c, 0);
				
			}
		}
		
	}
	
	
	
	public int solveSquare(int r, int c, int q) {
		
		
		if(!inRange(q)) {
			return 0;
		}
		if(this.rowContains(r, q, 0) || this.colContains(c, q, 0)) {
			
			 return solveSquare(r, c, q + 1);
		}
		
		return q;
	}
	
	
	private boolean rowContains(int r, int l, int pos) {
		if(!inRange(r) || !inRange(pos)) {
			return false;
		}
		
		return ( (this.grid[r][pos] == l) || rowContains(r, l, pos + 1) );
	}
	
	private boolean colContains(int c, int l, int pos) {
		if(!inRange(c) || !inRange(pos)) {
			return false;
		}
		
		return ( (this.grid[pos][c] == l) || colContains(c, l, pos + 1) );
	}
	
	
	private boolean inRange(int test) {
		return (test >= 0) && (test <= this.grid.length - 1);
	}
	
	
	public String toString() {
		String res = "";
		for (int[] r : this.grid) {
			for (int c : r) {
				res += c + " ";
			}
			res += "\n";
		}
		return res; 
	}
	
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku(3);
		System.out.println(s);
		
	}

}
