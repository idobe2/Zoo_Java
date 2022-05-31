package graphics;

import animals.Animal;

public class ColoredDecorator implements IAnimalDecorator{

    private IAnimalDecorator animalDecorator;
    Animal animal;

    public ColoredDecorator(Animal other) {this.animal = other;}

    public boolean changeColor(String color) {
        animal.loadImages(animal.getColorToFile(color));
        Animal other = animal;
        other.setColor(color);
        other.loadImages(other.getColorToFile(color));
        return true;
    }
}
