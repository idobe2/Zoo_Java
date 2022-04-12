package animals;

import diet.Omnivore;
import mobility.Point;
import utilities.MessageUtility;

/**
 * Bear class - Omnivore animal.
 * The fur color of bears can be 
 * only black, gray or white.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Roar
 */
public class Bear extends Roar {
	
	private String furColor;
	
	/**
	 * A ctor of bear name and location.
	 * 
	 * @param name
	 * 			name string of the bear.
	 * @param location
	 * 			location point of the bear.
	 */
	public Bear(String name, Point location)
	{
		super(name, location);
		this.furColor = new String("GRAY");
		this.setWeight(308.2);
		this.setDiet(new Omnivore());
	}
	
	/**
	 * A ctor of bear name only.
	 * 
	 * @param name
	 * 			name string of the bear.
	 */
	public Bear(String name)
	{
		super(name);
		this.furColor = new String("GRAY");
		Point startLocation = new Point(100,5);
		this.setLocation(startLocation);
	}
	
	/**
	 * A Bear's fur color setter,
	 * The following options are available:
	 * {"BLACK", "WHITE", "GRAY"}
	 * Using logSetter function to print doc message.
	 * 
	 * @param furColor
	 * 			The color of the bear's fur
	 * @return true if the color is reasonable,
	 * 			otherwise false.
	 */
	public boolean setFurColor(String furColor)
	{
		furColor = furColor.toUpperCase();
		if (furColor.equals("BLACK") || furColor.equals("WHITE") || furColor.equals("GRAY"))
		{
			this.furColor = new String(furColor);
			MessageUtility.logSetter(getName(), "setFurColor", furColor, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "setFurColor", furColor, false);
		return false;
	}
	
	/**
	 * A Bear's fur color getter.
	 * Using logGetter function to print doc message.
	 * 
	 * @return one of the following strings:
	 * 			{"BLACK", "WHITE", "GRAY"}
	 */
	public String getFurColor() { 
		MessageUtility.logGetter(getName(), "getFurColor", furColor);
		return this.furColor; }
	
	/**
	 * roar function - for carnivore and omnivore animals.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Stands on its hind legs, roars and scratches its belly");
	}
	

}