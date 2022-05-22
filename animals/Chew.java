package animals;

import mobility.Point;

/**
 * A simple abstract class of herbivore animals.
 * This class is created to use with makeSound function.
 * 
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Roar
 */
public abstract class Chew extends Animal{

	public Chew(int size, int horSpeed, int verSpeed, String color, double weight) {
		super(size, horSpeed, verSpeed, color, weight);
	}

	/**
	 * An easy ctor to init an animal object.
	 * 
	 * @param name
	 * 			String of animal name.
	 * @param location
	 * 			Point object of animal.
	 */
	public Chew(String name, Point location)
	{
		super(name,location);
	}
	
	/**
	 * An easy ctor to init an animal object.
	 * 
	 * @param name
	 * 			String of animal name.
	 */
	public Chew(String name)
	{
		super(name);
	}
	
	/**
	 * An implemented makeSound function to call chew function of animal.
	 */
	public abstract void chew();
	
	/**
	 * Abstract function required for animals who use chew function.
	 */
	public void makeSound()
	{
		chew();
	}

}
