
class ListNode
{
	public int val;
	public ListNode next;
	public ListNode ( int value )
	{
		this.val = value;
	}
}
public class Solution05 {

	public ListNode sumLists ( ListNode list1, ListNode list2)
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
	
	private ListNode reverseList(ListNode list) // reverse a list
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
	public ListNode sumListsFollowup(ListNode list1, ListNode list2)
	{   //reverse list1 and list2, then we can reuse the sumLists function
		list1 = reverseList ( list1 );
		list2 = reverseList ( list2 );
		return sumLists ( list1 , list2 );
	}
}
