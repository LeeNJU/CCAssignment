package Ch4;

public class Solution01 {
	//use a two-dimensional array to represent a graph
	public static boolean routeBetweenNodes(int[][] graph, boolean[] visited, int n, int node1, int node2)
	{
		if(node1 >= n || node2 >= n)
			return false;
		
		visited[node1] = true;
		for(int i = 0; i < n; ++i)
		{
			boolean existed = false;
			if(graph[node1][i] != 0)
			{
				if(i == node2)
					return true;
				if ( visited[i] ) {
					continue;
				}
				existed = routeBetweenNodes ( graph , visited,  n , i , node2 );
				if(existed)
					return true;
			}			
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		int[][] graph = {{0,1,1}, {1,0, 0}, {1,0, 0}};
		boolean[] visited = {false, false, false};
		System.out.println("is there a rout between node0 and node2: " + routeBetweenNodes ( graph , visited, 3 , 0 , 2 ));
		
	}
}
