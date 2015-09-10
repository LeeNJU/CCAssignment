
public class Solution01 {

	public boolean isUnique(String s)
	{
		for(int i = 0; i < s.length(); ++i) //for every character s[i], check the rest characters in s to see if there exists a duplicate element
		{                                            // if there exists a duplicate, return fales, if not, return true;
			for(int j = i + 1; j < s.length(); ++j)
			{
				if(s.charAt(j) == s.charAt(i))
					return fales;
			}
		}
		return true;
	}
}
