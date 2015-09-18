package Week1;

public class Solution08 {

	public void setZero(int[][] matrix)
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
			for(int i = 0; i < m ++i)
				matrix[i]
		}
	}
}
