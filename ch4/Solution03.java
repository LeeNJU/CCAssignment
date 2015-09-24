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
    	TreeNode headNode = null;
    	while(!queue.isEmpty ( ))
    	{
    		TreeNode node = queue.peek ( );
    		queue.poll ( );
    		if(node == null)
    		{
    			result.add ( headNode );
    			headNode = null;
    			n = null;
    		}
    		else {
    			if(node.left != null)
				queue.add ( node.left );
    			if(node.right != null)
				queue.add ( node.right );
    			
				if(!queue.isEmpty ( ) && queue.peek ( ) == null)
					queue.add ( null );
				if(n == null)
				{
					n = new TreeNode ( node.val );
					headNode = n;
				}

				else {
					n.next = new TreeNode ( node.val );
					n = n.next;
				}
			}
    	}
    	return result;
    }
    
    public static void print(List<TreeNode> list)
    {
    	for(TreeNode node : list)
    	{
    		while(node != null)
    		{
    			System.out.print ( node.val + "  " );
    			node = node.next;
    		}
    		System.out.println ( );
    	}
    }
    public static void main(String[] args)
    {
    	TreeNode node1 = new TreeNode ( 0 );
    	TreeNode node2 = new TreeNode ( 1 );
    	TreeNode node3 = new TreeNode ( 2 );
    	node1.left = node2;
    	node1.right = node3;
    	print ( depthOfLists ( node1 ));
    }
}
