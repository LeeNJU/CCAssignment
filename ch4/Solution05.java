package Ch4;

import java.util.ArrayList ;
import java.util.Stack ;


public class Solution05 {
//inorder traveral of binary search tree and check it is a valid binary tree
	//passed on leetcode
	static class TreeNode
	{
		int val;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode ( int value )
		{
			this.val = value;
		}
	}
	public static boolean validateBST(TreeNode root)
	{
		//inorder traversal
		if( root == null)
			return  true;
		
		Stack<TreeNode> q = new Stack<TreeNode> ( );
		TreeNode current = root;
		while(current != null)
		{
			q.add ( current );
			current = current.left;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!q.isEmpty ( ))
		{
			TreeNode node = q.peek ( );
			q.pop ( );
			list.add ( node.val );
			if(list.size() >= 2 && list.get(list.size() - 2) >= list.get(list.size() - 1))
			{
			    return false;
			}
			node = node.right;
			while(node != null)
			{
				q.add ( node );
				node = node.left;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode ( 4 );
		TreeNode node2 = new TreeNode ( 0 );
		TreeNode node3 = new TreeNode ( 8 );
		node1.left = node2;
		node1.right = node3;
		System.out.println("is this a valid binary search tree :" + validateBST ( node1 ));
	}
}
