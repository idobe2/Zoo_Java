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
    protected Plant foodType = null;
    protected BufferedImage backgroundImage = null;
    protected Color color;

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }


    public void setfoodtype(Plant foodType){
        this.foodType = foodType;
        this.repaint();
    }

    public Plant getfoodtype(){
        return this.foodType;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        if (getBackgroundColor() != null)
            setBackgroundColor(null);
        this.backgroundImage = backgroundImage;
        this.repaint();
    }
    public Color getBackgroundColor() {
        return color;
    }
    public void setBackgroundColor(Color backgroundColor) {
        if (getBackgroundImage() != null)
            setBackgroundImage(null);
        this.color = backgroundColor;
        this.repaint();
    }

    public ZooPanel(ArrayList<Animal> animalArrayList) {
        animals = animalArrayList;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getBackgroundImage() != null) // Check if there is background image
            g.drawImage(getBackgroundImage(),0,0,getWidth(),getHeight(), this);
        else if (getBackgroundColor() != null) { // Check if there is background color
            g.setColor(getBackgroundColor());
            g.fillRect(0,0,getWidth(),getHeight());
        }

        if (!animals.isEmpty()) {
            for (int i = 0; i < animals.size(); i++) {
                animals.get(i).drawObject(g);
            }
        }
        if (getfoodtype() != null) {
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