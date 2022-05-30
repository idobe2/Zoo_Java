package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Meat extends Plant {
    private static Meat meat = null;

    public static synchronized Meat getInstance()
    {
        if (meat==null)
            meat = new Meat();
        return meat;
    }

    /**
     * An easy ctor of meat object.
     */
    private Meat() {
        MessageUtility.logConstractor("Meat", "Meat");
    }

    /**
     * A simple function to get meat food type.
     * @return EFoodType.MEAT
     */
    public EFoodType getFoodType() { return EFoodType.MEAT; }
}
