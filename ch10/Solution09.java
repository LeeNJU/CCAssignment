package Ch10;

public class Solution09 {
//I don't know how to solve it and I looked at the solution in the book, I implemented it myself
	public static boolean sortedMatrixSearch(int[][] matrix, int m, int n, int value)
	{
		int row = 0, col = n - 1;
		while(row < m && col >= 0)
		{
			if(matrix[row][col] == value)
				return true;
			else if(matrix[row][col] < value)
				++row;
			else 
				--col;
		}
		return false;
	}
}
