package Week1;

public class Solution08 {

	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
	
	public static  ListNode detectLoop(ListNode head)
	{
		if(head == null)
			return head;
		
		//ptr2 move 2 steps and ptr1 moves 1 step each time. when ptr1 equals ptr2, make ptr1 equals to head, 
		// then ptr1 and ptr2 move 1 step each time until ptr1 = ptr2
		ListNode ptr1 = head, ptr2 = head;
		while(ptr2.next != null && ptr2.next.next != null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1 == ptr2)
			{
				ptr1 = head;
				while(ptr1 != ptr2)
				{
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				}
				return ptr2;
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		ListNode p1 = new ListNode ( 0 );
		ListNode p2 = new ListNode ( 4 );
		ListNode p3 = new ListNode ( 6 );
		ListNode p4 = new ListNode ( 12 );
		ListNode p5 = new ListNode ( 45 );
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p3;
		
		System.out.println ( "List is :" + p1.val +" " + p2.val + " " + p3.val + " " + p4.val + " " + p5.val + " " + p3.val);
		System.out.println("loop begins at node :" + detectLoop ( p1 ).val);
	}
}
