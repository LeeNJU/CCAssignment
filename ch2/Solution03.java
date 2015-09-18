package Week1;


public class Solution03 {
	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
//assume that variable node is the middle node we are going to delete, swap the value of node
	// and the value of node's successor. then link node and its successor's successor
	public static void deleteMiddleNode(ListNode node)
	{
		if(node == null)
        	return ;
        
        int t = node.val;
        node.val = node.next.val;
        node.next.val = t;
        node.next = node.next.next;   
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
		ListNode node = new ListNode ( 0 );
		ListNode nodetwo = new ListNode ( 1 );
		ListNode nodethree = new ListNode ( 2 );
		node.next = nodetwo;
		nodetwo.next = nodethree;
		System.out.println("list is :" + node.val + " " + nodetwo.val + " " + nodethree.val);
		deleteMiddleNode ( nodetwo );
		System.out.println("list now is :" + node.val + " " + node.next.val);
	}
}
