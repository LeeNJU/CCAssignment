package Ch10;

import java.util.ArrayList ;

public class Solution05 {

	public static int sparseSearch(ArrayList<String> list, String s)
	{
		int first = 0, last = list.size() - 1, middle = 0;
		while(first <= last)
		{
			middle = first + (last - first) / 2;
			if(list.get ( first) == "")
				++first;
			else if(list.get ( last ) == "")
				--last;
			else if(list.get ( middle ) == s)
				return middle;
			else if(list.get ( middle ) == "")
			{
				if(list.get ( first ).compareToIgnoreCase ( s ) < 0)
					++first;
				if(list.get ( first ).compareToIgnoreCase ( s ) == 0)
					return first;
				if(list.get ( last ).compareToIgnoreCase ( s ) > 0)
					--last;
				if(list.get ( last ).compareToIgnoreCase ( s ) == 0)
					return last;
			}
			else if(list.get ( middle ).compareToIgnoreCase ( s ) <= 0)
				first = middle + 1;
			else {
				last = middle - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add ( "at" );
		list.add ( "" );
		list.add ( "" );
		list.add ( "" );
		list.add ( "ball" );
		list.add ( "" );
		list.add ( "" );
		list.add ( "car" );
		list.add ( "" );
		list.add ( "" );
		list.add ( "dad" );
		list.add ( "" );
		list.add ( "" );
		System.out.println(sparseSearch ( list , "dad" ));
	}
}
