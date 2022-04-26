package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    ArrayList<Animal> animalArrayList = new ArrayList<>();

//    private BufferedImage backgroundImage;
//    private Color backgroundColor;
//
//    public BufferedImage getBackgroundImage() { return backgroundImage;}
//
//    public void setBackgroundImage(BufferedImage backgroundImage) {
//        if (getBackgroundImage()!= null)
//            setBackgroundImage(null);
//        this.backgroundImage = backgroundImage;
//        this.repaint();
//    }
//
//    public Color getBackgroundColor() { return backgroundColor; }
//
//    public void setBackgroundColor(Color backgroundColor) {
//        if (getBackgroundImage() != null)
//            setBackgroundImage(null);
//        this.backgroundColor = backgroundColor;
//        this.repaint();
//    }

    ZooPanel(JPanel mainP) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addAnimalButton = new JButton("Add Animal");
        JButton exitButton = new JButton("Exit");
        this.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animalArrayList.size() < 10)
                    new AddAnimalDialog(animalArrayList, mainP); // TODO
                else
                    JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
                System.out.println("Size of array: " + animalArrayList.size());
            }
        });
        this.add(new JButton("Move Animal"));
        this.add(new JButton("Clear"));
        this.add(new JButton("Food"));
        this.add(new JButton("Info"));
        this.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.CYAN);
    }

//    public ZooPanel(String animal)
//    {
//            paintComponents(animalArrayList.get(0).getPan().getGraphics());
//            System.out.println("Test2");
//    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
//        if (getBackgroundImage() != null)
//            g.drawImage(getBackgroundImage(), 0, 0, this);
//        else if (getBackgroundColor() != null) {
//            g.setColor(getBackgroundColor());
//            g.fillRect(0,0,getWidth(),getHeight());

        }
    }
