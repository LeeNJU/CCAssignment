package Week1;


public class Solution05 {

	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
	public static ListNode sumLists ( ListNode list1, ListNode list2)
	{
		if(list1 == null) //special cases
			return list2;
		if(list2 == null)
			return list1;
		
		ListNode dummy = new ListNode ( 0 );
		ListNode result = dummy;
		int carry = 0;
		while( list1 != null || list2 != null )
		{
			int a = list1 == null ? 0 : list1.val;
			int b = list2 == null ? 0 : list2.val;
			result.next = new ListNode ( (a + b + carry) % 10 );
			result = result.next;
			carry = (a + b + carry) / 10;
			list1 = list1 == null ? null : list1.next;
			list2 = list2 == null ? null : list2.next;
		}
		
		if(carry != 0)
			result.next = new ListNode ( carry );
		
		return dummy.next;
	}
	
	private static ListNode reverseList(ListNode list) // reverse a list
	{
		if(list == null || list.next == null)
			return list;
		
		ListNode dummy = new ListNode ( 0 );
		dummy.next = list;
		ListNode prev = list;
		list = list.next;
		while(list != null)
		{
			prev.next = list.next;
			list.next = dummy.next;
			dummy.next = list;
			list = prev.next;
		}
		return dummy.next;
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
	public static ListNode sumListsFollowup(ListNode list1, ListNode list2)
	{   //reverse list1 and list2, then we can reuse the sumLists function
		list1 = reverseList ( list1 );
		list2 = reverseList ( list2 );
		return sumLists ( list1 , list2 );
	}
	
	public static void main(String[] args)
	{
		ListNode p1 = new ListNode ( 7 );
		ListNode p2 = new ListNode ( 1 );
		ListNode p3 = new ListNode ( 6 );
		p1.next = p2;
		p2.next = p3;
		
		ListNode node1 = new ListNode ( 5 );
		ListNode node2 = new ListNode ( 9 );
		ListNode node3 = new ListNode ( 2 );
		node1.next = node2;
		node2.next = node3;
		
		System.out.print("list one is : ");
		printList ( p1 );
		System.out.print ( "list two is : ");
		printList ( node1 );
		System.out.print ( "the sum is :" );
		printList ( sumLists ( p1 , node1 ) );
		System.out.println ( );
		
		System.out.println("follow up:");
		p1 = reverseList ( p1 );
		node1 = reverseList ( node1 );
		System.out.print ( "list one is:" );
		printList ( p1 );
		System.out.print ( "list two is :" );
		printList ( node1 );
		System.out.print("the sum is :");
		ListNode resultListNode = sumListsFollowup ( p1 , node1 );
		resultListNode = reverseList ( resultListNode );
		printList ( resultListNode );
	}
}
