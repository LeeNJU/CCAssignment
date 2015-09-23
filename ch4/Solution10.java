package Ch4;

public class Solution10 {
	//passed on lintcode
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
	private static boolean isSame(TreeNode t1, TreeNode t2) // check if t1 is equal to t2
	{
		if(t1 == null && t2 == null)
			return true;
		
		if(t1 == null || t2 == null)
			return false;
		
		if(t1.val != t2.val)
			return false;
		
		return isSame ( t1.left , t2.left ) && isSame ( t1.right , t2.right );
	}
	public static boolean checkSubtree(TreeNode t1, TreeNode t2)
	{
		if(t1 == null && t2 != null)
		    return false;
		if(t2 == null)
		    return true;
		boolean isSubtree = false;
		if(t1.val == t2.val)
		{
			isSubtree = isSame ( t1 , t2 );
			if(isSubtree)
				return true;
		}
			return checkSubtree ( t1.left , t2 ) || checkSubtree ( t1.right , t2 );
	}
	
	public static void main(String[] args)
	{
		TreeNode p1 = new TreeNode ( 6 );
		TreeNode p2 = new TreeNode ( 4 );
		TreeNode p3 = new TreeNode ( 8 );
		p1.left = p2;
		p1.right = p3;
		
		TreeNode qNode = new TreeNode ( 8 );
		System.out.println("qNode is a subtree of p1 or not : " + checkSubtree ( p1 , qNode ));
	}
}
