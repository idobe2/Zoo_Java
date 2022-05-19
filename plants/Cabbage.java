package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {

	/**
	 * An easy ctor of cabbage object.
	 */
	public Cabbage() { MessageUtility.logConstractor("Cabbage", "Cabbage"); }

	public Cabbage(Point location) {super(location);}

	/**
	 * A simple function to get cabbage food type.
	 * @return EFoodType.VEGETABLE
	 */
	public EFoodType getFoodtype() { return EFoodType.VEGETABLE; }
}
