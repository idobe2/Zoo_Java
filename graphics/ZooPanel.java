package graphics;

import animals.Animal;
import diet.*;
import plants.Plant;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A class of ZooPanel, required to draw all objects on the center area.
 *
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see ZooFrame
 */
public class ZooPanel extends JPanel implements Runnable {
    protected ArrayList<Animal> animals;
    protected Plant food = null;
    protected BufferedImage backgroundImage = null;
    protected Color backgroundColor;

    private Thread controller;

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                animals.get(animals.size()-1).getThread().start();
                repaint();
                //manageZoo();
            }
        });

    }

    public Thread getController() { return this.controller; }

    public boolean setController(Thread controller) {this.controller = controller; return true; }

    /**
     * An easy ctor of ZooPanel.
     * @param animalArrayList
     *          (ArrayList<Animal>) All existing animals.
     */
    public ZooPanel(ArrayList<Animal> animalArrayList) {
        animals = animalArrayList;
    }

    /**
     * A setter of food to be drawn.
     * @param foodType
     *      (Plant) Cabbage, Lettuce, or Meat object.
     */
    public boolean setFood(Plant foodType){
       this.food = foodType;
       return true;
    }

    /**
     * A getter of food to be drawn.
     * @return (Plant) Cabbage, Lettuce, or Meat object.
     */
    public synchronized Plant getFood(){
        return this.food;
    }

    /**
     * A setter of background image.
     * @param backgroundImage
     *          (BufferedImage) to be the background.
     */
    public void setBackgroundImage(BufferedImage backgroundImage) {
        if (getBackgroundColor() != null)
            setBackgroundColor(null);
        this.backgroundImage = backgroundImage;
        this.repaint();
    }

    /**
     * A getter of background imgae.
     * @return backgoundImage.
     */
    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * A getter of background color.
     * @return backgoundColor.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * A setter of background color.
     * @param backgroundColor
     *          (Color) to be the background.
     */
    public void setBackgroundColor(Color backgroundColor) {
        if (getBackgroundImage() != null)
            setBackgroundImage(null);
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    /**
     * Calls the UI delegate's paint method, if the UI delegate is non-null.
     * We use it to paint the components.
     * @param g
     *      Provided Graphics.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getBackgroundImage() != null) // Check if there is a background image
            g.drawImage(getBackgroundImage(),0,0,getWidth(),getHeight(), this);
        else if (getBackgroundColor() != null) { // Check if there is a background color
            g.setColor(getBackgroundColor());
            g.fillRect(0,0,getWidth(),getHeight()); }
        if (!animals.isEmpty()) {
            for (int i = 0; i < animals.size(); i++) {
                animals.get(i).drawObject(g); } }
        if (getFood() != null) {
            food.drawObject(g); }
    }

    /**
     * This function is called after each operation.
     * We use it to look for changes and perform actions.
     */
    public synchronized void manageZoo() {
//        System.out.println("UI thread name is: " + Thread.currentThread().getName());
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
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                repaint();
                            }
                        });
                        //repaint();
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
                                            SwingUtilities.invokeLater(new Runnable() {
                                                public void run() {
                                                    repaint();
                                                }
                                            });
                                            //repaint();
                                        }
                                    }
                                }
                            }
                        }
                    }
                repaint();
            }
        }