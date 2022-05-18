package graphics;

import animals.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A dialog class that allows you to define a new animal with parameters:
 * Animal type, Size, Horizontal speed, Vertical speed, Color type.
 *
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see MoveAnimalDialog
 */
public class AddAnimalDialog extends JDialog {
    private final String animals[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
    private final JComboBox cb = new JComboBox(animals);
    private final JLabel label = new JLabel();
    private final JTextField tbSize, tbHspeed, tbVspeed;
    private final JLabel labelAnimal = new JLabel();
    private final JLabel labelColor = new JLabel();
    private final String colors[] = {"Red", "Blue", "Natural"};
    private final JComboBox cbAnimals = new JComboBox(animals);
    private final JComboBox cbColors = new JComboBox(colors);
    private boolean flag = true;

    /**
     * A Ctor of AddAnimalDialog, make a dialog for adding an animal to the zoo.
     * @param Animals
     *          ArrayList<Animal> of all existing animals.
     * @param zooPanel
     *          Provided ZooPanel for drawing animals.
     */
    public AddAnimalDialog(ArrayList<Animal> Animals, ZooPanel zooPanel)
    {
        this.setLayout(new GridLayout(6, 2));
        cbAnimals.setBounds(50, 100, 90, 20);
        this.add(cbAnimals);
        labelAnimal.setHorizontalAlignment(JLabel.CENTER);
        labelAnimal.setSize(400, 100);
        this.add(labelAnimal);
        this.add(new JLabel("Size:"));
        this.add(tbSize = new JTextField());
        this.add(new JLabel("Horizontal speed:"));
        this.add(tbHspeed = new JTextField());
        this.add(new JLabel("Vertical speed:"));
        this.add(tbVspeed = new JTextField());
        JButton b = new JButton("OK");
        b.setBounds(200, 100, 75, 20);
        this.add(cbColors);
        labelColor.setHorizontalAlignment(JLabel.CENTER);
        labelColor.setSize(400, 100);
        this.add(labelColor);
        this.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dataAnimal = "Animal Selected: "
                        + cbAnimals.getItemAt(cbAnimals.getSelectedIndex());
                labelAnimal.setText(dataAnimal);
                String dataColors = "Color Selected: "
                        + cbColors.getItemAt(cbColors.getSelectedIndex());
                labelColor.setText(dataColors);
                if (tbSize.getText().isEmpty() || tbHspeed.getText().isEmpty() || tbVspeed.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All text fields should be filled");
                    flag = false;
                } else {
                    if (Integer.parseInt(tbSize.getText()) < 50 || Integer.parseInt(tbSize.getText()) > 300) {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Size should be between 50 and 300");
                    }
                    if (Integer.parseInt(tbHspeed.getText()) < 1 || Integer.parseInt(tbHspeed.getText()) > 10) {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                    }
                    if (Integer.parseInt(tbVspeed.getText()) < 1 || Integer.parseInt(tbVspeed.getText()) > 10) {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                    }
                    if (flag) {
                        switch (cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString()) {
                            case "Elephant":
                                Animals.add(new Elephant(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Elephant"), Integer.parseInt(tbSize.getText()))));
                                break;
                            case "Lion":
                                Animals.add(new Lion(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Lion"), Integer.parseInt(tbSize.getText()))));
                                break;
                            case "Giraffe":
                                Animals.add(new Giraffe(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Giraffe"), Integer.parseInt(tbSize.getText()))));
                                break;
                            case "Turtle":
                                Animals.add(new Turtle(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Turtle"), Integer.parseInt(tbSize.getText()))));
                                break;
                            case "Bear":
                                Animals.add(new Bear(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Bear"), Integer.parseInt(tbSize.getText()))));
                                break;
                        }
                        Animals.get(Animals.size()-1).setPan(zooPanel);
                        Animals.get(Animals.size()-1).drawObject(zooPanel.getGraphics());
                        //animalArrayList.get(animalArrayList.size()-1).setThread(new Thread(animalArrayList.get(animalArrayList.size()-1)));
                        zooPanel.repaint();
                        JOptionPane.showMessageDialog(null, "The animal was added successfully");
                        dispose();
                    }
                    else dispose();
//                    if (zooPanel.getController() == null)
//                    {
//                        zooPanel.setController(new Thread(zooPanel));
//                        zooPanel.getController().start();
//                    }
                    SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("Test Add Animal Thread invoke later " + getName());
                        Runnable runnable = new ZooPanel(Animals);
                        zooPanel.setController(new Thread(runnable));
                        zooPanel.getController().start();
                    }
                });
                }
            }
        });
        this.setTitle("Add Animal");
        this.setSize(250, 300);
        this.setVisible(true);
    }

    /**
     * A getter for animals weight to calculate with animals size.
     * @param animal
     *          (String) Type-of-animal.
     * @param size
     *          (Integer) Size of animal on the panel.
     * @return
     */
    public double getWeight(String animal, int size) {
        if (animal.equals("Elephant"))
            return size * 10;
        else if (animal.equals("Giraffe"))
            return size * 2.2;
        else if (animal.equals("Bear"))
            return size * 1.5;
        else if (animal.equals("Lion"))
            return size * 0.8;
        else if (animal.equals("Turtle"))
            return size * 0.5;
        return 0;
    }
}