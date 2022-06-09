package graphics;

import animals.Animal;
import java.util.ArrayList;

/**
 * This is an abstract factory class.
 * We use it to create another layer of abstraction for animals type.
 * Implementing IAbstractFactory.
 *
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IAnimalDecorator
 */
public class AnimalFactory implements IAbstractFactory {

    @Override
    public void addCarnivore(ZooPanel zooPanel, ArrayList<Animal> Animals) {
        String[] animalsType = {"Lion"};
        new AddAnimalDialog(Animals,zooPanel, animalsType);
    }

    @Override
    public void addOmnivore(ZooPanel zooPanel, ArrayList<Animal> Animals) {
        String[] animalsType = {"Bear"};
        new AddAnimalDialog(Animals,zooPanel, animalsType);
    }

    @Override
    public void addHerbivore(ZooPanel zooPanel, ArrayList<Animal> Animals) {
        String[] animalsType = {"Elephant", "Giraffe", "Turtle"};
        new AddAnimalDialog(Animals,zooPanel, animalsType);
    }
}
