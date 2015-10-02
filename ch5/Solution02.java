package Ch5;

public class Solution02 {

	public static String convertDecimalToBinary(float num)
	{
		String result = "";
		while(num != (float)0.0 && result.length ( ) < 24)
		{
			num *= 2;
			int t = (int)num;
			result += Integer.toString ( t );
			num -= t;
		}
		if(num != 0 && result.length ( ) >= 24)
			return "ERROR";
		
		if(result.length ( ) < 24)
		{
			int k = 24 - result.length ( );
			while(k > 0)
			{
				--k;
				result += "0";
			}
		}
		return result;
	}
	//  0.5  0.1
	public static String convert(float num)
	{
		String s = convertDecimalToBinary ( num );
		if(s == "ERROR")
			return "ERROR";
		
		int count = 1;
		for(int i = 0; i < s.length ( ); ++i)
		{
			if(s.charAt ( i ) == '1')
				break;
			else {
				++count;
			}
		}
		s = s.substring ( count  );
		if(s.length ( ) < 24)
		{
			int k = 24 - s.length ( );
			while(k > 0)
			{
				--k;
				s += "0";
			}
		}
		int decimal = 127 - count;
		String result = "";
		if(num >= 0)
			result += "0";
		else
			result += "1";
		String exponent = Integer.toBinaryString ( decimal );
		if(exponent.length ( ) < 8)
		{
			int k = 8 - exponent.length ( );
			while(k > 0)
			{
				--k;
				exponent = "0" + exponent;
			}
		}
		result += exponent;
		result += s;
		return result;
	}
	public static void main(String[] args)
	{
		float a = ( float ) 0.25;
		System.out.println(convert ( a));
	}
}
