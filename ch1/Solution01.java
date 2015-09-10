
public class Solution01 {

	public boolean isUnique(String s)
	{
		for(int i = 0; i < s.length(); ++i)
		{
			for(int j = i + 1; j < s.length(); ++j)
			{
				if(s.charAt(j) == s.charAt(i))
					return fales;
			}
		}
		return true;
	}
}
