package mobility;

/**
 * A class that uses 2D axis for location estimation.
 * 
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public class Point implements Ilocatable{
	private static final int MAX_X = 800, MAX_Y = 600, MIN_X = 0, MIN_Y = 0;
	private int x;
	private int y;
	private Point location;
	private double totalDistance;
	
	/**
	 * Default ctor for Point object.
	 */
	public Point()
	{
		super();
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
	 * Copy ctor of Point object.
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
			this.x = x;
			return true;
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
			this.y = y; 
			return true;
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
	public boolean setLocation(Point other) {
		if (other == null)
			return false;
		else this.location = new Point(other);
		return true;
	}

	/**
	 * A simple getter for Point object.
	 *
	 * @return this Point object.
	 */
	public synchronized Point getLocation() {
		return this.location;
	}

	/**
	 * A simple getter for total distance of an animal.
	 *
	 * @return double parameter total distance.
	 */
	public double getTotalDistance() { return this.totalDistance; }

	/**
	 * An easy function to add distance.
	 *
	 * @param distance
	 * 			(double)distance to be
	 * 			added to total distance.
	 */
	public void addTotalDistance (double distance){
		this.totalDistance += distance;
	}

	/**
	 * An easy function to calculate the distance traveled between the points.
	 *
	 * @param other
	 * 			Other Point object.
	 * @return The result of the calculation.
	 */
	public double calcDistance(Point other){
		return Math.sqrt((Math.pow(x-other.getX(),2))+(Math.pow(y-other.getY(),2)));
	}

	/**
	 * Function to update Point location and total distance.
	 *
	 * @param other
	 * 			Point object.
	 * @return the total distance.
	 */
	public double move(Point other){
		if(!other.checkPoint())
			return 0;
		this.totalDistance += calcDistance(other);
		this.location = other;
		return this.totalDistance;
	}
}
