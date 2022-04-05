package mobility;

/**
 * An abstract class that defines movement in space.
 *
 * @version 1.0 05 April 2022
 * @author	Ido Ben Nun, Bar Cohen
 * @see Point
 */
public abstract class Mobile implements Ilocatable {
	private Point location;
	private double totalDistance;

	/**
	 * Default ctor required for Mobile abstract class.
	 */
	public Mobile() { this.totalDistance = 0; }
	
	/**
	 * A simple ctor of Mobile Point location.
	 *
	 * @param location
	 * 			other Point object
	 */
	public Mobile(Point location) {
		this.totalDistance = 0;
		this.location = location;
	}
	
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
	public boolean setLocation(Point other) {
		this.location.setX(other.getX());
		this.location.setY(other.getY());
		return true;
	}
	
	/**
	 * A simple getter for Point object.
	 * 
	 * @return this Point object.
	 */
	public Point getLocation() {
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
		return Math.sqrt((Math.pow(location.getX()-other.getX(),2))+(Math.pow(location.getY()-other.getY(),2)));
	}
	
	/*
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