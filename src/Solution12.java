public class Solution12 {

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
	
	public  static int path(TreeNode root, int sum)
	{
		if(root == null)
			return 0;
		
		if( root.val == sum)
			return 1;
		
		return path ( root.left , sum - root.val) + path ( root.right , sum - root.val );
	}
	
	public static int pathSum(TreeNode root , int sum)
	{
		if(root == null)
			return 0;
		
		return pathSum ( root.left , sum ) + pathSum ( root.right , sum ) + pathSum ( root , sum );
	}
	
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode ( 8 );
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode ( 5 );
		node1.left = node2;
		node1.right = node3;
		
		System.out.println("the number of paths is " + pathSum ( node1 , 12 ));
	}
}
