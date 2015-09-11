package Week1;

class ListNode
{
	public int val;
	public ListNode next;
	public ListNode(int value)
	{
		this.val = value;
	}
}

public class Solution02 {
//first calculate the length of the list, then move pointer
	public ListNode kthElementToLast(ListNode head, int k)
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
}
