package Ch10;

public class Solution04 {
//I looked at the solution in the book
	static class Listy
	{
		public static int elementAt(int i)
		{
			return 0;
		}
	}
	private static int binarySearch(Listy list, int value, int size)
	{
		int first = 0, last = size, middle = 0;
		while(first <= last)
		{
			middle = first + (last - first) / 2;
			if(list.elementAt ( middle ) == value)
				return middle;
			else if(list.elementAt ( middle ) > value)
				last = middle - 1;
			else {
				first = middle + 1;
			}
		}
		return -1;
	}
	
	public static int search(Listy list, int value)
	{
		int index = 0;
		while(list.elementAt ( index) != -1)
		{
			++index;
		}
		return binarySearch ( list , value , index - 1 );
	}
}
