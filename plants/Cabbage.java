package plants;

import food.EFoodType;
import graphics.IDrawable;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {

	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

}
