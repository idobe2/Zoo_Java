package plants;

import food.EFoodType;
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

	/**
	 * A simple function to get cabbage food type.
	 * @return EFoodType.VEGETABLE
	 */
	public EFoodType getFoodType() { return EFoodType.VEGETABLE; }
}
