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
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Animal
 */
public class AddAnimalDialog extends JDialog {
    private final JTextField tbSize, tbHspeed, tbVspeed;
    private final JLabel labelAnimal = new JLabel();
    private final JLabel labelColor = new JLabel();
    private final String[] colors = {"Red", "Blue", "Natural"};
    private final JComboBox<String> cbColors = new JComboBox<>(colors);
    private boolean flag = true;

    /**
     * A Ctor of AddAnimalDialog, make a dialog for adding an animal to the zoo.
     * @param Animals
     *          ArrayList<Animal> of all existing animals.
     * @param zooPanel
     *          Provided ZooPanel for drawing animals.
     */
    public AddAnimalDialog(ArrayList<Animal> Animals, ZooPanel zooPanel, String[] animals)
    {
        JComboBox<String> cbAnimals = new JComboBox<>(animals);
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
        JButton ok = new JButton("OK");
        ok.setBounds(200, 100, 75, 20);
        this.add(cbColors);
        labelColor.setHorizontalAlignment(JLabel.CENTER);
        labelColor.setSize(400, 100);
        this.add(labelColor);
        this.add(ok);
        ok.addActionListener(new ActionListener() {
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
                        switch (cbAnimals.getItemAt(cbAnimals.getSelectedIndex())) {
                            case "Elephant" -> Animals.add(new Elephant(Integer.parseInt(tbSize.getText()),
                                    Integer.parseInt(tbHspeed.getText()),
                                    Integer.parseInt(tbVspeed.getText()),
                                    cbColors.getItemAt(cbColors.getSelectedIndex()),
                                    getWeight(("Elephant"), Integer.parseInt(tbSize.getText()))));
                            case "Lion" -> Animals.add(new Lion(Integer.parseInt(tbSize.getText()),
                                    Integer.parseInt(tbHspeed.getText()),
                                    Integer.parseInt(tbVspeed.getText()),
                                    cbColors.getItemAt(cbColors.getSelectedIndex()),
                                    getWeight(("Lion"), Integer.parseInt(tbSize.getText()))));
                            case "Giraffe" -> Animals.add(new Giraffe(Integer.parseInt(tbSize.getText()),
                                    Integer.parseInt(tbHspeed.getText()),
                                    Integer.parseInt(tbVspeed.getText()),
                                    cbColors.getItemAt(cbColors.getSelectedIndex()),
                                    getWeight(("Giraffe"), Integer.parseInt(tbSize.getText()))));
                            case "Turtle" -> Animals.add(new Turtle(Integer.parseInt(tbSize.getText()),
                                    Integer.parseInt(tbHspeed.getText()),
                                    Integer.parseInt(tbVspeed.getText()),
                                    cbColors.getItemAt(cbColors.getSelectedIndex()),
                                    getWeight(("Turtle"), Integer.parseInt(tbSize.getText()))));
                            case "Bear" -> Animals.add(new Bear(Integer.parseInt(tbSize.getText()),
                                    Integer.parseInt(tbHspeed.getText()),
                                    Integer.parseInt(tbVspeed.getText()),
                                    cbColors.getItemAt(cbColors.getSelectedIndex()),
                                    getWeight(("Bear"), Integer.parseInt(tbSize.getText()))));
                        }
                        Animals.get(Animals.size()-1).setPan(zooPanel);
                        Animals.get(Animals.size()-1).drawObject(zooPanel.getGraphics());
                        zooPanel.repaint();
                        JOptionPane.showMessageDialog(null, "The animal was added successfully");
                        dispose();
                    }
                    else dispose();
                    zooPanel.addToQueue(Animals.get(Animals.size()-1));
//                    SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        Runnable runnable = new ZooPanel(Animals);
//                        zooPanel.setController(new Thread(runnable));
//                        zooPanel.getController().start();
//                    }
//                });
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
     *          (Integer) Animal size on the screen.
     * @return
     *          (Double) Animal weight.
     */
    public double getWeight(String animal, int size) {
        return switch (animal) {
            case "Elephant" -> size * 10;
            case "Giraffe" -> size * 2.2;
            case "Bear" -> size * 1.5;
            case "Lion" -> size * 0.8;
            case "Turtle" -> size * 0.5;
            default -> 0;
        };
    }
}