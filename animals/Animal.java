package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that contains the basic fields of an animal.
 * Required to create an animal-type object.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public abstract class Animal extends Mobile implements IEdible ,IDrawable, IAnimalBehavior { //

	private final int EAT_DISTANCE = 10;
	private int size;

	public String getColor() { //TODO
		if (col == null) return "None";
		return col.toString();
	}

	public void setCol(Color col) {
		this.col = col;
	}

	public String getAnimalName() {
		return this.name;
	}

	public void eatInc() {
		this.eatCount++;
	}

	public int getEatCount() {
		return this.eatCount;
	}

	public boolean getChanges() { //TODO
		return false;
	}

	public void setChanges(boolean state) { //TODO
	}

	private Color col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged;
	private Thread thread;

	public int getX_dir() {
		return x_dir;
	}

	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}

	public int getY_dir() {
		return y_dir;
	}

	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}

	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan; // JPanel
	protected BufferedImage img1 = null, img2 = null;

	private String name;
	private double weight;
	private IDiet diet;

	public boolean setSize(int size)
	{
		this.size = size;
		return true;
	}

	public int getSize()
	{
		return this.size;
	}

	public boolean setPan(ZooPanel pan)
	{
		this.pan = pan;
		return true;
	}

	public ZooPanel getPan()
	{
		return this.pan;
	}

	public void drawObject (Graphics g)
	{
		g.setColor(col);
		if(getX_dir()==1) // giraffe goes to the right side
			g.drawImage(img1, getLocation().getX()-getSize()/2, getLocation().getY()-getSize()/10, getSize()/2, getSize(), getPan());
		else // giraffe goes to the left side
			g.drawImage(img2, getLocation().getX(), getLocation().getY()-getSize()/10, getSize()/2, getSize(), getPan());
	}

	public Animal(String name, int size, int horSpeed, int verSpeed, String color)	{
		//super(location);
		this.name = name;
		this.size = size;
		this.horSpeed = horSpeed;
		this.verSpeed = verSpeed;
		if (color.equals("Blue"))
			this.col = Color.BLUE;
		else if (color.equals("None"))
			this.col = null;
		else if (color.equals("Red"))
			this.col = Color.RED;
		//MessageUtility.logConstractor(getClass().getSimpleName(), getName());
	}

	/**	
	 * A ctor of animal name and location.
	 * Using logCtor function to print doc message.
	 * 
	 * @param name
	 * 			name string of the animal.
	 * @param location
	 * 			location point of the animal.
	 */
	public Animal(String name, Point location)	{
		super(location);
		this.name = name;
		MessageUtility.logConstractor(getClass().getSimpleName(), getName());
	}
	
	/**
	 * A ctor of animal name only.
	 * Using logCtor function to print doc message.
	 * 
	 * @param name
	 * 			name string of the animal.
	 */
	public Animal(String name) {
		super();
		this.name = name;
		MessageUtility.logConstractor(getClass().getSimpleName(), getName());
		}
	
	/**
	 * Abstract function required for Roar and Chew abstract classes.
	 */
	public abstract void makeSound();
	
	/**
	 * A simple function used to perform eating action.
	 * 
	 * @param food
	 * 			IEdible food-type.
	 * @return true or false.
	 */
	public boolean eat(IEdible food) {
		double wgt;
		wgt = diet.eat(this, food);
		if (wgt > 0)
			return true;
		return false;
	}
	
	/**
	 * Setter of animal diet class.
	 * 
	 * @param diet
	 * 			diet class.
	 * @return true.
	 */
	public boolean setDiet(IDiet diet)
	{
		this.diet = diet;
		MessageUtility.logSetter(getName(), "setDiet", diet.getClass().getSimpleName(), true);
		return true;
	}
	
	/**
	 * Getter of animal diet class.
	 * 
	 * @return object of diet class.
	 */
	public IDiet getDiet()
	{
		MessageUtility.logGetter(getName(), "getDiet", diet.getClass().getSimpleName());
		return this.diet;
	}
	
	/**
	 * Setter of animal weight.
	 * Using logSetter function to print doc message.
	 * 
	 * @param weight
	 * 			animal weight.
	 * @return true if weight is positive, otherwise false.
	 */
	public boolean setWeight(double weight) 
	{ 
		if (weight > 0)
		{
			MessageUtility.logSetter(getName(), "setWeight", weight, true);
			this.weight = weight; 
			return true; 
		}
		MessageUtility.logSetter(getName(), "setWeight", weight, false);
		return false;
	}
	
	/**
	 * Getter of animal weight.
	 * Using logGetter function to print doc message.
	 * 
	 * @return animal weight.
	 */
	public double getWeight() { 
		MessageUtility.logGetter(getName(), "getWeight", this.weight);
		return this.weight; }
	
	/**
	 * A simple getter of animal food type.
	 * Using logGetter function to print doc message.
	 * 
	 * @return EFoodType of this animal.
	 */
	public EFoodType getFoodtype()
	{
		if (this instanceof Lion) {
			MessageUtility.logGetter(getName(), "getFoodtype", EFoodType.NOTFOOD);
			return EFoodType.NOTFOOD; }
		MessageUtility.logGetter(getName(), "getFoodtype", EFoodType.MEAT);
		return EFoodType.MEAT;
	}
	
	/**
	 * Getter of animal name.
	 * We use this getter inside the class.
	 * 
	 * @return animal name.
	 */
	public String getName() {
		// No need to print that according to the output file.
		//MessageUtility.logGetter(name, "getName", name);
		return this.name; }
	
	/**
	 * toString function of animal class.
	 * Using template: [!] animalName: total distance: [distance], weight: [weight]
	 * 
	 * @return string of the object values.
	 */
	public String toString() { return "[!] " + this.name + ": total distance: " + getTotalDistance() + ", weight: " + getWeight(); }
}
