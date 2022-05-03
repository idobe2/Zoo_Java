package plants;

import food.EFoodType;
import graphics.IDrawable;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Meat extends Plant {
    public Meat() {
        MessageUtility.logConstractor("Meat", "Meat");
    }



    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

}
