package animals;

import diet.Omnivore;
import graphics.IDrawable;
import mobility.Point;
import utilities.MessageUtility;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Bear class - Omnivore animal.
 * The fur color of bears can be 
 * only black, gray or white.
 * 
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Roar
 */
public class Bear extends Roar {

	private String furColor;

	/**
	 * A Ctor of bear to be used with graphics package.
	 * @param size (Integer) Size of bear on the panel.
	 * @param horSpeed (Integer) Horizontal speed.
	 * @param verSpeed (Integer) Vertical speed.
	 * @param color (String) Color of bear.
	 * @param weight (Double) Weight of bear.
	 */
	public Bear(int size, int horSpeed, int verSpeed, String color, double weight) {
		super(size, horSpeed, verSpeed, color, weight);
		this.furColor = "GRAY";
		this.setLocation(new Point(100,5));
		this.setDiet(new Omnivore());
		loadImages(getColorToFile(color));
		if (getPan() != null)
			drawObject(getPan().getGraphics());
	}

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
		this.furColor = "GRAY";
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
		this.furColor = "GRAY";
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
			this.furColor = furColor;
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
	 * roar function - of carnivore and omnivore animals.
	 * This function will be used after the animal eat,
	 * or by calling makeSound function.
	 * Using logSound function to print doc message.
	 */
	public void roar()
	{
		MessageUtility.logSound(this.getClass().getSimpleName(), "Stands on its hind legs, roars and scratches its belly");
	}

	/**
	 * A simple function to read/load image file of this animal object.
	 * @param nm
	 * 			(String) part-of-string of file name.
	 */
	public void loadImages(String nm)
	{	// Read image file
		try {
			img1 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/bea_" + nm + "_1.png"));
			img2 = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/bea_"+ nm + "_2.png"));
		} catch (IOException ex) {System.out.println("Cannot load image");}
	}
}