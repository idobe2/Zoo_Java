package graphics;

import animals.Animal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ZooPanel extends JPanel { // implements Runnable
    ArrayList<Animal> animalArrayList = new ArrayList<>();
    //public void run() {}

    ZooPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addAnimalButton = new JButton("Add Animal");
        JButton exitButton = new JButton("Exit");
        this.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnimalDialog(animalArrayList, new JPanel()); // TODO
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
}
