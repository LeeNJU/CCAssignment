package Week1;
public class Solution07 {
	
	static class ListNode
	{
		public int val;
		public ListNode next;
		public ListNode ( int value )
		{
			this.val = value;
		}
	}
//first calculate the length of the two lists which is lengthA and lengthB, choose the longer list and move the pointer
	//lengthA - lengthB steps, then move pointers of list1 and list2 one step every time, when two pointers point to 
	//the same node, this node is what we want to find
	public static ListNode intersect(ListNode list1, ListNode list2)
	{
		 int lengthA = 0, lengthB = 0;
		  ListNode p1 = list1, p2 = list2;
		  while(p1 != null) //calculate the length of list1
		  {
			  ++lengthA;
			  p1 = p1.next;
		  }
		  
		  while(p2 != null) //calculate the length of list2
		  {
			  ++lengthB;
			  p2 = p2.next;
		  }
		  
		  if(lengthA >= lengthB)
		  {
			  int k = lengthA - lengthB;
			  while(k != 0)
			  {
				  list1 = list1.next;
				  --k;
			  }
		  }
		  else {
			  int k = lengthB - lengthA;
			  while(k != 0)
			  {
				  list2 = list2.next;
				  --k;
			  }
		}
		  
		 while(list1 != list2)
		 {
			 list1 = list2.next;
			 list2 = list2.next;
		 }
		 return list1;
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
	public static void  main (String[] args) {
		ListNode p1 = new ListNode ( 0 );
		ListNode p2 = new ListNode ( 4 );
		ListNode p3 = new ListNode ( 8 );
		p1.next = p3;;
		
		ListNode node1 = new ListNode ( -3 );
		ListNode node2 = new ListNode ( 78 );
		ListNode node3 = new ListNode ( 65 );
		node1.next = node2;
		node2.next = node3;
		
		ListNode commonNode = new ListNode ( 54 );
		commonNode.next = node1;
		p3.next = commonNode;
		p2.next = commonNode;
		
		System.out.print ( "List one is : ");
		printList ( p1 );
		System.out.print ( "List two is : ");
		printList ( p2 );
		System.out.println("intersect node is  " + intersect ( p1 , p2 ).val);
	}
}
