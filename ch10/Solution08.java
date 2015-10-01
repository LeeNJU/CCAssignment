package Ch10;

import java.util.BitSet ;

public class Solution08 {
//I looked at the solution in the book and I use BitSet
	public static void findDuplicates(int[] array, int n)
	{
		BitSet set = new BitSet(32000);
		for(int i = 0; i < n; ++i)
		{
			if(set.get ( array[i] ))
				System.out.print ( array[i] + "  " );
			set.set ( array[i]);
		}
		System.out.println ( );
	}
	
	public static void main(String[] args)
	{
		int[] array = {3,4,5,2,5,6,87,8,45,4,3};
		findDuplicates ( array , 11 );
	}
}
