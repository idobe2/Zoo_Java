package graphics;

import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import plants.Meat;
import plants.Plant;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    protected ArrayList<Animal> animals = new ArrayList<>();
    protected Plant foodType;
    BufferedImage backgroundImage = null;

    public ZooPanel(ArrayList<Animal> animalArrayList, Plant food) {
        animals = animalArrayList;
        foodType = food;
        try {   // Read image file
            backgroundImage = ImageIO.read(new File("assignment2_pictures/savanna.jpg"));
        } catch (IOException ex) {
            System.out.println("Cannot load image");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!animals.isEmpty()) {
            for (int i = 0; i < animals.size(); i++) {
                animals.get(i).drawObject(g);
            }
        }
        if (foodType != null) {
            foodType.drawObject(g);
        }
    }

    public void manageZoo() {
        for (int i = 0; i < this.animals.size(); i++) {
            if (foodType != null) {
                if (Math.abs(animals.get(i).getLocation().getX() - 450) <= 10
                        && Math.abs(animals.get(i).getLocation().getY() - 150) <= 10)
                {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    this.repaint();
                } else if (animals.get(i).getDiet() instanceof Carnivore && this.foodType instanceof Meat) {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    this.repaint();
                } else if (animals.get(i).getDiet() instanceof Omnivore) {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    this.repaint();
                }
            }
        }
        for (int i = 0; i < this.animals.size(); i++)
            for (int j = 0; j < this.animals.size(); j++) {
                if (i != j) {
                    if (animals.get(i).getDiet() instanceof Carnivore || animals.get(i).getDiet() instanceof Omnivore) {
                        if (((animals.get(j).getDiet() instanceof Herbivore) || (animals.get(j).getDiet() instanceof Omnivore))) {
                            if (animals.get(i).getWeight() >= 2 * animals.get(j).getWeight()) {
                                if (animals.get(i).calcDistance(animals.get(j).getLocation()) < animals.get(j).getSize()) {
                                    this.animals.get(i).eat(this.animals.get(j));
                                    this.animals.get(i).eatInc();
                                    animals.remove(j);
                                    this.repaint();
                                }
                            }
                        }
                    }
                }
            }
        repaint();
    }
}