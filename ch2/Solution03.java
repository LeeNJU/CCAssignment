
public class Solution03 {
	class ListNode
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
	public void deleteMiddleNode(ListNode node)
	{
		if(node == null)
        	return ;
        
        int t = node.val;
        node.val = node.next.val;
        node.next.val = t;
        node.next = node.next.next;   
	}
}
