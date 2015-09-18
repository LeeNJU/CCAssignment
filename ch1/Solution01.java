import java.util.Scanner ;


public class Solution01 {

	public static boolean isUnique(String s)
	{
		for(int i = 0; i < s.length(); ++i) //for every character s[i], check the rest characters in s to see if there exists a duplicate element
		{                                            // if there exists a duplicate, return fales, if not, return true;
			for(int j = i + 1; j < s.length(); ++j)
			{
				if(s.charAt(j) == s.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner ( System.in );
		System.out.println("Please input a string:");
		String s = scanner.next ( );
		System.out.println("after calling this function:")
		System.out.println(isUnique(s));
	}
}
