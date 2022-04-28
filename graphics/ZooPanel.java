package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    ArrayList<Animal> animalArrayList = new ArrayList<>();

    ZooPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addAnimalButton = new JButton("Add Animal");
        JButton moveAnimalButton = new JButton("Move Animal");
        JButton exitButton = new JButton("Exit");
        this.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Size:" + animalArrayList.size()); // TEST
                if (animalArrayList.size() < 10 )
                    new AddAnimalDialog(animalArrayList, new JPanel()); // TODO which panel to use?
                else JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            }
        });
        this.add(moveAnimalButton);
        moveAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test");
                new MoveAnimalDialog(animalArrayList);
            }
        });
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
