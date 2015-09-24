package Ch4;

import java.util.ArrayList ;
import java.util.LinkedList ;


public class Solution09 {

	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode ( int value )
		{
			this.val = value;
		}
	}
	
	
	private static LinkedList<LinkedList<Integer>> permutation(LinkedList<LinkedList<Integer>> result, int root, LinkedList<Integer> list1, int index1, LinkedList<Integer> list2, int index2)
	{
		if(index1 >= list1.size() )
		{
			for(int i = index2; i < list2.size ( ); ++i)
			{
				list1.add ( list2.get ( i ) );
			}
			list1.add ( 0 , root );
			result.add ( list1 );
			return result;
		}
		
		LinkedList<Integer> copyList1 = new LinkedList<Integer> (list1 );
		LinkedList<Integer> copyList2 = new LinkedList<Integer> ( list2);
		for(int i = index1; i < copyList1.size(); ++index1)
		{
			for(int j = index2; j < copyList2.size ( ); ++index2)
			{
				copyList1.add ( i , copyList2.get ( j ) );
				permutation ( result , root, copyList1 , i + 1 , copyList2 , j + 1 );
			}
			copyList1 = new LinkedList<Integer>(list1);
		}
		return result;
	}
	public static LinkedList<LinkedList<Integer>> bstSequences(LinkedList<LinkedList<Integer>> result, TreeNode root)
	{
		if(root == null)
			return new LinkedList<LinkedList<Integer>> ( );
		
		LinkedList<LinkedList<Integer>> left = bstSequences (result, root.left );
		LinkedList<LinkedList<Integer>> right = bstSequences (result,  root.right );
		
		if(left.size() == 0 && right.size() == 0)
		{
			LinkedList<Integer> l = new LinkedList<Integer>();
			l.add ( root.val );
			result.add ( l );
			return result;
		}
		else if(left.size() == 0)
		{
			for(int i = 0; i < right.size ( ); ++i)
			{
				LinkedList<Integer> a = right.get ( i );
				a.add ( root.val );
				result.add ( a );
			}
			return result;
		}
		else if(right.size() == 0)
		{
			for(int i = 0; i < left.size ( ); ++i)
			{
				LinkedList<Integer> a = left.get ( i );
				a.add ( root.val );
				result.add ( a );
			}
			return result;
		}
		else {
			for(int i = 0; i < left.size(); ++i)
			{
				for(int j = 0; j < right.size ( ); ++j)
				{
					permutation ( result , root.val, left.get ( i ) , 0 , right.get ( j ) , 0 );
				}
			}
			return result;
		}
		
	}
	
	public static void main(String[] args)
	{
		TreeNode node1 =new TreeNode ( 2 );
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>> ( );
		result = bstSequences ( result , node1 );
		System.out.println(result.size());
	}
}
