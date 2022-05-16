package mobility;

import utilities.MessageUtility;

/**
 * A class that uses 2D axis for location estimation.
 * 
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public class Point {
	private static final int MAX_X = 800, MAX_Y = 600, MIN_X = 0, MIN_Y = 0;
	private int x;
	private int y;
	
	/**
	 * Default ctor for Point object.
	 */
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Ctor for X and Y values.
	 *
	 * @param x
	 * 			integer value.
	 * @param y
	 * 			integer value.
	 */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;	
	}

	/**
	 * Copy ctor for Point object.
	 * Use checkBoundaries function
	 * for testing the point.
	 *
	 * @param other other Point object.
	 */
	public Point(Point other)
	{
		if (checkBoundaries(other))
		{
			this.x = other.getX();
			this.y = other.getY();
		}
	}

	/**
	 * A simple getter of X value.
	 *
	 * @return the X value as an integer.
	 */
	public int getX() { return this.x; }

	/**
	 * A simple getter of Y value.
	 *
	 * @return the Y value as an integer.
	 */
	public int getY() {return this.y; }

	/**
	 * A simple setter of X value.
	 * Performs a test of the value before update.
	 *
	 * @param x
	 * 			integer value.
	 * @return true if the value is valid
	 * 			and update X field, otherwise false.
	 */
	public boolean setX(int x) {
//		if (x >=MIN_X && x <= MAX_X)
//		{
			this.x = x;
			return true; 
//		}
//		return false;
	}

	/**
	 * A simple setter of Y value.
	 * Performs a test of the value before update.
	 *
	 * @param y
	 * 			integer value.
	 * @return true if the value is valid
	 * 			and update Y field, otherwise false.
	 */
	public boolean setY(int y) {
//		if (y >= MIN_Y && y <= MAX_Y)
//		{
			this.y = y; 
			return true;
//		}
//		return false;
	}

	/**
	 * A boolean function to check if the Point object is valid.
	 *
	 * @param other
	 * 			other Point object.
	 * @return true if the Point object is valid,
	 * 			otherwise false.
	 */
	public static boolean checkBoundaries(Point other)
	{
		if (other.getX() >=MIN_X && other.getX() <= MAX_X)
			if (other.getY() >=MIN_Y && other.getY() <= MAX_Y)
				return true;
		return false;
	}

	/**
	 * A boolean function to check if this Point object is valid.
	 *
	 * @return true if this Point object is valid,
	 * 			otherwise false.
	 */
	public boolean checkPoint()
	{
		if (getX() >=MIN_X && getX() <= MAX_X)
			if (getY() >=MIN_Y && getY() <= MAX_Y)
				return true;
		return false;
	}
}
