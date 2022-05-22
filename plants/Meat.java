package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Meat extends Plant {

    /**
     * An easy ctor of meat object.
     */
    public Meat() {
        MessageUtility.logConstractor("Meat", "Meat");
    }

    /**
     * A simple function to get meat food type.
     * @return EFoodType.MEAT
     */
    public EFoodType getFoodtype() { return EFoodType.MEAT; }
}
