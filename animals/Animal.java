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

import javax.swing.*;
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
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged = false;
	private int x_dir;
	private int y_dir;
	private int eatCount;
	private ZooPanel pan; // JPanel
	protected BufferedImage img1 = null, img2 = null;
	private String name;
	private double weight;
	private IDiet diet;
	//private Point location; // Animal is extending Mobile, so it has location already.

	public boolean ChangeCoored() {
		if (!coordChanged) return true;
		else return false;
	}

	public Animal(int size, int horSpeed, int verSpeed, String color, double weight) {
		//super(location);
		//this.name = name;
		this.size = size;
		this.weight = weight;
		setHorSpeed(horSpeed);
		setVerSpeed(verSpeed);
		setColor(color);

		//setPan(new ZooPanel());
		//drawObject(getPan().getGraphics());
		//MessageUtility.logConstractor(getClass().getSimpleName(), getName());
	}

	public String getColorToFile(String color) {
		switch (color) {
			case "Natural":
				return "n";
			case "Blue":
				return "b";
			case "Red":
				return "r";
			default:
				return null;
		}
	}

	public String getColorToString() { return col; }

	public Color getColor() {
		if (col.equals("Natural")) return null;
		else if (col.equals("Red")) return Color.RED;
		else if (col.equals("Blue")) return Color.BLUE;
		return null;
	}

	public boolean setHorSpeed(int horSpeed) {
		if (horSpeed < 0 || horSpeed > 10) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setHorSpeed", horSpeed, false);
			return false; }
		else this.horSpeed = horSpeed;
		MessageUtility.logSetter(getClass().getSimpleName(), "setHorSpeed", horSpeed, true);
		return true; }

	public boolean setVerSpeed(int verSpeed) {
		if (verSpeed < 0 || verSpeed > 10) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setVerSpeed", verSpeed, false);
			return false; }
		else this.verSpeed = verSpeed;
		MessageUtility.logSetter(getClass().getSimpleName(), "setVerSpeed", verSpeed, true);
		return true; }

	public boolean setX_dir(int x_dir) {
		if (x_dir < 0 || x_dir > 800) return false;
		else this.x_dir = x_dir;
		return true; }

	public boolean setY_dir(int y_dir) {
		if (y_dir < 0 || y_dir > 600) return false;
		else this.y_dir = y_dir;
		return true; }

	public boolean setSize(int size) {
		if (size < 50 || size > 300) return false;
		else this.size = size;
		return true; }

	public String getAnimalName() {
		return this.name;
	}

	public boolean setColor(String col) {
		if (col.equals("Natural") || col.equals("Blue") || col.equals("Red")) {
			this.col = new String(col);
			return true; }
		return false;
	}

	public boolean setPan(ZooPanel pan) {
		//if (pan == null) return false;
		this.pan = pan;
		return true; }

	public void drawObject (Graphics g)
	{
		//g.setColor(getColor());
		if(getX_dir()==1) // giraffe goes to the right side
			g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size/2, size, pan);
		else // giraffe goes to the left side
			g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size/2, size, pan);
	}

	public Image getImg() { return this.img1; }

	public void eatInc() { this.eatCount++; }

	public int getEatCount() { return this.eatCount; }

	public int getHorSpeed() { return this.horSpeed; }

	public int getVerSpeed() { return this.verSpeed; }

	public boolean getChanges() { return false; } //TODO

	public void setChanges(boolean state) { } //TODO

	public int getX_dir() { return x_dir; }

	public int getY_dir() { return y_dir; }

	public int getSize() { return this.size; }

	public ZooPanel getPan() { return this.pan; }

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
		MessageUtility.logSetter(getClass().getSimpleName(), "setDiet", diet.getClass().getSimpleName(), true);
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
		//MessageUtility.logGetter(getName(), "getWeight", this.weight);
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
