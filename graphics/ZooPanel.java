package graphics;

import animals.Animal;
import diet.Carnivore;
import diet.Herbivore;
import diet.Omnivore;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import graphics.ZooFrame;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    protected ArrayList<Animal> animals = new ArrayList<>();
    protected Plant foodType;
    BufferedImage backgroundImage = null;

    public ZooPanel(ArrayList<Animal> animalArrayList, Plant food) {
        animals = animalArrayList;
        foodType = food;
        try {   // Read image file
            backgroundImage = ImageIO.read(new File("assignment2_pictures/savanna.jpg"));
        } catch (IOException ex) {System.out.println("Cannot load image"); }
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
            System.out.println("Manage");
            for (int i = 0; i < this.animals.size(); i++) {
                if (foodType != null) {
                    System.out.println("test foodtype");
                    if (Math.abs(animals.get(i).getLocation().getX() - 450) <= 10 // foodType.getLocation().getX()
                            && Math.abs(animals.get(i).getLocation().getY() - 150) <= 10) // foodType.getLocation().getY()
                    { System.out.println("test math abs");
                        animals.get(i).eat(foodType);
                        animals.get(i).eatInc();
                        foodType = null;
                        this.repaint();
                    } else if (animals.get(i).getDiet() instanceof Carnivore && this.foodType instanceof Meat) {
                        System.out.println("test else if 1");
                        animals.get(i).eat(foodType);
                        animals.get(i).eatInc();
                        foodType = null;
                        this.repaint(); }
                    else if (animals.get(i).getDiet() instanceof Omnivore) {
                        System.out.println("test else if 2");
                        animals.get(i).eat(foodType);
                        animals.get(i).eatInc();
                        foodType = null;
                        this.repaint(); }
                }
            }
                for (int i = 0; i < this.animals.size(); i++)
                    for (int j = 0; j < this.animals.size(); j++) {
                        System.out.println("test for for");
                        if (i != j) {
                            if (animals.get(i).getDiet() instanceof Carnivore || animals.get(i).getDiet() instanceof Omnivore) {
                                System.out.println("test for for if 1");
                                if (((animals.get(j).getDiet() instanceof Herbivore) || (animals.get(j).getDiet() instanceof Omnivore))) {
                                    System.out.println("test for for if 2");
                                    if (animals.get(i).getWeight() >= 2 * animals.get(j).getWeight()) {
                                        System.out.println("test for for if 3");
                                        System.out.println("DOUBLE:"+ animals.get(i).calcDistance(animals.get(j).getLocation()));
                                        System.out.println("sIZE:"+ animals.get(j).getSize());
                                        if (animals.get(i).calcDistance(animals.get(j).getLocation()) < animals.get(j).getSize()) {
                                            this.animals.get(i).eat(this.animals.get(j));
                                            this.animals.get(i).eatInc();
                                            animals.remove(j);
                                            this.repaint();
                                            System.out.println("test eat");
                                        }
                                    }
                                }
                            }
                        }
                    }
            repaint();
            }
}

//    ZooPanel(Animal animal, JPanel mainP)
//    {
//        //animal.setPan();
////        Image animalImg = animal.getImg();
////        Image newImg = animalImg.getScaledInstance(animal.getSize(), animal.getSize(), Image.SCALE_DEFAULT);
////        ImageIcon lec = new ImageIcon(newImg);
////        JLabel pic = new JLabel();
////        pic.setIcon(lec);
////        pic.setBounds(animal.getX_dir(), animal.getY_dir(), 300, 300);
//        mainP.add(animal.getPan());
//        mainP.repaint();
//    }

