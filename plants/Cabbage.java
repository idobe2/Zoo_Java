package plants;

import food.EFoodType;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {

	/**
	 * A simple function to get cabbage food type.
	 * @return EFoodType.VEGETABLE
	 */
	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}

	/**
	 * An easy ctor of cabbage object.
	 */
	public Cabbage() { MessageUtility.logConstractor("Cabbage", "Cabbage"); }

}
