package zoo;

import java.util.Random;
import java.util.Scanner;

import animals.*;
import food.IEdible;
import mobility.Point;

/**
 * A class to perform actions on animals.
 * Also contains the main function.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Animal
 */
public class ZooActions {
	public static boolean eat(Object animal, IEdible food)
	{
		double weight = 0;
		if (animal instanceof Lion)
			weight = ((Lion) animal).getDiet().eat((Lion) animal, food);
		else if (animal instanceof Bear)
			weight = ((Bear) animal).getDiet().eat((Bear) animal, food);
		else if (animal instanceof Elephant)
			weight = ((Elephant) animal).getDiet().eat((Elephant) animal, food);	
		else if (animal instanceof Giraffe)
			weight = ((Giraffe) animal).getDiet().eat((Giraffe) animal, food);
		else if (animal instanceof Turtle)
			weight = ((Turtle) animal).getDiet().eat((Turtle) animal, food);
		if (weight > 0)
			return true;
		return false;
	}
	
	/**
	 * Calculation of the distance traveled by the animal.
	 * 
	 * @param animal
	 * 			Animal object
	 * @param point
	 * 			Point object
	 * 
	 * @return true or false
	 */
	public static boolean move(Object animal, Point point)
	{
		double distance = 0;
		if(point.checkBoundaries(point))
		{
			if (animal instanceof Lion)
			{
				distance = ((Lion) animal).calcDistance(point);
				((Lion) animal).addTotalDistance(distance);
				((Lion) animal).setLocation(point);
			}
				
			else if (animal instanceof Bear)
			{
				distance = ((Bear) animal).calcDistance(point);
				((Bear) animal).addTotalDistance(distance);
				((Bear) animal).setLocation(point);
			}
				
			else if (animal instanceof Elephant)
			{
				distance = ((Elephant) animal).calcDistance(point);
				((Elephant) animal).addTotalDistance(distance);
				((Elephant) animal).setLocation(point);
			}
					
			else if (animal instanceof Giraffe)
			{
				distance = ((Giraffe) animal).calcDistance(point);
				((Giraffe) animal).addTotalDistance(distance);
				((Giraffe) animal).setLocation(point);
			}
				
			else if (animal instanceof Turtle)
			{
				distance = ((Turtle) animal).calcDistance(point);
				((Turtle) animal).addTotalDistance(distance);
				((Turtle) animal).setLocation(point);
			}
		else return false;
		}
		if (distance > 0)
			return true;
		return false;
	}
	
	/**
	 * Helper function to initialize a Point object
	 *
	 * @return initialized Point object
	 */
	public static Point initPoint()
	{
		Scanner sc = new Scanner(System.in);
		int x,y;
		Point location;
		boolean flag = false;
		do {
			System.out.print("Please enter point:\nX:");
			x = sc.nextInt();
			System.out.print("Y:");
			y = sc.nextInt();
			location = new Point(x,y);
			flag = location.checkPoint();
		} while (!flag);
		return location;
	}
	
	/**
	 * Helper function to get animal weight input.
	 * 
	 * @return double parameter animal weight.
	 */
	public static double initWeight()
	{
		Scanner sc = new Scanner(System.in);
		double tempDouble;
		System.out.println("Please enter weight:");
		tempDouble = sc.nextDouble();
		return tempDouble;
	}
	
	public static void main(String[] args) {
		int size, option, tempInt;
		double tempDouble;
		String name, tempString;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("How many animals? (At least 3)");
			size = sc.nextInt();
			if (size < 3)
				System.out.println("Size must be at least 3!");
		} while (size < 3);
		Animal[] animals = new Animal[size];
		for (int i=0; i<size; i++)
		{
			System.out.println("Please choose an animal:\n1.Lion\n2.Bear\n3.Elephant\n4.Giraffe\n5.Turtle");
			option = sc.nextInt();
			switch (option) {
				case 1: // Lion
					System.out.println("Please enter name:");
					name = sc.next();
					animals[i] = new Lion(name, initPoint());
					animals[i].setWeight(initWeight());
					System.out.println("How many scars?");
					tempInt = sc.nextInt();
					((Lion) animals[i]).setScars(tempInt);
					break;
				case 2: // Bear
					System.out.println("Please enter name:");
					name = sc.next();
					animals[i] = new Bear(name, initPoint());
					animals[i].setWeight(initWeight());
					System.out.println("What is the color of the fur?");
					tempString = sc.next();
					((Bear) animals[i]).setFurColor(tempString);
					break;
				case 3: // Elephant
					System.out.println("Please enter name:");
					name = sc.next();
					animals[i] = new Elephant(name, initPoint());
					animals[i].setWeight(initWeight());
					System.out.println("What is the length of the trunk?");
					tempDouble = sc.nextDouble();
					((Elephant) animals[i]).settrunkLength(tempDouble);
					break;
				case 4: // Giraffe
					System.out.println("Please enter name:");
					name = sc.next();
					animals[i] = new Giraffe(name, initPoint());
					animals[i].setWeight(initWeight());
					System.out.println("What is the length of the neck?");
					tempDouble = sc.nextDouble();
					((Giraffe) animals[i]).setNeckLength(tempDouble);
					break;
				case 5: // Turtle
					System.out.println("Please enter name:");
					name = sc.next();
					animals[i] = new Turtle(name, initPoint());
					animals[i].setWeight(initWeight());
					System.out.println("How old is the turtle?");
					tempInt = sc.nextInt();
					((Turtle) animals[i]).setAge(tempInt);
					break;
				default:
					System.out.println("Invalid input, Please try again..");
					i--;
					break;
			}
		}
		/* for (int i=0 ; i<size; i++) // Show all animals data.
			System.out.println(animals[i].toString()); */
		for (int i=0 ; i<size; i++)
		{
			if(move(animals[i], initPoint()))
				System.out.println("The movement was successful");
			else System.out.println("Movement failed");
		}
		for (int i=0; i<size/2; i++)
		{
			Random rand = new Random();
			int res1, res2;
			do {
				res1 = rand.nextInt(size);
				res2 = rand.nextInt(size);
			} while (res1==res2);
			if (eat(animals[res1], animals[res2]))
				System.out.println(animals[res1].getName() + " eat " + animals[res2].getName());
			else System.out.println(animals[res1].getName() + " can't eat " + animals[res2].getName());
		}
		sc.close();
	}
}