

public class Solution06 {
	class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
//reverse a linked list
	private ListNode reverse(ListNode head)
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
    public boolean isPalindrome(ListNode head) {
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
}
