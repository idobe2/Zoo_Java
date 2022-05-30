package plants;

import food.EFoodType;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {

	private static Cabbage cabbage = null;

	public static synchronized Cabbage getInstance()
	{
		if (cabbage==null)
			cabbage = new Cabbage();
		return cabbage;
	}

	/**
	 * An easy ctor of cabbage object.
	 */
	private Cabbage() { MessageUtility.logConstractor("Cabbage", "Cabbage"); }

	/**
	 * A simple function to get cabbage food type.
	 * @return EFoodType.VEGETABLE
	 */
	public EFoodType getFoodType() { return EFoodType.VEGETABLE; }
}
