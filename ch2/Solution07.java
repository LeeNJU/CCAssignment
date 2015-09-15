public class Solution07 {
	
	class ListNode
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
	public ListNode intersect(ListNode list1, ListNode list2)
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
}
