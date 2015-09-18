package Week1;

import java.awt.print.Printable ;

public class Solution08
{

	private static void print(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; ++i)
		{
			for(int j = 0; j < matrix[0].length; ++j)
			{
				System.out.print ( matrix[i][j]  + "  ");
			}
			System.out.println ( );
		}
	}
	public static void setZero(int[][] matrix)
	{
		int m = matrix.length, n = matrix[0].length;
		boolean row_zero = false, col_zero = false;
		
		for(int i = 0; i < n; ++i)
		{
			if(matrix[0][i] == 0)
				row_zero = true;
		}
		for(int i = 0; i < m; ++i)
		{
			if(matrix[i][0] == 0)
				col_zero = true;
		}
		
		for(int i = 0; i < m; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(matrix[i][j] == 0)
				{
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < m; ++i)
		{
			for(int j = 1; j < n; ++j)
			{
				if(matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		
		if(row_zero)
		{
			for(int i = 0; i < m; ++i)
				matrix[0][i] = 0;
		}
		if(col_zero)
		{
			for(int i = 0; i < n; ++i)
				matrix[i][0] = 0;
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3}, {0,4,0}, {5,7,3}};
		System.out.println ( "the matrix is :" );
		print ( matrix );
		System.out.println("after calling the function :");
		setZero(matrix);
		print ( matrix );
	}
}
