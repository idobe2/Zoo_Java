package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {

	/**
	 * An easy ctor of lettuce object.
	 */
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	/**
	 * A simple function to get lettuce food type.
	 * @return EFoodType.VEGETABLE
	 */
	public EFoodType getFoodType() {
		return EFoodType.VEGETABLE;
	}
}
