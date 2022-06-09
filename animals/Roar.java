package animals;

import mobility.Point;

/**
 * A simple abstract class of carnivore and omnivore animals.
 * This class is created to use with makeSound function.
 * 
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Chew
 */
public abstract class Roar extends Animal{

	/**
	 * A Ctor of animal to be used with graphics package.
	 * @param size (Integer) Size of animal on the panel.
	 * @param horSpeed (Integer) Horizontal speed.
	 * @param verSpeed (Integer) Vertical speed.
	 * @param color (String) Color of animal image.
	 * @param weight (Double) Weight of animal.
	 */
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
		notifyObservers(" ate");
	}
	
	/**
	 * Abstract function required for animals who use roar function.
	 */
	public abstract void roar();
}
