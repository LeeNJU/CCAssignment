package Ch4;

import java.util.LinkedList ;
import java.util.List ;
import java.util.Queue ;

public class Solution03 {
	static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		public TreeNode ( int value )
		{
			this.val = value;
		}
	}
    public static List<TreeNode> depthOfLists(TreeNode root)
    {
    	List<TreeNode> result = new LinkedList<TreeNode>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add ( root );
    	queue.add ( null );
    	TreeNode n = null;
    	while(queue.isEmpty ( ))
    	{
    		TreeNode node = queue.peek ( );
    		queue.poll ( );
    		if(node == null)
    		{
    			result.add ( n );
    			n = null;
    		}
    		else {
				queue.add ( node.left );
				queue.add ( node.right );
				if(!queue.isEmpty ( ) && queue.peek ( ) == null)
					queue.add ( null );
				if(n == null)
					n = node;
				else {
					n.next = node;
					n = n.next;
				}
			}
    	}
    	return result;
    }
}
