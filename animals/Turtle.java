package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 * Turtle class - Herbivore animal.
 * Age of turtle can be 
 * at least 500 years.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Chew
 */
public class Turtle extends Chew {
	
	private int Age;
	
	/**
	 * A ctor of turtle name and location.
	 * 
	 * @param name
	 * 			name string of the turtle.
	 * @param location
	 * 			location point of the turtle.
	 */
	public Turtle(String name, Point location)
	{
		super(name,location);
		this.Age = 1;
		this.setWeight(1);
		this.setDiet(new Herbivore());
	}
	
	/**
	 * A ctor of turtle name only.
	 * 
	 * @param name
	 * 			name string of the turtle.
	 */
	public Turtle(String name)
	{
		super(name);
		this.Age = 1;
		Point startLocation = new Point(80,0);
		this.setLocation(startLocation);
	}
	
	/**
	 * A setter of turtle's age.
	 * An age of a turtle can be
	 * between 0 and 500 years.
	 * Using logSetter function to print doc message.
	 * 
	 * @param age
	 * 			Integer value of turtle's age.
	 * @return true if the parameter is valid,
	 * 			otherwise false.
	 */
	public boolean setAge(int age)
	{
		if (age >= 0 && age <= 500)
		{
			this.Age = age;
			MessageUtility.logSetter(getName(), "setAge", age, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "setAge", age, false);
		return false;
	}
	
	/**
	 * A getter of turtle's age.
	 * Using logGetter function to print doc message.
	 * 
	 * @return a value(integer) between 0 and 500
	 */
	public int getAge() {
		MessageUtility.logGetter(getName(), "getAge", this.Age);
		return this.Age; }
	
	/**
	 * roar function - for herbivore animals only.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void chew() {
		MessageUtility.logSound(this.getName(), "Retracts its head in then eats quietly");
	}
}
