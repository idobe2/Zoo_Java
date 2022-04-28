package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Giraffe class - Herbivore animal.
 * The neck length of Giraffes can be 
 * between 1 and 2.5 meters.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Chew
 */
public class Giraffe extends Chew {
	private double neckLength;

	public Giraffe(int size, int horSpeed, int verSpeed, String color, double weight) {
		super(size, horSpeed, verSpeed, color, weight);
		this.neckLength = 1.5;
		this.setWeight(weight);
		setDiet(new Herbivore());
		if (getColor().equals("None"))
			loadImages("n");
		else if (getColor().equals("Blue"))
			loadImages("b");
		else if (getColor().equals("Red"))
			loadImages("r");
		if (getPan() != null)
			drawObject(getPan().getGraphics());
	}

	/**
	 * A ctor of giraffe name and location.
	 * 
	 * @param name
	 * 			name string of the giraffe.
	 * @param location
	 * 			location point of the giraffe.
	 */
	public Giraffe(String name, Point location)
	{
		super(name,location);
		this.neckLength = 1.5;
		setWeight(450);
		setDiet(new Herbivore());
	}
	
	/**
	 * A ctor of giraffe name only.
	 * 
	 * @param name
	 * 			name string of the giraffe.
	 */
	public Giraffe(String name) 
	{
		super(name);
		this.neckLength = 1.5;
		Point startLocation = new Point(50,0);
		this.setLocation(startLocation);
	}
	
	/**
	 * A Giraffe's neck length setter.
	 * Can be between 1 and 2.5 meters.
	 * Using logSetter function to print doc message.
	 * 
	 * @param neckLength
	 * 			parameter(double) of neck length.
	 * @return true if the parameter is valid,
	 * 			otherwise false.
	 */
	public boolean setNeckLength(double neckLength)
	{
		if (neckLength >= 1 && neckLength <= 2.5)
		{
			this.neckLength = neckLength;
			MessageUtility.logSetter(getName(), "setNeckLength", neckLength, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "setNeckLength", neckLength, false);
		return false;
	}
	
	/**
	 * A Giraffe's neck length getter.
	 * Using logGetter function to print doc message.
	 * 
	 * @return a value(double) between 1 and 2.5
	 */
	public double getNeckLength() { 
		MessageUtility.logGetter(getName(), "getNeckLength", this.neckLength);
		return this.neckLength; }
	
	/**
	 * chew function - for herbivore animals only.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void chew() {
		MessageUtility.logSound(this.getName(), "Bleats and Stomps its legs, then chews");
	}

	public void loadImages(String nm)
	{	// Read image filev
		try {
			img1 = ImageIO.read(new File("assignment2_pictures/grf_" + nm + "_1"));
			img2 = ImageIO.read(new File("assignment2_pictures/grf_"+ nm + "_2"));
		} catch (IOException ex) {System.out.println("Cannot load image");}
	}
}