package mobility;

/**
 * A class that uses 2D axis for location estimation.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Mobile
 */
public class Point {
	private static final int MAX_X = 800;
	private static final int MAX_Y = 600;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
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
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;	
	}
	
	public Point(Point other)
	{
		if (checkBoundaries(other))
		{
			this.x = other.x;
			this.y = other.y;
		}
	}
	
	public int getX() {return this.x; }
	public int getY() {return this.y; }
	
	public boolean setX(int x) {
		if (x >=MIN_X && x <= MAX_X)
		{
			this.x = x; 
			return true; 
		}
		return false;
	}
	
	public boolean setY(int y) {
		if (y >= MIN_Y && y <= MAX_Y)
		{
			this.y = y; 
			return true; 
		}
		return false;
	}
	
	public static boolean checkBoundaries(Point other)
	{
		if (other.getX() >=0 && other.getX() <= 800)
		{
			if (other.getY() >=0 && other.getY() <= 600)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPoint()
	{
		if (getX() >=0 && getX() <= 800)
		{
			if (getY() >=0 && getY() <= 600)
			{
				return true;
			}
		}
		return false;
	}
}
