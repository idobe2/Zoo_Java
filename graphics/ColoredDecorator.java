package graphics;

import animals.Animal;
import mobility.Mobile;
import utilities.MessageUtility;

/**
 * This is a decorator class.
 * We use it to apply a new color for animal
 * during runtime.
 *
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IAnimalDecorator
 */
public class ColoredDecorator implements IAnimalDecorator{

    Animal animal;

    /**
     * An easy ctor of ColoredDecorator object.
     * Only needs reference to animal object.
     * @param other
     */
    public ColoredDecorator(Animal other) {this.animal = other;}

    /**
     * This function is called whenever there is a request to change the animal color.
     * This is done by accessing the animal object and changing its color.
     * @param color (String) New color to be applied.
     * @return True, if succeeded.
     *          Otherwise, false.
     */
    public boolean changeColor(String color) {
        animal.loadImages(animal.getColorToFile(color));
        Animal other = animal;
        if (other.setColor(color)) {
            other.loadImages(other.getColorToFile(color));
            other.notifyObservers(" is turned " + color);
            return true;
        }
        return false;
    }
}
