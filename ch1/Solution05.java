package Week1;

public class Solution05 {
//use dynamic programming to calculate the how many steps needed to convert s1 to s2, then check the last step if it is equal to 1
	public static boolean oneAway(String s1, String s2)
	{
		int[][] dp = new int[s1.length ( ) + 1][s2.length ( ) + 1];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		
		for(int i = 0; i < s1.length ( ); ++i)
		{
			for(int j = 0; j < s2.length ( ); ++j)
			{
				if(s1.charAt ( i ) == s2.charAt ( j ))
					dp[i + 1][j + 1] = dp[i][j];
				else {
					dp[i + 1][j + 1] = Math.min ( Math.min ( dp[i][j + 1] , dp[i + 1][j] ) , dp[i][j] ) + 1;
				}
			}
		}
		return dp[s1.length ( )][s2.length ( )] == 1;
	}
	
	public static void main(String[] args)
	{
		String s1 = "pale";
		String s2 = "pal";
		System.out.println("the two strings are " + s1 + ",  " + s2);
		System.out.println("the result is " + oneAway(s1, s2));
	}
}
