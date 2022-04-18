package graphics;

import animals.Animal;
import animals.Elephant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddAnimalDialog extends JDialog {
    //private final JFrame f = new JFrame("Add Animal");
    //private final JDialog d = new JDialog();
    private final InputsPanel inputs;
    private final String animals[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
    private final JComboBox cb = new JComboBox(animals);
    private final JLabel label = new JLabel();
    private static class InputsPanel extends JPanel {
        private final JTextField tbSize, tbHspeed, tbVspeed;
        private final JLabel labelAnimal = new JLabel();
        private final JLabel labelColor = new JLabel();
        private final String animals[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
        private final String colors[] = {"Red", "Blue", "Natural"};
        private final JComboBox cbAnimals = new JComboBox(animals);
        private final JComboBox cbColors = new JComboBox(colors);

        public InputsPanel() {
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
                    if (tbSize.getText().isEmpty() || tbHspeed.getText().isEmpty() || tbVspeed.getText().isEmpty())
                        JOptionPane.showMessageDialog(null, "All text fields should be filled");
                    else {
                        boolean flag = true;
                        if (Integer.parseInt(tbSize.getText()) <= 50 || Integer.parseInt(tbSize.getText()) >= 300) {
                            flag = false;
                            JOptionPane.showMessageDialog(null, "Size should be between 50 and 300");
                        }
                        if (Integer.parseInt(tbHspeed.getText()) <= 1 || Integer.parseInt(tbHspeed.getText()) >= 10) {
                            flag = false;
                            JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                        }
                        if (Integer.parseInt(tbVspeed.getText()) <= 1 || Integer.parseInt(tbVspeed.getText()) >= 10) {
                            flag = false;
                            JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                        }
                    if (flag) {
                        //String animal = new String(cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString());
                        switch (cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString()) {
                            case "Elephant":
                                Animal animal = new Elephant(Integer.parseInt(tbSize.getText()), Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()), cbColors.getItemAt(cbColors.getSelectedIndex()).toString());
//                                animal.setPan(new ZooPanel());
//                                animal.drawObject(animal.getPan().getGraphics());
                                System.out.println("Test");
                                break;
                            case "Lion":
                                break;
                            case "Giraffe":
                                break;
                            case "Turtle":
                                break;
                            case "Bear":
                                break;
                        }
                    }
                    }
//                    System.out.println(cbAnimals.getItemAt(cbAnimals.getSelectedIndex())); // Test - String of animal
//                    System.out.println(cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString());
                    }
            });
        }

        public double getWeight(String animal) {
            if (animal.equals("Elephant"))
                return Integer.parseInt(tbSize.getText()) * 10;
            else if (animal.equals("Giraffe"))
                return Integer.parseInt(tbSize.getText()) * 2.2;
            else if (animal.equals("Bear"))
                return Integer.parseInt(tbSize.getText()) * 1.5;
            else if (animal.equals("Lion"))
                return Integer.parseInt(tbSize.getText()) * 0.8;
            else if (animal.equals("Turtle"))
                return Integer.parseInt(tbSize.getText()) * 0.5;
            return 0;
        }
    }

    public AddAnimalDialog(ArrayList<Animal> animalArrayList, JPanel mainP)//
    {
        this.setTitle("Add Animal");
        inputs = new InputsPanel();
        inputs.add(mainP);
        this.add(inputs);
        //this.add(new CalculatePanel());
        //this.setLayout(null);
        this.setSize(350, 350);
        //this.pack();
        this.setVisible(true);
        }
    }

