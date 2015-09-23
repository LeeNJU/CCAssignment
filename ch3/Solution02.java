package Ch3;

import java.util.Stack ;

public class Solution02 {

//my solution comes from this website:  http://leetcodesolution.blogspot.com/2014/11/leetcode-min-stack.html
	
	private Stack<Integer> s = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>(); // use another stack to store the smallest elements
	
	public void push(int value) // this part also comes from the website listed above
	{
		s.push ( value );
		if(min.isEmpty ( ))
			min.push ( value );
		
		if(value < min.peek ( ))
			min.push ( value );
	}
	
	public void pop() // this part also comes from the website listed above
	{
		s.pop ( );
		if(min.peek ( ) == s.peek ( ))
			min.pop ( );
	}
	
	public int getMin()
	{
		return min.peek ( );
	}
	
	public static void main(String[] args)
	{
		Solution02 solution02 = new Solution02 ( );
		solution02.push ( 3 );
		solution02.push ( 9 );
		solution02.push ( 19 );
		solution02.push ( 78 );
		System.out.println("the smallest element is " + solution02.getMin ( ));
	}
}
