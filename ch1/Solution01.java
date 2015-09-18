package Week1;
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
		String s = "dfadek";
		System.out.println("the string is: " + s);
		System.out.print ( "the string is unique or not: " );
		System.out.println(isUnique(s));
	}
}
