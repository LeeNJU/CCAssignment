package Week1;
//This solution came from Bangjie Liu. He told me this idea and I implemented it myself
public class Solution02 {
//use a constant array of size 256
	public static boolean isPermutation(String s1, String s2)
	{
		final int LENGTH = 256;
		int [] ascii = new int[LENGTH];
		for(int i = 0; i < s1.length(); ++i)
			++ascii[s1.charAt(i)];
		
		for(int i = 0; i < s2.length(); ++i)
			--ascii[s2.charAt(i)];
		
		for(int i = 0; i < LENGTH; ++i) //if all the element in the array is 0, it means that s1 is a permutation of s2
			if(ascii[i] > 0) //ascii[i] > 0 means that s1 is not a permutation of s2
				return false;
		
		return true;
	}
	
	public static void main(String[] args)
	{
		String s1 = "ajdefdxd";
		String s2 = "addefdxj";
		System.out.println("the two strings are:" + s1 + "  " + s2);
		System.out.println("s1 is permutation of s2 or not: " + isPermutation ( s1 , s2 ));
	}
}
