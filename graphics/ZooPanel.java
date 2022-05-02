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
    protected BufferedImage backgroundImage = null;

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
                if (Math.abs(animals.get(i).getLocation().getX() - 450) <= animals.get(i).getEAT_DISTANCE()
                        && Math.abs(animals.get(i).getLocation().getY() - 150) <= animals.get(i).getEAT_DISTANCE())
                {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    repaint();
                } else if (animals.get(i).getDiet() instanceof Carnivore && this.foodType instanceof Meat) {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    repaint();
                } else if (animals.get(i).getDiet() instanceof Omnivore) {
                    animals.get(i).eat(foodType);
                    animals.get(i).eatInc();
                    foodType = null;
                    repaint();
                }
            }
        }
        for (int i = 0; i < animals.size(); i++)
            for (int j = 0; j < animals.size(); j++) {
                if (i != j) {
                    if (animals.get(i).getDiet() instanceof Carnivore || animals.get(i).getDiet() instanceof Omnivore) {
                        if (((animals.get(j).getDiet() instanceof Herbivore) || (animals.get(j).getDiet() instanceof Omnivore))) {
                            if (animals.get(i).getWeight() >= 2 * animals.get(j).getWeight()) {
                                if (animals.get(i).calcDistance(animals.get(j).getLocation()) < animals.get(j).getSize()) {
                                    animals.get(i).eat(animals.get(j));
                                    animals.get(i).eatInc();
                                    animals.remove(j);
                                    repaint();
                                }
                            }
                        }
                    }
                }
            }
        repaint();
    }
}