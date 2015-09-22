package Ch4;

public class Solution01 {
	//use a two-dimensional array to represent a graph
	public static boolean routeBetweenNodes(int[][] graph, int n, int node1, int node2)
	{
		if(node1 >= n || node2 >= n)
			return false;
		
		for(int i = 0; i < n; ++i)
		{
			boolean existed = false;
			if(graph[node1][i] != 0)
			{
				if(graph[node1][i] == node2)
					return true;
				
				existed = routeBetweenNodes ( graph , n , i , node2 );
				if(existed)
					return true;
			}			
		}
		return false;
	}
}
