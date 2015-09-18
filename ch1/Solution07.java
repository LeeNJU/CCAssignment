package Week1;

public class Solution07 {

	public static void rotate(int[][] matrix)
	{
		int m = matrix.length, n = matrix[0].length;
		for(int i = 0; i < m ; ++i)
		{
			for(int j = 0; j < n - i; ++j)
			{
				int swap = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][m - i - 1];
				matrix[n - j - 1][m - i -1] = swap;
			}
		}
		
		for(int i = 0; i < m / 2; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				int swap = matrix[i][j];
				matrix[i][j] = matrix[m - i - 1][j];
				matrix[m - i - 1][j] = swap;
			}
		}
	}
	
	private static void printMatrix(int[][] matrix, int m, int n)
	{
		for(int i = 0; i < m; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				System.out.print ( matrix[i][j]  + "  ");
			}
			System.out.println();
	}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println("the matrix is :");
		printMatrix ( matrix , 3 , 3 );
		rotate ( matrix );
		System.out.println("after rotating :");
		printMatrix ( matrix , 3 , 3 );
	}
}
