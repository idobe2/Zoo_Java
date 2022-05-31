package graphics;

import animals.Animal;

import java.util.ArrayList;

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
