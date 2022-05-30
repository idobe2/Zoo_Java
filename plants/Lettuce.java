package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {

	private static Lettuce lettuce = null;

	public static synchronized Lettuce getInstance()
	{
		if (lettuce==null)
			lettuce = new Lettuce();
		return lettuce;
	}

	/**
	 * An easy ctor of lettuce object.
	 */
	private Lettuce() {
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
