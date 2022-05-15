package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;

/**
 * @author baroh
 *
 */
public abstract class Plant implements IEdible, Ilocatable ,IDrawable {

	protected BufferedImage img = null;
	private ZooPanel pan;

	/**
	 * 
	 */
	private double height;
	/**
	 * 
	 */
	private Point location;
	/**
	 * 
	 */
	private double weight;

	/**
	 * 
	 */
	public Plant() {
		Random rand = new Random();
		int x = rand.nextInt(30);
		int y = rand.nextInt(12);
		this.location = new Point(x, y);
		this.height = rand.nextInt(30);
		this.weight = rand.nextInt(12);
		MessageUtility.logConstractor("Plant", "Plant");
	}

	public Plant(Point location) {this.location = new Point(location); }

	public void loadImages(String nm) {    // Read image file
		switch (nm) {
			case "Lettuce":
				try {
					img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/lettuce.png"));
				} catch (IOException ex) {
					System.out.println("Cannot load lettuce");
				}
				break;
			case "Cabbage":
				try {
					img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/cabbage.png"));
				} catch (IOException ex) {
					System.out.println("Cannot load image");
				}
				break;
			case "Meat":
				try {
					img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/meat.gif"));
				} catch (IOException ex) {
					System.out.println("Cannot load image");
				}
				break;
			default:
				break;
		}
	}

	public boolean setPan(ZooPanel pan) {
		this.pan = pan;
		return true;
	}

	public ZooPanel getPan() { return this.pan; }

	public void drawObject (Graphics g) { g.drawImage(img, getLocation().getX(), getLocation().getY(), 50, 50, pan); }

	public Color getColor() { return Color.GREEN; }

	/**
	 * @return
	 */
	public double getHeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
		return this.height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#getLocation()
	 */
	@Override
	public Point getLocation() {
		if (this.location != null)
			return this.location;
		else return new Point(getPan().getWidth()/2,getPan().getHeight()/2);
	}

	/**
	 * @return
	 */
	public double getWeight() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
		return weight;
	}

	/**
	 * @param height
	 * @return
	 */
	public boolean setHeight(double height) {

		boolean isSuccess = (height >= 0);
		if (isSuccess) {
			this.height = height;
		} else {
			this.height = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	@Override
	public boolean setLocation(Point newLocation) {
		boolean isSuccess = Point.checkBoundaries(newLocation);
		if (isSuccess) {
			MessageUtility.logSetter(getClass().getSimpleName(), "setLocation", new String(newLocation.getX() + "," + newLocation.getY()), true);
			this.location = newLocation;
			return true;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", new String(newLocation.getX() + "," + newLocation.getY()), false);
		return false;
	}

	/**
	 * @param weight
	 * @return
	 */
	public boolean setWeight(double weight) {
		boolean isSuccess = (weight >= 0);
		if (isSuccess) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
		MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

		return isSuccess;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "] ";
	}
}
