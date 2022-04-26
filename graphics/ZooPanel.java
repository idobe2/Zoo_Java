package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    ArrayList<Animal> animalArrayList = new ArrayList<>();

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
