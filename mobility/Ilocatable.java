package mobility;

/**
 * An easy interface that describes location functionality.
 * We use it to get and set location of the animals.
 * 
 * @version 1.0 04 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public interface Ilocatable {
	
	/**
	 * A simple getter for Point object.
	 * 
	 * @return this Point object.
	 */
	public Point getLocation();
	
	/**
	 * A simple setter for Point object.
	 * Perform set of X and Y values.
	 * 
	 * @param other
	 * 			The Point object to be copied.
	 * @return true if the copy succeed
	 * 			and the values valid,
	 * 			otherwise false.
	 */
	public boolean setLocation(Point other);
}
