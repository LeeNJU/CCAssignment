package Ch4;

public class Solution04 {
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
	
	private static int height(TreeNode root) // calculate the height of a tree
	{
		if(root == null)
			return 0;
		
		return Math.max ( height ( root.left) , height ( root.right) ) + 1;
		
	}
	public static boolean checkBalanced(TreeNode root)
	{
		if(root == null || (root.left == null && root.right == null))
			return true;
		
		int left_height = height ( root.left );// compare the heights of left subtree and right subtree
		int right_height = height ( root.right );
		if(Math.abs ( left_height - right_height ) > 1)
			return false;
		
		return checkBalanced ( root.left ) && checkBalanced ( root.right );
	}
}
