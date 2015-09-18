package Week1;

public class Solution04 {

	public static boolean isPermutation(String s)
	{
		String str = "";
		for(int i = 0; i < s.length ( ); ++i)
		{
			if(s.charAt ( i ) == ' ') // ignore spaces
				continue;
			else 
				str += s.charAt ( i );
		}
		str = str.toLowerCase ( );
		int[] map = new int[256];
		for(int i = 0; i < str.length ( ); ++i)
			++map[str.charAt ( i )];
		
		int count = 0;
		for(int i = 0; i < 256; ++i)
			if(map[i] % 2 == 1)
				++count;
		
		return count > 1 ? false : true;
		
	}
	
	public static void main(String[] args)
	{
		String string = "Tact Coa";
		System.out.println("the string is :" + string);
		System.out.println("the string is a permutation of a palindrome or not :" + isPermutation(string));
	}
}
