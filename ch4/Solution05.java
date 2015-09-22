package Ch4;

import java.util.ArrayList ;
import java.util.Stack ;


public class Solution05 {
//inorder traveral of binary search tree and check it is a valid binary tree
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
}
