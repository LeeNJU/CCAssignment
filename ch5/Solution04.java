package Ch5;

public class Solution04 {
//I looked at the solution in the book
	public static int nextBiggest(int num)
	{
		int temp = num;
		int count = 0;
		while(temp % 2 == 0)// skip all the trailing zeros
		{
			temp = temp >> 1;
			++count;
		}
		
		while(temp % 2 == 1)//find the rightmost non-trailing 0
		{
			temp = temp >> 1;
			++count;
		}
		
		num += 1 << count; // set the count bit to 1
		num -= 1 << (count - 1); // set the count - 1 bit to 0
		return num;
	}
	
	public static int nextSmallest(int num)
	{
		int temp = num;
		int count = 0;
		while(temp % 2 == 1)//skip all the trailing 1
		{
			temp = temp >> 1;
		    ++count;
		}
		while(temp % 2 == 0)//skip the rightmost nontrailing 0
		{
			temp = temp >> 1;
		    ++count;
		}
		
		num -= (1 << count);
		num += (1 << (count - 1));
		return num;
	}
	public static void main(String[] args)
	{
		int num = 2;
		System.out.println(nextSmallest ( num )); // it should be 1
		System.out.println(nextBiggest ( num )); // it should be 4
	}
}
