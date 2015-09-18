package Week1;

public class Solution02 {
	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode(int value)
		{
			this.val = value;
		}
	}

//first calculate the length of the list, then move pointer
	public static ListNode kthElementToLast(ListNode head, int k)
	{
		int length = 0;
		ListNode node = head;
		while(node != null)//calculate the length of the list
		{
			++length;
			node = node.next;
		}

		int count = length - k;
		node = head;
		while(count != 0)
		{
			node = node.next;
			--count;
		}
		return node;
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
		ListNode p1 = new ListNode ( 0 );
		ListNode p2 = new ListNode ( 1 );
		ListNode p3  =new ListNode ( 5 );
		ListNode p4 = new ListNode ( 8 );
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		System.out.print ( "the list is:"  );
		printList ( p1 );
		p1 = kthElementToLast ( p1 , 2 );
		System.out.println ( "now the kth node is:"  + p1.val);
	}
}
