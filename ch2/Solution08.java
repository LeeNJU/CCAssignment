package Week1;

public class Solution08 {

	class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
	
	public ListNode detectLoop(ListNode head)
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
}
