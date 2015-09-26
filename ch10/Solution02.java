package Ch10;

import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.LinkedList ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;
public class Solution02 {

	//bugs
	public static ArrayList<String> groupAnagrams(ArrayList<String> list)
	{
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String , ArrayList<String>> map = new HashMap<String, ArrayList<String>> ( );
		for(int i = 0; i < list.size ( ); ++i)
		{
			String s = list.get ( i );
			char[] arr = s.toCharArray ( );
			Arrays.sort(arr);
			String sub = new String(arr);
			if(map.containsKey ( sub ))
			{
				ArrayList<String> lists = new ArrayList<String>(map.get ( sub ));
				lists.add ( list.get ( i ) );
				map.put ( sub , lists );
				lists = map.get ( sub );
			}
			else {
				ArrayList<String> lists = new ArrayList<String>();
				lists.add ( list.get ( i ) );
				map.put ( sub , lists );
			}
		}
		
		Set   set = map.entrySet ( );
		Iterator iter = set.iterator ( );
		while(iter.hasNext ( ))
		{
			Entry<String , ArrayList<String>> entry = (Entry<String , ArrayList<String>>)iter.next ( );
			for(String string : entry.getValue ( ))
				result.add ( string );
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		String s1 = "abc";
		String s2 = "jhg";
		String s3 = "bac";
		String s4 = "hgj";
		ArrayList<String> list = new ArrayList<String>();
		list.add ( s1 );
		list.add ( s2 );
		list.add ( s3 );
		list.add ( s4 );
		list = groupAnagrams ( list );
		for(int i = 0; i < list.size ( ); ++i)
		{
			System.out.print ( list.get ( i )  + "  ");
		}
		System.out.println ( );
	}
}
