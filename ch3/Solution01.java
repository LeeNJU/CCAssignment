package Ch3;

import java.util.ArrayList ;
import java.util.List ;

public class Solution01 {

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static int size1 = 0;
	private static int index2 = 100 / 3;
	private static int size2 = 0;
	private static int index3 = 100 / 3 * 2;
	private static int size3 = 0;
	
	public Solution01()
	{
		for(int i = 0; i < 100; ++i)
			list.add ( 0 );
	}
	
	public static int peek(int index)
	{
		if(index == 1)
		{
			if(size1 != 0)
				return list.get(size1 - 1);
			else
				return Integer.MAX_VALUE;
		}
		else if(index == 2)
		{
			if(size2 != 0)
				return list.get ( index2 + size2 - 1 );
			else {
				return Integer.MAX_VALUE;
			}
		}
		else {
			if(size3 != 0)
				return list.get ( index3 + size3 - 1 );
			else {
				return Integer.MAX_VALUE;
			}
		}
	}
	public static void pop(int index)
	{
		if(index == 1)
		{
			if(size1 != 0)
				--size1;
		}
		else if(index == 2)
		{
			if(size2 != 0)
				--size2;
		}
		else {
			if(size3 != 0)
				--size3;
		}
	}
	
	public static void push(int index, int value)
	{
		if(index == 1)
		{
			if(size1 == index2)
			{
				list.add ( 0 );
				for(int i = index3 + size3 - 1; i >= index3; --i)
					list.set ( i + 1, list.get ( i )  );
				++index3;
				for(int i = index2 + size2 - 1; i >= index2; --i)
					list.set ( i + 1 , list.get ( i ) );
				++index2;
				list.set ( size1 , value );
				++size1;
			}
			else {
				list.set ( size1 , value );
				++size1;
			}
		}
		else if(index == 2)
		{
			if(index2 + size2 == index3)
			{
				list.add ( 0 );
				for(int i = index3 + size3 - 1; i >= index3; --i)
					list.set ( i + 1, list.get ( i )  );
				++index3;
				list.set ( index2 + size2 , value );
				++size2;
			}
			else {
				list.set ( index2 + size2  , value );
				++size2;
			}
		}
		else {
			if(index3 + size3 == list.size())
			{
				list.add ( value );
			}
			else {
				list.set ( index3 + size3, value );
				++size3;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Solution01 solution01 = new Solution01();
		solution01.push ( 1 , 5 );
		solution01.push ( 1 , 9 );
		solution01.push ( 2 , 10 );
		solution01.push ( 2 , 32 );
		solution01.push ( 3 , 54 );
		solution01.push ( 3 , 87 );
		System.out.println("the peek element of the first stack is " + solution01.peek ( 1 ));
		System.out.println("the peek element of the second stack is " + solution01.peek ( 2 ));
		System.out.println("the peek element of the third stack is " + solution01.peek ( 3 ));
		
	}
}
