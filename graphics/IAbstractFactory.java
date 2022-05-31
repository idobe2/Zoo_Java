package graphics;

import animals.Animal;

import java.util.ArrayList;

public interface IAbstractFactory {

void addCarnivore(ZooPanel zooPanel, ArrayList<Animal> Animals);

void addOmnivore(ZooPanel zooPanel, ArrayList<Animal> Animals);

void addHerbivore(ZooPanel zooPanel, ArrayList<Animal> Animals);
}
