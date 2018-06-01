
public class ArrayTester {

	/**
	 * Returns an array containing the elements of column c of arr2D in the same
	 * order as they appear in arr2D. Precondition: c is a valid column index in
	 * arr2D. Postcondition: arr2D is unchanged.
	 */
	public static int[] getColumn(int[][] arr2D, int c) {
		int[] res = new int[arr2D[0].length];
		
		for(int r = 0; r < arr2D[0].length; r++) {
			res[r] = arr2D[r][c];
		}
		
		return res;
		
	}

	/**
	 * Returns true if and only if every value in arr1 appears in arr2.
	 * Precondition: arr1 and arr2 have the same length. Postcondition: arr1 and
	 * arr2 are unchanged.
	 */
	public static boolean hasAllValues(int[] arr1, int[] arr2) {
		
		for(int i: arr1) {
			
			//arr2 not has -> false
			for(int j = 0; j < arr2.length; j++) {
				if(i == arr2[j]) {
					break;
				}
				if(j == arr2.length-1) {
					return false;
				}
			}
			
		}
		return true;
		
	}

	/**
	 * Returns true if arr contains any duplicate values; false otherwise.
	 */
	public static boolean containsDuplicates(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
		
	}

	/**
	 * Returns true if square is a Latin square as described in part (b); false
	 * otherwise. Precondition: square has an equal number of rows and columns.
	 * square has at least one row.
	 */
	public static boolean isLatin(int[][] square) {
		
		if(containsDuplicates(square[0])) {
			return false;
		}
		
		for(int r = 0; r < square.length; r++) {
			if(!hasAllValues(square[r], square[0])){
				return false;
			}
		}
		
		for(int c = 0; c < square.length; c++) {
			int[] a = getColumn(square, c);
			if(!hasAllValues(a, square[0])){
				return false;
			}
		}
		
		return true;
		
	}

}










