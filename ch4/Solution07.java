package Ch4;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Map.Entry ;


public class Solution07 {
	
	private static String findZeroIndegree(HashMap<String , Integer> indegree)
	{
		for(Entry<String , Integer>  entry: indegree.entrySet ( ))
		{
			String s = entry.getKey ( );
			if(entry.getValue ( ) == 0)
				return s;
		}
		return null;
	}

	public static  ArrayList<String> buildOrder(String[] project, String[][] dependency)
	{
		ArrayList<String> resultStrings = new ArrayList<String>();
		HashMap<String , Integer> indegree = new HashMap<String , Integer>();
		for(int i = 0; i < project.length; ++i)
		{
			indegree.put ( project[i] , 0 );
		}
		for(int i = 0; i < dependency.length; ++i) // store all the indegree of every node
		{
			String first = dependency[i][0];
			if(indegree.containsKey ( first ))
			{
				int num = indegree.get ( first );
				indegree.remove ( first );
				indegree.put ( first , ++num );
			}
			else {
				indegree.put ( first , 1 );
			}
		}
		
		for(int i = 0; i < project.length; ++i)
		{
			String s = findZeroIndegree ( indegree );
			if(s == null)
				return resultStrings;
			
			resultStrings.add ( s );
			for(int j = 0; j < dependency.length; ++j)
			{
				String first = dependency[j][0];
				String second = dependency[j][1];
				if(s == second)
				{
					int ingree = indegree.get ( first );
					--ingree;
					indegree.remove ( first );
					indegree.put ( first , ingree );
				}
			}
			indegree.remove ( s );
		}
		return resultStrings;
	}
	
	public static void main(String[] args)
	{
		String[] strings = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencyStrings = {{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
		ArrayList<String> result = buildOrder ( strings , dependencyStrings );
		for(int i = 0; i < result.size ( ); ++i)
		{
			System.out.print ( result.get ( i ) + "  " );
		}
	}
}
