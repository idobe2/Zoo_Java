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

    public void loadImages(String nm) {    // Read image file
        try {
            img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "/meat.gif"));
        } catch (IOException ex) {
            System.out.println("Cannot load image");
        }
    }

    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

}
