package Week1;

public class Solution06 {
	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
//reverse a linked list
	private static ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
        return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head, current = head.next;
        while(current != null)
        {
            prev.next = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = prev.next;
        }
        return dummy.next;
    }
	
	//break the list into half, then reverse a half list, then compare with the other half
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        return true;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        second = reverse(second);
        slow.next = null;
        ListNode first = head;
        while(second != null && first != null)
        {
            if(second.val != first.val)
            return false;
            
            second = second.next;
            first = first.next;
        }
        return true;
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
    	ListNode p1 = new ListNode ( 8 );
    	ListNode p2 = new ListNode ( 5 );
    	ListNode p3 = new ListNode ( 4 );
    	ListNode p4 = new ListNode ( 5 );
    	ListNode p5 = new ListNode ( 8 );
    	p1.next = p2;
    	p2.next = p3;
    	p3.next = p4;
    	p4.next = p5;
    	
    	System.out.print("the list is :");
    	printList ( p1 );
    	System.out.println("is the list palindrome or not :" + isPalindrome(p1));
    }
}
