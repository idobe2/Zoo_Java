package plants;

import food.EFoodType;
import utilities.MessageUtility;

public class Meat extends Plant {

    /**
     * An easy ctor for meat object.
     */
    public Meat() {
        MessageUtility.logConstractor("Meat", "Meat");
    }

    /**
     * A simple function to get meat food type.
     * @return EFoodType.MEAT
     */
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }
}
