package Ch4;

public class Solution02 {
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
	
	private static TreeNode buildTree(int[] array, int first, int last)
	{
		TreeNode root = null;
		if(first <= last)  //make the element in the middle be the root
		{
			int middle = (first + last) / 2;
			root = new TreeNode ( array[middle]  );
			root.left = buildTree ( array , first , middle - 1  );
			root.right = buildTree ( array , middle + 1 , last );
		}
		return root;
	}
	public static TreeNode minimalTree(int[] array)
	{
		return buildTree ( array , 0 , array.length - 1 );
	}
}
