package Week1;
public class Solution03 {

	public static char[] URLify(char[] array, int n )
	{
		int count = 0;
		for(int i = 0; i < n; ++i)//calculate the number of spaces in the string
		{
			if(array[i] == ' ')
				++count;
		}
		
		int index = n + count * 2 - 1; //index is the last index of this string
		for (int i = n - 1; i >= 0; --i)
		{
			if (array[i] != ' ')//if array[i] does not equal to space, move it to the index position
				array[index--] = array[i];   // then index decreases by 1
			else  //if array[i] is a space, move "%20" to the index position, then index decreases by 3
			{
				array[index--] = '0';
				array[index--] = '2';
				array[index--] = '%';
			}
		}
		return array;
	}
	
	public static void main(String[] args) 
	{
		char[] array = {'a', ' ', 'd', ' ',' ' , ' ', ' ', ' '};
		System.out.print ( "the array is :" );
		for(int i = 0; i < 3; ++i)
		{
			System.out.print ( array[i]);
		}
		System.out.println();
		array = URLify ( array , 3 );
		System.out.print("the arrray now is : ");
		for(int i = 0; i < 5; ++i)
		{
			System.out.print ( array[i] );
		}
		System.out.println ( );
	}
}
