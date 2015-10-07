package Ch6;

import java.util.Random ;

//I looked at the solution in the book.
//We use 0 to represent girl, 1 to represent boy. So for every family, the sequence of their child will be 1...10
//In every sequence, the number of 1 can be 0 or very large. So we put all the sequence together. Then we can 
//transform this problem to determine the probability of the next character in the sequence. Since the probability
// of having a boy or a girl is 0.5. So the probability of the next character in the sequence is also 0.5. So the gender
//ratio of the new generation is also 50%!!!
public class Solution07 {

	//I also looked at the simulation code in the book
	public static double generationRatio(int n)//return the ratio between girl and boy, result should be close to 1
	{
		int numOfBoy = 0, numOfGirl = 0;
		for(int i = 0; i < n; ++i)// calculate the number of boys and girls in the whole population
		{
			int boy = 0, girl = 0;
			while(girl == 0)//this is to simulate the child sequence of every family
			{
				Random random = new Random ();
				if(random.nextInt ( ) % 2 == 0)
					++girl;
				else 
					++boy;
			}
			numOfBoy += boy;
			numOfGirl += girl;
		}
	return (double)numOfGirl / numOfBoy;
}
	
	public static void main(String[] args)
	{
		int n = 100;
		System.out.println(generationRatio ( n ));
	}
}
