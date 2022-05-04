package graphics;

import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import food.EFoodType;
import plants.Cabbage;
import plants.Lettuce;
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
            System.out.println("Check" + Math.abs(animals.get(i).getLocation().getX() - (getfoodtype().getLocation().getX())));
            if (getfoodtype() != null) {
                if (animals.get(i).getDiet() instanceof Herbivore && (getfoodtype().getFoodtype() == EFoodType.VEGETABLE)) {
                    System.out.println("nihnas 1111");
                    if (Math.abs(animals.get(i).getLocation().getX() - (getfoodtype().getLocation().getX())) <= 10 && Math.abs(animals.get(i).getLocation().getY() - (getfoodtype().getLocation().getY())) <= 10) {
                        System.out.println("nihnas 1");
                        animals.get(i).eat(getfoodtype());
                        animals.get(i).eatInc();
                        setfoodtype(null);
                        repaint();
                    }
                } else if (animals.get(i).getDiet() instanceof Carnivore && (animals.get(i).getDiet().canEat(getfoodtype().getFoodtype()))) {
                    System.out.println("lama avar");
                    if (Math.abs(animals.get(i).getLocation().getX() - (getfoodtype().getLocation().getX())) <= 10 && Math.abs(animals.get(i).getLocation().getY() - (getfoodtype().getLocation().getY())) <= 10) {
                        animals.get(i).eat(getfoodtype());
                        animals.get(i).eatInc();
                        setfoodtype(null);
                        repaint();
                    }

                    }
                    else if (animals.get(i).getDiet() instanceof Omnivore && ((getfoodtype().getFoodtype() == EFoodType.VEGETABLE) || (getfoodtype().getFoodtype() == EFoodType.MEAT))) {
                        if (Math.abs(animals.get(i).getLocation().getX() - (getfoodtype().getLocation().getX())) <= 10 && Math.abs(animals.get(i).getLocation().getY() - (getfoodtype().getLocation().getY())) <= 10) {
                            animals.get(i).eat(getfoodtype());
                            animals.get(i).eatInc();
                            setfoodtype(null);
                            repaint();
                        }
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
