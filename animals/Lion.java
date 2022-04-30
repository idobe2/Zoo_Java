package animals;

import diet.Carnivore;
import graphics.IDrawable;
import mobility.Point;
import utilities.MessageUtility;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Lion class - Carnivore animal.
 * Not edible by other animals.
 * Each time a lion eats,
 * it can get one more scar.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Roar
 */
public class Lion extends Roar {
	
	private int scarCount;

	public Lion(int size, int horSpeed, int verSpeed, String color, double weight) {
		super(size, horSpeed, verSpeed, color, weight);
		this.scarCount = 0;
		this.setLocation(new Point(20,0));
		this.setDiet(new Carnivore());
		loadImages(getColorToFile(color));
		if (getPan() != null)
			drawObject(getPan().getGraphics());
	}

	/**
	 * A ctor of lion name and location.
	 * 
	 * @param name
	 * 			name string of the lion.
	 * @param location
	 * 			location point of the lion.
	 */
	public Lion(String name, Point location)
	{
		super(name, location);
		this.scarCount = 0;
		this.setWeight(408.2);
		this.setDiet(new Carnivore());
	}
	
	/**
	 * A ctor of lion name only.
	 * 
	 * @param name
	 * 			name string of the lion.
	 */
	public Lion(String name)
	{
		super(name);
		this.scarCount = 0;
		Point startLocation = new Point(20,0);
		this.setLocation(startLocation);
	}
	
	/**
	 * A Lion's scar counter setter,
	 * Gets only positive numbers as input.
	 * Using logSetter function to print doc message.
	 * 
	 * @param scars
	 * 			Integer number of scars to apply.
	 * @return true if the parameter given is positive,
	 * 			otherwise false.
	 */
	public boolean setScars(int scars) {
		if (scars > 0)
		{
			this.scarCount = scars;
			MessageUtility.logSetter(getName(), "setScars", scars, true);
			return true;
		}
		MessageUtility.logSetter(getName(), "setScars", scars, false);
		return false;
	}
	
	/**
	 * A getter for scar count.
	 * Using logGetter function to print doc message.
	 * 
	 * @return scar count.
	 */
	public int getScars() {
		MessageUtility.logGetter(getName(), "getScars", this.scarCount);
		return this.scarCount; } 
	
	/**
	 * A simple helper function of adding 1 to the scar count.
	 */
	public void addScar() { this.scarCount++; }
	
	/**
	 * roar function - for carnivore and omnivore animals.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Roars, then stretches and shakes its mane");
	}

	public void loadImages(String nm)
	{	// Read image file
		try {
			img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/lio_" + nm + "_1.png"));
			img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/lio_" + nm + "_2.png"));
		} catch (IOException ex) {System.out.println("Cannot load image");}
	}
}