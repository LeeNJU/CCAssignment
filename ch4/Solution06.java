package Ch4;

public class Solution06 {

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
	
	public static TreeNode successor(TreeNode node)
	{
		if(node == null)
			return node;
		
		if(node.right != null)// it has right child
		{
			node = node.right;
			while(node.left != null)
			{
				node = node.left;
			}
			return node;
		}
		else { // it has no right child
			return node.parent;
		}
	}
	
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode ( 4 );
		TreeNode node2 = new TreeNode ( 2 );
		TreeNode node3 = new TreeNode ( 8 );
		node1.left = node2;
		node1.right = node3;
		System.out.println("The successor of node1 is :" +successor ( node1 ).val);
	}
}
