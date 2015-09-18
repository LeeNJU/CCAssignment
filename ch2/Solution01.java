package Week1;

import java.util.HashSet ;


public class Solution01 {
	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode(int value)
		{
			this.val = value;
		}
	}
	//Use a HashSet to contain all the elements that have been iterated, if one element
	//is already in the HashSet, we remove this element
	public static  ListNode removeDupplicate(ListNode head)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode dummy = new ListNode(0); //use a dummy node to represent the previous node 
		dummy.next = head; 
		ListNode prev = dummy;
		while(head != null)
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
	public static ListNode removeDuplicateFollowup(ListNode head)
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
		ListNode node1 = new ListNode ( 0 );
		ListNode node2 = new ListNode ( 1 );
		ListNode node3 = new ListNode ( 1 );
		node1.next = node2;
		node2.next = node3;
		System.out.print("the list is :");
		printList ( node1 );
		node1 = removeDupplicate( node1 );
		System.out.print("now the list is :");
		printList ( node1 );
		
		
		System.out.println("followup :");
		ListNode node4 = new ListNode ( 0 );
		ListNode node5 = new ListNode ( 4 );
		ListNode node6 = new ListNode ( 4 );
		node4.next = node5;
		node5.next = node6;
		System.out.print ( "the list is :" );
		printList ( node4 );
		node4 = removeDuplicateFollowup ( node4 );
		System.out.print("the list now is :");
		printList ( node4 );
		
	}
}

