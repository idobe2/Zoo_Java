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
import java.text.DecimalFormat;

/**
 * A class that contains the basic fields of an animal.
 * Required to create an animal-type object.
 * 
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public abstract class Animal extends Mobile implements IEdible ,IDrawable, IAnimalBehavior, Runnable {

	private static final int X_DIR_RIGHT = 1, X_DIR_LEFT = -1, Y_DIR_UP = 1, Y_DIR_DOWN = -1, MIN_SIZE = 50, MAX_SIZE = 300;
	private final int EAT_DISTANCE = 10;
	private int size;
	private String col;
	private int horSpeed;
	private int verSpeed;
	private boolean coordChanged = false;
	private int x_dir; //
	private int y_dir;
	private int eatCount;
	private ZooPanel pan;
	protected BufferedImage img1 = null, img2 = null;
	private String name;
	private double weight;
	private IDiet diet;

	protected Point location;

	protected Thread thread;
	protected boolean threadSuspended = false;

	public Thread getThread() { return thread; }
	public boolean setThread(Thread thread) { this.thread = thread; return true; }

	@Override
	public void run() {
		while(!threadSuspended)
		{
			if (getLocation().getX() >= getPan().getWidth() || getLocation().getX() <= 0)
			{
				if (getLocation().getX() == 0) getLocation().setX(1);
				if (x_dir == X_DIR_RIGHT) setX_dir(X_DIR_LEFT);
				else setX_dir(X_DIR_RIGHT);
			}
			else if (getLocation().getY() >= getPan().getHeight() || getLocation().getY() <= 0)
			{
				if (getLocation().getY() == 0) getLocation().setY(1);
				if (y_dir == Y_DIR_UP) setY_dir(Y_DIR_DOWN);
				else setY_dir(Y_DIR_UP);
			}
			setLocation(new Point(getLocation().getX()+horSpeed*x_dir,getLocation().getY()+verSpeed*y_dir));
			getPan().repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			/* empty */
		}
			getPan().manageZoo();
		}
	}

	public void setSuspended() { this.threadSuspended = true; }
	public void setResumed() { this.threadSuspended = false; }

	/**
	 * A Ctor of animal to be used with graphics package.
	 * @param size (Integer) Size of animal on the panel.
	 * @param horSpeed (Integer) Horizontal speed.
	 * @param verSpeed (Integer) Vertical speed.
	 * @param color (String) Color of animal image.
	 * @param weight (Double) Weight of animal.
	 */
	public Animal(int size, int horSpeed, int verSpeed, String color, double weight) {
		setSize(size);
		setWeight(weight);
		setHorSpeed(horSpeed);
		setVerSpeed(verSpeed);
		setColor(color);
		setX_dir(1); // Default
		setY_dir(1); // Default
	}

	/**
	 * A simple getter for color to file.
	 * @param color
	 * 			(String) Color.
	 * @return A string for file to be loaded.
	 */
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

	/**
	 * A getter for color string.
	 * @return (String) color.
	 */
	public String getColorToString() { return col; }

	/**
	 * A getter for color.
	 * @return (Color) color.
	 */
	public Color getColor() {
		if (col.equals("Natural")) return null;
		else if (col.equals("Red")) return Color.RED;
		else if (col.equals("Blue")) return Color.BLUE;
		return null;
	}

	/**
	 * A setter of horSpeed.
	 * @param horSpeed Horizontal speed (Integer).
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setHorSpeed(int horSpeed) {
		if (horSpeed < 0 || horSpeed > 10) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setHorSpeed", horSpeed, false);
			return false; }
		else this.horSpeed = horSpeed;
		MessageUtility.logSetter(getClass().getSimpleName(), "setHorSpeed", horSpeed, true);
		return true; }

	/**
	 * A setter of verSpeed.
	 * @param verSpeed Horizontal speed (Integer).
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setVerSpeed(int verSpeed) {
		if (verSpeed < 0 || verSpeed > 10) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setVerSpeed", verSpeed, false);
			return false; }
		else this.verSpeed = verSpeed;
		MessageUtility.logSetter(getClass().getSimpleName(), "setVerSpeed", verSpeed, true);
		return true; }

	/**
	 * A setter for x_dir.
	 * @param x_dir Y Direction (Integer).
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setX_dir(int x_dir) {
		if (x_dir != X_DIR_LEFT && x_dir != X_DIR_RIGHT) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setX_dir", x_dir, false);
			return false;
		}
		else this.x_dir = x_dir;
		MessageUtility.logSetter(getClass().getSimpleName(), "setX_dir", x_dir, true);
		return true; }

	/**
	 * A setter for y_dir.
	 * @param y_dir Y Direction (Integer).
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setY_dir(int y_dir) {
		if (y_dir != Y_DIR_DOWN && y_dir != Y_DIR_UP) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setY_dir", y_dir, false);
			return false;
		}
		else this.y_dir = y_dir;
		MessageUtility.logSetter(getClass().getSimpleName(), "setY_dir", y_dir, true);
		return true; }

	/**
	 * A setter for animal size.
	 * @param size
	 * 			size of animal on the panel (Integer).
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) return false;
		else this.size = size;
		return true; }

	/**
	 * A getter for animal name.
	 * Not relevant after HW1.
	 * @return (String) Name of animal.
	 */
	public String getAnimalName() {
		return this.name;
	}

	/**
	 * A setter for animal color.
	 * @param col
	 * 			Color of animal to use in panel.
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setColor(String col) {
		if (col.equals("Natural") || col.equals("Blue") || col.equals("Red")) {
			this.col = new String(col);
			return true; }
		return false;
	}

	/**
	 * A setter for animal using panel.
	 * @param pan - (ZooPanel) Panel for drawing animals.
	 * @return True if succeeded, otherwise false.
	 */
	public boolean setPan(ZooPanel pan) {
		this.pan = pan;
		return true;
	}

	/**
	 * A simple function to draw an animal on the panel.
	 * @param g
	 * 			Graphics of the panel.
	 */
	public void drawObject (Graphics g)
	{
		if(getX_dir()==1) // animal goes to the right side
			g.drawImage(img1, getLocation().getX()-size/2, getLocation().getY()-size/10, size/2, size, pan);
		else // animal goes to the left side
			g.drawImage(img2, getLocation().getX(), getLocation().getY()-size/10, size/2, size, pan);
	}

	/**
	 * A simple function to increase eatCount.
	 */
	public void eatInc() { this.eatCount++; }

	/**
	 * A getter for eatCount.
	 * @return eatCount.
	 */
	public int getEatCount() { return this.eatCount; }

	/**
	 * A getter for horSpeed.
	 * @return horSpeed.
	 */
	public int getHorSpeed() { return this.horSpeed; }

	/**
	 * A getter for verSpeed.
	 * @return verSpeed.
	 */
	public int getVerSpeed() { return this.verSpeed; }

	/**
	 * A getter for coordChanged.
	 * @return (Boolean) value of coordChanged.
	 */
	public boolean getChanges() { return this.coordChanged; }

	/**
	 * A setter of coordChanged.
	 * @param coordChanged
	 * 			(Boolean) value.
	 */
	public void setChanges(boolean coordChanged) {
		if (coordChanged)
			setX_dir(1);
		else setX_dir(-1);
	}

	/**
	 * A getter of X coordinate.
	 * @return (Integer) X coordinate.
	 */
	public int getX_dir() { return x_dir; }

	/**
	 * A getter of Y coordinate.
	 * @return (Integer) X coordinate.
	 */
	public int getY_dir() { return y_dir; }

	/**
	 * A getter of animal size on the panel.
	 * @return (Integer) animal size.
	 */
	public int getSize() { return this.size; }

	/**
	 * A getter of animal's panel.
	 * @return (ZooPanel) panel to be used.
	 */
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
		DecimalFormat df = new DecimalFormat("#.##");
		double wgt = diet.eat(this, food);
		if (wgt > 0)
		{
			setWeight(getWeight()+Double.valueOf(df.format(wgt)));
			return true;
		}
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
		MessageUtility.logGetter(getClass().getSimpleName(), "getDiet", diet.getClass().getSimpleName());
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
			MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, true);
			this.weight = weight;
			return true;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, false);
		return false;
	}

	/**
	 * Getter of animal weight.
	 * Using logGetter function to print doc message.
	 *
	 * @return animal weight.
	 */
	public double getWeight() {
		MessageUtility.logGetter(getClass().getSimpleName(), "getWeight", this.weight);
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
	public String getName() { return this.name; }

	/**
	 * toString function of animal class.
	 * Using template: [!] animalName: total distance: [distance], weight: [weight]
	 *
	 * @return string of the object values.
	 */
	public String toString() { return "[!] " + this.name + ": total distance: " + getTotalDistance() + ", weight: " + getWeight(); }

	/**
	 * A simple getter for EAT_DISTANCE.
	 * @return (Integer) EAT_DISTANCE.
	 */
	public int getEAT_DISTANCE() {
		return EAT_DISTANCE;
	}
}
