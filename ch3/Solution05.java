package Ch3;

import java.util.Stack ;

public class Solution05 {

	public static Stack<Integer> sortStack(Stack<Integer> s)
	{
		if(s.isEmpty ( ) || s.size ( ) == 1)
			return s;
		
		Stack<Integer> t = new Stack<Integer>();
		int min = s.peek ( );
		t.add ( min );
		s.pop ( );
		while(!s.isEmpty ( ) ) //copy elements in s to t and find the smallest element in s
		{
			int value = s.peek ( );
			s.pop ( );
			
			if(value < min)
				min = value;
			t.add ( value );
		}
		
		int count = 0;
		while(!t.isEmpty ( ))  // copy elements in t to s, except for the smallest elements
		{                             // use variable count to count the number of the smallest elements
			int value = t.peek ( );
			t.pop ( );
			if(value != min)
				s.add ( value );
			if(value == min)
				++count;
		}
		
		for(int i = 0; i < count; ++i) //push all the smallest elements into s
		{
			t.add ( min );
		}
		return t;
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push ( 78 );
		stack1.push ( 56 );
		//stack1.push ( 1 );
		stack1.push ( 89 );
		stack1.push ( 100 );
		stack1.push ( 2 );
		stack1 = sortStack(stack1);
		System.out.println("the smallest element is " + stack1.peek ( ));
	}
}
