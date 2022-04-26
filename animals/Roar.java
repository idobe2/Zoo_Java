package animals;

import mobility.Point;

/**
 * A simple abstract class for carnivore and omnivore animals.
 * This class is created to use with makeSound function.
 * 
 * @version 1.0 04 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Chew
 */
public abstract class Roar extends Animal{

	public Roar(int size, int horSpeed, int verSpeed, String color, double weight)	{
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
	public Roar(String name, Point location)
	{
		super(name,location);
	}
	
	/**
	 * An easy ctor to init an animal object.
	 * 
	 * @param name
	 * 			String of animal name.
	 */
	public Roar(String name)
	{
		super(name);
	}
	
	/**
	 * An implemented makeSound function to call roar function of animal.
	 */
	public void makeSound()
	{
		roar();
	}
	
	/**
	 * Abstract function required for animals who use roar function.
	 */
	public abstract void roar();
}
