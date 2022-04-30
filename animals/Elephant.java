package animals;

import diet.Herbivore;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

	public Elephant(int size, int horSpeed, int verSpeed, String color, double weight) {
		super(size, horSpeed, verSpeed, color, weight);
		this.trunkLength = 1;
		this.setLocation(new Point(50,90));
		this.setDiet(new Herbivore());
		if (color.equals("Natural"))
			loadImages("n");
		else if (color.equals("Blue"))
			loadImages("b");
		else if (color.equals("Red"))
			loadImages("r");
//		JPanel panel = new JPanel();
//		drawObject(panel.getGraphics());
//		setPan(panel);
		if (getPan() != null)
			drawObject(getPan().getGraphics());
	}

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

	public void loadImages(String nm)
	{	// Read image file
		try {
			img1 = ImageIO.read(new File("assignment2_pictures/elf_" + nm + "_1"));
			img2 = ImageIO.read(new File("assignment2_pictures/elf_"+ nm + "_2"));
		} catch (IOException ex) {System.out.println("Cannot load image");}
	}
}
