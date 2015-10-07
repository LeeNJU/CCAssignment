package Ch6;

import java.util.ArrayList ;
//I looked at the solution in the book
//We assign 1, 2, 3,..., to each bottle. We test all the bottles of soda at one day. Seven days later, we can determine
//which bottle is poisonous. Then we use the following way to determine which bottle is poisonous. There are 10
//test strips. If the number of bottle has a 1 in ith bit, we test the bottle on the ith test strip. If the ith test strip turns to
//be positive, we know that the ith bit of the poisonous bottle number will be 1. So we can compute the number of 
//of the poisionous bottle


public class Solution10 {
	//I also looked at the code  in the book
	static class Bottle
	{
		private int id;
		private boolean poisonous = false;
		public Bottle(int i)
		{
			id = i;
			poisonous =false;
		}
		
		public int getId()
		{
			return id;
		}
	} 
	
	static class Strip
	{
		private ArrayList<Bottle> list = new ArrayList<Bottle>();
		private int id;
		private boolean testResult = false;
		public Strip ( int i )
		{
			id = i;
		}
		public void addBottle(Bottle bottle)
		{
			list.add ( bottle );
		}
		public boolean getResult()
		{
			return testResult;
		}
	}
	//follow up
	public void test(ArrayList<Bottle> bottles, ArrayList<Strip> strips)
	{
		for(int i = 0; i < bottles.size ( ); ++i)
		{
			int id = bottles.get ( i ).getId ( );
			int count = 1;
			while(count <= 10)
			{
				++count;
				if(id % 2 == 1)//the bit is 1, put the bottle into corresponding strips
					strips.get ( count ).addBottle ( bottles.get ( i ) );
				id = id >> 1;
			}
		}
	}
	
	public static int getResult(ArrayList<Bottle> bottles, ArrayList<Strip> strips)
	{
		int result = 0;
		for(int i = 0; i < strips.size ( ); ++i)
		{
			if(strips.get ( i ).getResult ( ))//the test result is positive, then the bit is 1
				result += 1;
			result = result << 1;
		}
		return result;
	}
}
