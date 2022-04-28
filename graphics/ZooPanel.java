package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.GroupLayout.Alignment.*;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    ArrayList<Animal> animalArrayList = new ArrayList<>();

    ZooPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addAnimalButton = new JButton("Add Animal");
        JButton moveAnimalButton = new JButton("Move Animal");
        JButton clearButton = new JButton("Clear");
        JButton foodButton = new JButton("Food");
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
        this.add(clearButton);
        this.add(foodButton);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Test");
                JFrame foodFrame = new JFrame("Food for animals");
                //foodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container myPanel = foodFrame.getContentPane();
                GroupLayout groupLayout = new GroupLayout(myPanel);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);
                myPanel.setLayout(groupLayout);
                JLabel lF = new JLabel("Please choose food");
                lF.setSize(400, 200);
                lF.setHorizontalAlignment(JLabel.CENTER);
                foodFrame.add(lF);
                JButton b1 = new JButton("Lettuce");
                JButton b2 = new JButton("Cabbage");
                JButton b3 = new JButton("Meat");

                groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b1).addComponent(b3))
                        .addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(b2)));

                groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b1).addComponent(b2))
                        .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b3)));

                foodFrame.setSize(400,200);
                foodFrame.setVisible(true);
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Lettuce");
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Cabbage");
                    }
                });
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Meat");
                    }
                });
            }
        });
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
