package Ch10;

import java.util.Arrays ;
public class Solution11 {

	public static void peaksAndValleys(int[] array, int n)
	{
		Arrays.sort ( array );
		for(int i = 0; i < n - 1; i = i + 2)
		{
			int t = array[i];
			array[i] = array[i + 1];
			array[i + 1] = t;
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {5,3,1,2,3};
		peaksAndValleys ( array , array.length );
		for(int i = 0; i < array.length; ++i)
		{
			System.out.print ( array[i] + "  " );
		}
		System.out.println ( );
	}
}
