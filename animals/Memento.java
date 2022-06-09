package animals;

import mobility.Point;
import plants.Plant;

import java.awt.image.BufferedImage;

public class Memento {

    private double weight;
    private String col;
    private int eatCount, size, horSpeed, verSpeed, x_dir, y_dir;
    private Point location;
    private Animal animal;
//    private Plant food;

    public Memento(Animal other)
    {
        this.animal = other;
        this.size = other.getSize();
        this.weight = other.getWeight();
        this.horSpeed = other.getHorSpeed();
        this.verSpeed = other.getVerSpeed();
        this.col = other.getColorToFile(other.getColorToString()); // col = nm
        this.x_dir = other.getX_dir();
        this.y_dir = other.getY_dir();
        this.location = other.getLocation();
        this.eatCount = other.getEatCount();
    }

    public Animal getAnimal() { return this.animal; }
    public int getSize() {
        return size;
    }
    public double getWeight() {
        return weight;
    }
    public String getColor() {
        return col;
    }
    public int getHorSpeed() {
        return horSpeed;
    }
    public int getVerSpeed() {
        return verSpeed;
    }
    public int getX_dir() {
        return x_dir;
    }
    public int getY_dir() {
        return y_dir;
    }
    public Point getLocation() {
        return location;
    }
    public int getEatCount() {
        return eatCount;
    }
}

