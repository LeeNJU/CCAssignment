import java.util.HashSet;

class ListNode
{
	public int val;
	public ListNode next;
	public ListNode(int value)
	{
		this.val = value;
	}
}

public class Solution01 {

	//Use a HashSet to contain all the elements that have been iterated, if one element
	//is already in the HashSet, we remove this element
	public ListNode removeDupplicate(ListNode head)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode dummy = new ListNode(0); //use a dummy node to represent the previous node 
		dummy.next = head; 
		ListNode prev = dummy;
		while(head.next != null)
		{
			if(set.contains(head.val))
				prev.next = head.next;
			else 
			{
				set.add(head.val);
				prev = head;
			}
			head = head.next;
		}
		return dummy.next;
	}
	
//Follow up:
//for every node in the list, check if it is duplicated, if it is duplicated, remove this node
	public ListNode removeDuplicateFollowup(ListNode head)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;//use a dummy node to represent the previous node
		while(head.next != null)
		{
			ListNode node = head.next;
			boolean isDuplicated = false;
			while(node != null)
			{
				if(node.val == head.val)
				{
					isDuplicated = true;
					break;
				}
				node = node.next;
			}
			if(isDuplicated)
				prev.next = head.next;
			else 
				prev = head;
			
			head = head.next;
		}
		return dummy.next;
	}
}

