package plants;

import food.EFoodType;
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
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}
}
