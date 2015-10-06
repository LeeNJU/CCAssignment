package Ch5;

//I looked at the solution in the book
public class Solution08 {

	public static void draw(byte[] screen, int width, int x1, int x2, int y)
	{
		x1 = (x1 <= x2 ? x1 : x2); //assume that x1 is always smaller than x2
		x2 = (x2 >= x1 ? x2 : x1);
		
		int start_position = x1 % 8;
		int numberOfBytes = 0;
		int end_position = x2 % 8;
		if(x2 / 8 - x1 / 8 > 1)//calculate the number of bytes between x1 and x2
			numberOfBytes = x2 / 8 - x1 / 8 - 1;;
		
		int index1 = x1 / 8 + 1;//set the bytes 
		for(int i = index1; i < x2 / 8 && numberOfBytes > 0; ++i)
		{
			screen[(width / 8) * y + i - 1] = (byte)0xFF;
			--numberOfBytes;
		}
		
		int count = 7 - start_position;
		byte mask = 1;
		while(count > 0)
		{
			mask = (byte)(mask << 1);
			mask += 1;
			--count;
		}
		mask = (byte)(0xff & mask);
		screen[(width / 8) * y + x1 / 8] = (byte)(screen[(width / 8) * y + x1 / 8] | mask); // set the position of x1
		
		count = 7 - end_position;
		mask = (byte)0xff;
		mask = (byte)(mask << count);
		screen[(width / 8) * y + x2 / 8] = (byte)(screen[(width / 8) * y + x2 / 8] | mask); // set the position of x2
	}
}
