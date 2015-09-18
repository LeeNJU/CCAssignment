package Week1;

import java.util.Arrays;
import java.util.Scanner ;
public class Solution09 {
//convert s1 and s2 to char array, then sort these two char arrays and sort them, then convert these
//two char arrays to string, at last call isSubstring to determin if s2 is a substring of s1
	public static boolean isRotation(String s1, String s2)
	{
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		String str1 = new String(char1);
		String str2 = new String(char2);
		return str2.contains(str1);
	}
	
	public static void main(String[] args) 
	{
		String s1 = "adjfisdjf";
		String s2 = "fjdsifjda";
		System.out.println("the two string is :" + s1 + "   " + s2);
		System.out.println("result is " + isRotation ( s1 , s2 ));
	}
}
