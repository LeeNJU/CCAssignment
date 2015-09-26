package Ch10;

public class Solution01 {

	
	public static int[] sortedMerge(int[] A, int length1, int[] B, int length2)
	{
		int index = length1 + length2 - 1;
		int i = length1 - 1, j =length2 - 1;
		for(; i >= 0 && j >= 0;)
		{
			if(A[i] <= B[j])
			{
				A[index] = B[j];
				--index;
				--j;
			}
			else {
				A[index] = A[i];
				--index;
				--i;
			}
		}
		
		for(int m = j; m >= 0; --m)
		{
			A[index--] = B[m];
		}
		return A;
	}
	
	public static void main(String[] args)
	{
		int[] A = {3, 5,0,0,0,0,0,0,0};
		int[] B = {2,6,10};
		A = sortedMerge(A, 2 ,B, 3);
		for(int i = 0; i < 5; ++i)
			System.out.print ( A[i] + "  " );
		System.out.println ( );
	}
}
