package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 * Elephant class - Herbivore animal.
 * The trunk length of elephants can be 
 * between 0.5 and 3 meters.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Chew
 */
public class Elephant extends Chew {
	
	private double trunkLength;
	
	/**
	 * A ctor of elephant name and location.
	 * 
	 * @param name
	 * 			name string of the elephant.
	 * @param location
	 * 			location point of the elephant.
	 */
	public Elephant(String name, Point location)
	{
		super(name, location);
		this.trunkLength = 1;
		this.setWeight(500);
		this.setDiet(new Herbivore());
	}
	
	/**
	 * A ctor of elephant name only.
	 * 
	 * @param name
	 * 			name string of the elephant.
	 */
	public Elephant(String name)
	{
		super(name);
		this.trunkLength = 1;
		Point startLocation = new Point(50,90);
		this.setLocation(startLocation);
	}
	
	/**
	 * An Elephant's trunk length setter,
	 * Can be between 0.5 and 3 meters.
	 * Using logSetter function to print doc message.
	 * 
	 * @param trunkLength
	 * 			parameter(double) of trunk length.
	 * @return true if the parameter is valid,
	 * 			otherwise false.
	 */
	public boolean settrunkLength(double trunkLength)
	{
		if (trunkLength >= 0.5 && trunkLength <= 3)
		{
			this.trunkLength = trunkLength;
			MessageUtility.logSetter(getName(), "settrunkLength", trunkLength, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "settrunkLength", trunkLength, false);
		return false;
	}
	
	/**
	 * An Elephant's trunk length getter.
	 * Using logGetter function to print doc message.
	 * 
	 * @return a value(double) between 0.5 and 3
	 */
	public double gettrunkLength() { 
		MessageUtility.logGetter(getName(), "gettrunkLength", this.trunkLength);
		return this.trunkLength; }
	
	/**
	 * chew function - for herbivore animals only.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void chew()
	{
		MessageUtility.logSound(this.getName(), "Trumpets with joy while flapping its ears, then chews");
	}

}