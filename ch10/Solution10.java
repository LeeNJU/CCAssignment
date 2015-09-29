package Ch10;

//I looked at the solution in the book and I implemented a binary search tree myself
class BinaryNode
{
	public  int val = 0;;
	public  int left_size = 0;
	public  int right_size = 0;
	public  int numberOfDuplicates = 0;
	public  BinaryNode left = null;
	public  BinaryNode right = null;
	public BinaryNode ( int value )
	{
		val = value;
	}
}

public class Solution10
{
	public BinaryNode root = null;
	private BinaryNode insert(BinaryNode node, int value)
	{
		if(node == null)
		{
			node = new BinaryNode(value);
			return node;
		}
		
		if(node.val < value)
		{
			node.right = insert ( node.right , value );
		    node.right_size++;
		}
		else {
			node.left = insert ( node.left , value );
			node.left_size++;
		}
		return node;
	}
	
	public  void insert(int value)
	{
		insert ( root, value );
	}
	
	public  int track(int value)
	{
		BinaryNode node = root;
		while(node != null)
		{
			if(node.val == value)
				return node.left_size + node.right_size + 1;
			else if(node.val < value)
				node = node.right;
			else
				node = node.left;
		}
		return -1;
	}
}
