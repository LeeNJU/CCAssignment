package Ch4;
public class Solution08 {
	//passed on leetcode
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
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
	{
		if(root == null || root == node1 || root == node2)
			return root;
		
		TreeNode left = commonAncestor ( root.left , node1 , node2 );
		TreeNode right = commonAncestor ( root.right , node1 , node2 );
		if(left != null && right != null)
			return root;
		return left == null ? right : left;
	}
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode ( 7 );
		TreeNode node2 = new TreeNode ( 4 );
		TreeNode node3  = new TreeNode ( 9 );
		node1.left = node2;
		node1.right = node3;
		System.out.println("the common ancestor of 4 and 9 is :" + commonAncestor ( node1 , node2 , node3 ).val);
	}
}
