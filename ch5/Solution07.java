package Ch5;

import java.util.ArrayList ;

public class Solution07 {

	public static int pariwiseSwap(int m)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 32; ++i)
		{
			if(m % 2 == 0)
				list.add ( 0 );
			else {
				list.add ( 1 );
			}
			m = m >> 1;
		}
		
		for(int i = 0; i < list.size ( ); i = i + 2)
		{
			int t = list.get ( i );
			list.set ( i , list.get ( i + 1 ) );
			list.set ( i + 1 , t );
		}
		
		int result = 0;
		for(int i = 0; i < list.size ( ); ++i)
		{
			result = (list.get ( i ) << i) + result;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int num = 6;// 0110
		System.out.println(pariwiseSwap ( num )); // 1001
	}
}
