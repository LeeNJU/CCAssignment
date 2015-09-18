package Week1;
public class Solution06 {
 //iterate the string s, use variable count to store the number of characters, use variable
// current to store characters that we are counting
	public static String compression(String s)
	{
		if(s.isEmpty()) //if s is empty, return s
			return s;
		
		String result = "";
		int count = 1;//use count to store the number of characters
		char current = s.charAt(0); // current represents the current character
		for(int i = 1; i < s.length(); ++i)
		{
			if(s.charAt(i) == current) //if s[i] is equal to current, ++count
				++count;
			else //
			{
				result += current;
				result += Integer.toString(count);
				count = 1;
				current = s.charAt(i);
			}
		}
		result += current;
		result += Integer.toString(count);
		return result.length() < s.length() ? result : s; 
	}
	
	public static void main(String[] args) 
	{
		String s = "aabddddjjjjjjeeee";
		System.out.println("the string before compression is :" + s);
		s = compression ( s );
		System.out.println("after calling this function: " + s);
	}
}
