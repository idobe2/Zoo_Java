package graphics;

import animals.Animal;
import diet.*;
import plants.Plant;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * A class of ZooPanel, required to draw all objects on the center area.
 *
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see ZooFrame
 */
public class ZooPanel extends JPanel implements Runnable {
    protected ArrayList<Animal> Animals;
    protected Plant food = null;
    protected BufferedImage backgroundImage = null;
    protected Color backgroundColor;
    private Thread controller;
    private ThreadPool pool;

    /**
     * When an object implementing interface Runnable is used to create a thread,
     * starting the thread causes the object's run method to be called in that separately executing thread.
     */
    @Override
    public void run() {
        //Animals.get(Animals.size()-1).getThread().start();
    }

    public boolean addToQueue(Animal animal)
    {
        return this.pool.addToPool(animal);
    }

    /**
     * A getter of the controller thread.
     * @return (Thread)
     */
    public Thread getController() { return this.controller; }

    /**
     * A setter of the controller thread.
     */
    public boolean setController(Thread controller) {this.controller = controller; return true; }

    public boolean setPool(ThreadPool pool)
    {
        this.pool = pool;
        return true;
    }

    /**
     * An easy ctor of ZooPanel.
     * @param animalArrayList
     *          (ArrayList<Animal>) All existing animals.
     */
    public ZooPanel(ArrayList<Animal> animalArrayList) {
        Animals = animalArrayList;
    }

    /**
     * A setter of food to be drawn.
     * @param foodType
     *      (Plant) Cabbage, Lettuce, or Meat object.
     */
    public synchronized boolean setFood(Plant foodType){
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
        if (!Animals.isEmpty()) {
            for (Animal animal : Animals) {
                animal.drawObject(g);
            }
        }
        if (getFood() != null) {
            food.drawObject(g); }
    }

    /**
     * This function is called after each operation made in the zoo.
     * Its purpose is to handle changes and perform actions.
     */
    public synchronized void manageZoo() {
        if (getFood() != null)
        {
            for (Animal animal : this.Animals) {
                if (Math.abs(animal.getLocation().getX() - (getFood().getLocation().getX())) <= animal.getEAT_DISTANCE()
                        && Math.abs(animal.getLocation().getY() - (getFood().getLocation().getY())) <= animal.getEAT_DISTANCE())
                    if (animal.getDiet().canEat(getFood().getFoodType())) {
                        animal.eat(getFood());
                        animal.eatInc();
                        getFood().setPan(null);
                        setFood(null);
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                repaint();
                            }
                        });
                    }
            }
        }
                for (int i = 0; i < Animals.size(); i++)
                    for (int j = 0; j < Animals.size(); j++) {
                        if (i != j) {
                            if (Animals.get(i).getDiet() instanceof Carnivore || Animals.get(i).getDiet() instanceof Omnivore) {
                                if (((Animals.get(j).getDiet() instanceof Herbivore) || (Animals.get(j).getDiet() instanceof Omnivore))) {
                                    if (Animals.get(i).getWeight() >= 2 * Animals.get(j).getWeight()) {
                                        if (Animals.get(i).calcDistance(Animals.get(j).getLocation()) < Animals.get(j).getSize()) {
                                            Animals.get(i).eat(Animals.get(j));
                                            Animals.get(i).eatInc();
                                            Animals.get(j).stop();
                                            Animals.remove(j);
                                            SwingUtilities.invokeLater(new Runnable() {
                                                public void run() {
                                                    repaint();
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                repaint();
            }
        }