package Ch5;

public class Solution03 {
// I looked at the solution in the book
	public static int flipBitToWin(int num)
	{
		int max_length = 0;
		int count = 0;
		int index_of_zero = -1;
		for(int i = 1; i <= 32; ++i)
		{
			if(num % 2 == 1)
				++count;
			else 
			{
				if(index_of_zero != -1)
				{
					count = i - index_of_zero;
					index_of_zero = i;
				}
				else 
				{
					index_of_zero = i;
					++count;
				}
			}
			max_length = Math.max ( max_length , count );
			num = num >> 1;
		}
		return max_length;
	}
	
	public static void main(String[] args)
	{
		int num = 3;
		System.out.println(flipBitToWin ( num ));
	}
}
