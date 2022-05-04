package plants;

import food.EFoodType;
import graphics.IDrawable;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant {
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	public EFoodType getFoodtype() {
		MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
		return EFoodType.VEGETABLE;
	}
	public Image getImg() { return this.img; }
}
