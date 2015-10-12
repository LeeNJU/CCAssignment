package Ch10;

import java.io.*;
import java.util.Scanner ;

public class Solution07 {
//I looked at the solution in the book and I implemented it myself
	public static void number(String filename)
	{
		Scanner scanner = null;
		Byte[] bytes = new Byte[(int)((long)Integer.MAX_VALUE / 8)];//this line of code is from the book
		try {
			FileReader fileReader = new FileReader ( filename  );
			scanner = new Scanner(fileReader);
		}
		catch ( Exception e ) {
			// TODO: handle exception
			e.printStackTrace ( );
		}
		while(scanner.hasNextInt())
		{
			int value = scanner.nextInt ( );
			byte t = ( byte ) ( 1 << value & 8 );
			bytes[value / 8]  = ( byte ) ( bytes[value / 8] + t ) ; 
		}
		
		for(int i = 0; i < bytes.length; ++i)
		{
			for(int j = 1; j <= 8; ++j)
			{
				if(bytes[i] % 2 == 1)
					System.out.println(i * 8 + j);
			}
		}
	}
}
