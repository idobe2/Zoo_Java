package graphics;

import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import plants.Plant;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ZooPanel extends JPanel {
    protected ArrayList<Animal> animals;
    protected Plant food = null;
    protected BufferedImage backgroundImage = null;
    protected Color color;

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setFood(Plant foodType){
        this.food = foodType;
        this.repaint();
    }

    public Plant getFood(){
        return this.food;
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
        if (getFood() != null) {
            food.drawObject(g);
        }
    }

    public void manageZoo() {
        if (getFood() != null)
        {
            for (int i = 0; i < this.animals.size(); i++)
            {
                if (Math.abs(animals.get(i).getLocation().getX() - (getFood().getLocation().getX())) <= animals.get(i).getEAT_DISTANCE()
                        && Math.abs(animals.get(i).getLocation().getY() - (getFood().getLocation().getY())) <= animals.get(i).getEAT_DISTANCE())
                    if (animals.get(i).getDiet().canEat(getFood().getFoodtype()))
                    {
                        animals.get(i).eat(getFood());
                        animals.get(i).eatInc();
                        getFood().setPan(null);
                        setFood(null);
                        repaint();
                    }
            }
        }
            if(animals.size() >= 2) {
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
            }
                repaint();
            }
        }