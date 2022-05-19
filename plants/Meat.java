package plants;

import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Meat extends Plant {

    /**
     * An easy ctor for meat object.
     */
    public Meat() {
        MessageUtility.logConstractor("Meat", "Meat");
    }

    public Meat(Point location) {super(location);}
    /**
     * A simple function to get meat food type.
     * @return EFoodType.MEAT
     */
    public EFoodType getFoodtype() { return EFoodType.MEAT; }
}
