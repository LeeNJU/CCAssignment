package Ch4;

import java.util.ArrayList ;
import java.util.LinkedList ;
import java.util.Queue ;
public class Solution11 {

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
	private static ArrayList<TreeNode> tree = new ArrayList<TreeNode> ( );
	private static TreeNode root = null;
	
	private static TreeNode insert(TreeNode currentRoot, TreeNode node)
	{
		if(root == null)
		{
			root = node;
			tree.add ( node );
			return root;
		}
		if(currentRoot == null)
		{
			currentRoot = node;
			tree.add ( node );
			return currentRoot;
		}
		
		if(currentRoot.val < node.val)
		{
			currentRoot.right = insert (currentRoot.right,  node );
		}
		else
			currentRoot.left = insert (currentRoot.left,  node );
		return currentRoot;
	}
	
	public static void insert(TreeNode node)
	{
		insert ( root, node );
	}
	
	private static TreeNode delete(TreeNode currentRoot, TreeNode node)
	{
		if(currentRoot == null)
			return null;
		
		if(currentRoot.val < node.val)
			currentRoot.right = delete ( currentRoot.right , node );
		else if(currentRoot.val > node.val)
			currentRoot.left = delete ( currentRoot.left , node );
		else {
			if(currentRoot.left == null)
				return currentRoot.right;
			else if(currentRoot.right == null)
				return currentRoot.left;
			else {
				TreeNode min = currentRoot.right;
				while(min.left != null)
				{
					min = min.left;
				}
				
				int t = min.val;
				min.val = currentRoot.val;
				currentRoot.val = t;
				currentRoot.right = delete ( currentRoot.right , min );
			}
		}
		return currentRoot;
	}
	
	public static void delete(TreeNode node)
	{
		for(int i = 0; i < tree.size(); ++i)
		{
			if(node.val == tree.get ( i ).val)
				tree.remove ( node );
		}
		delete ( root, node );
	}
	
	public static TreeNode getRandomNode()
	{
		double f = Math.random ( );
		return tree.get ( (int)(f * tree.size()) );
	}
	
	public static void print()
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode> ( );
		if(root == null)
			return ;
		queue.add ( root );
		while(!queue.isEmpty ( ))
		{
			TreeNode node = queue.peek ( );
			queue.poll ( );
			System.out.print ( node.val + "  " );
			if(node.left != null)
				queue.add ( root.left );
			if(node.right != null)
				queue.add ( root.right );
		}
		System.out.println (  );
	}
	public static void main(String[] args)
	{
		TreeNode node1= new TreeNode ( 8 );
		TreeNode node2 = new TreeNode ( 19);
		TreeNode node3 = new TreeNode ( 4 );
		Solution11 solution11 = new Solution11();
		solution11.insert ( node1 );
		solution11.insert ( node2 );
		solution11.insert ( node3 );
		print ( );
		
		solution11.delete ( node2 );
		print();
		
		TreeNode randomNode = solution11.getRandomNode ( );
		System.out.println("the randome node is " + randomNode.val);
	}
}
