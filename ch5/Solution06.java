package Ch5;

public class Solution06 {
//I looked at the solution in the book
	public static int conversion(int m, int n)
	{
		int count = 0;
		int num = m ^ n;
		while(num != 0)
		{
			if(num % 2 == 1)
				++count;
			num = num >> 1;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		int m = 29, n = 15;
		System.out.println(conversion ( m , n ));
	}
}
