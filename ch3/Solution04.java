package Ch3;

import java.util.Stack ;

public class Solution04 {
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();
	
	 public void push(int x) {
	        s1.add ( x );
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if(s2.isEmpty ( ))
	        {
	        	while(!s1.isEmpty ( ))
	        	{
	        		s2.add ( s1.peek ( ) );
	        		s1.pop ( );
	        	}
	        }
	        s2.pop ( );
	    }

	    // Get the front element.
	    public int peek() {
	        if(s2.isEmpty ( ))
	        {
	        	while(!s1.isEmpty ( ))
	        	{
	        		s2.add ( s1.peek ( ) );
	        		s1.pop ( );
	        	}
	        }
	        return s2.peek ( );
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return s1.isEmpty ( ) && s2.isEmpty ( );
	    }
	    
	    public static void main(String[] args)
	    {
	    	Solution04 solution04 = new Solution04 ( );
	    	solution04.push ( 9 );
	    	solution04.push ( 78 );
	    	solution04.push ( 43 );
	    	System.out.println("after we push 9, 78 and 43, the queue would be:");
	    	System.out.println(solution04.peek ( ));
	    	solution04.pop();
	    	System.out.println(solution04.peek ( ));
	    	solution04.pop ( );
	    	System.out.println(solution04.peek ( ));
	    	solution04.pop ( );
	    }
}
