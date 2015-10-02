package Ch5;

public class Solution01 {

	public static int insertion(int m, int n, int i, int j)
	{
		m = m << i;
		int number = 1;
		number = number << i;
		int max = Integer.MAX_VALUE;
		for(int index = i; index < j; ++index)
		{
			max ^= number;
			number = number << 1;
		}
		
		n = max & n;
		return m + n;
	}
	
	public static void main(String[] args)
	{
		int m = 1, n = 8; //the representation of 8 is 1000, the representation of m is 01
		int i = 2, j = 2;
		System.out.println(insertion ( m , n , i , j ));
	}
}
