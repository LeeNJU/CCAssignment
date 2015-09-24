package Ch3;

import java.util.LinkedList ;
import java.util.Queue ;

class Animal // comes from the book
{
	int order;
	public void setOrder(int o)
	{
		order = o;
	}
	public int getOrder()
	{
		return order;
	}
}

class Dog extends Animal //comes from the book
{
	
}
class Cat extends Animal{ // comes from the book
	
}
public class Solution06 {
//I looked at the answer in the book <<cracking the code interview>> chapter 3, some following code comes from the book
	private static int orderOfAnimals = 0;
	private static Queue<Dog> dogs = new LinkedList<Dog>();//comes from the book
	private static Queue<Cat> cats = new LinkedList<Cat> ( );
	
	
	public static void push(Dog dog)
	{
		dog.setOrder(orderOfAnimals);
		++orderOfAnimals;
		dogs.add ( dog );
	}
	
	public static Dog popDogs()
	{
		return dogs.poll ( );
	}
	
	public static void push(Cat cat)
	{
		cat.setOrder ( orderOfAnimals );
		++orderOfAnimals;
		cats.add ( cat );
	}
	
	public static Cat popCat()
	{
		return cats.poll ( );
	}
	public static void push(Animal a)//comes from the book
	{
		a.setOrder ( orderOfAnimals );
		++orderOfAnimals;
	}
	
	public static Animal pop() // this function comes from the book <<cracking the code interview>> chapter 3, it's not my code
	{
		if(dogs.isEmpty ( ))
			return cats.poll();
		if(cats.isEmpty ( ))
			return dogs.poll ( );
		
		Dog dog = dogs.peek ( );
		Cat cat = cats.peek ( );
		if(dog.getOrder ( ) > cat.getOrder ( ))
			return dogs.poll ( );
		else {
			return cats.poll ( );
		}
	}
}
