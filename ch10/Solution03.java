package Ch10;



public class Solution03 {
//I looked at the solutions in the book <<Cracking The Code Interview>>
//I also looked at the solution on this site: http://www.lifeincode.net/programming/leetcode-search-in-rotated-sorted-array-ii-java/
	public static int searchInRotatedArray(int[] array, int n, int value)
	{
		int left = 0, right = n - 1, middle = 0;
		while(left <= right)
		{
			middle  = left + (right - left) / 2;
			if(array[middle] == value)
				return middle;
			else if(array[left] == array[right])
			{
				--right;
			}
			else if(array[middle] < array[left])
			{
				if(array[right] >= value && value >= array[middle])
					left = middle + 1;
				else {
					right = middle - 1;
				}
					
			}
			else {
				if (value < array[middle] && value >= array[left])
					right = middle - 1;
				else
					left = middle + 1;
			}
		}
		return -1;
	}
}
