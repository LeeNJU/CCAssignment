package Ch3;

import java.util.ArrayList ;
import java.util.Stack ;

public class Solution03 {
	private int capacity = 0;
	private ArrayList<Stack<Integer>> s = new ArrayList<Stack<Integer>>();
	
	public Solution03 ( int capacity )
	{
		this.capacity = capacity;
	}
	
	public int pop()
	{
		if(s.isEmpty ( ))
			return Integer.MAX_VALUE;
		
		int result = s.get ( s.size() - 1 ).peek ( );
		s.get ( s.size() - 1 ).pop ( );
		if(s.get ( s.size() - 1 ).isEmpty ( ))
			s.remove ( s.size() - 1 );
		return result;
	}
	public void push(int value)
	{
		for(int i = 0; i < s.size ( ); ++i)
		{
			if(s.get ( i ).size ( ) < capacity)
			{
				s.get ( i ).push ( value );
				return ;
			}
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push ( value );
		s.add ( stack );
	}
	
	public void popAt(int index)
	{
		if( index < 0 || index >= s.size())
			return ;
		
		s.get ( index ).pop ( );
		for(int i = index + 1; i < s.size ( ); ++i)
		{
			Stack<Integer> stack = s.get ( i );
			ArrayList<Integer> list = new ArrayList<Integer> ( );
			while(!stack.isEmpty ( ))
			{
				list.add ( stack.peek ( ) );
				stack.pop ( );
			}
			s.get ( index ).push ( list.get ( list.size() - 1 ) );
			list.remove ( list.size() - 1 );
			for(int j = list.size() - 1; j >= 0; --j)
			{
				s.get ( i ).push ( list.get ( j ) );
			}
		}
	}
	
	public static void main(String[] args)
	{
		Solution03 solution03 = new Solution03 ( 100 );
		solution03.push ( 19 );
		solution03.push ( 78 );
		solution03.push ( 54 );
		
	}
}
