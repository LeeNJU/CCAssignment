package Week1;

public class Solution04 {

	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
	
	public static ListNode partition(ListNode head, int k)
	{
		ListNode left_dummy = new ListNode( 0 );
		ListNode left = left_dummy;
		ListNode right_dummy = new ListNode ( 1 );
		ListNode right = right_dummy;
		while(head != null)
		{
			if(head.val < k)
			{
				left.next = head;
				left = left.next;
			}
			else 
			{
					right.next = head;
					right = right.next;
			}
			head = head.next;
		}
		right.next = null;
		left.next = right_dummy.next;
		return left_dummy.next;
	}
	public static void printList(ListNode node)
	{
		while(node != null)
		{
			System.out.print ( node.val + "  " );
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode ( 12 );
		ListNode node2 = new ListNode ( 4 );
		ListNode node3 = new ListNode ( 9 );
		ListNode node4 = new ListNode ( 8 );
		ListNode node5 = new ListNode ( 13 );
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.print ( "the list is :" );
		printList ( node1 );
		System.out.println("now partition the list with k = 12");
		node1 = partition ( node1 , 12 );
		System.out.print ( "after partition :" );
		printList ( node1 );
	}
}
