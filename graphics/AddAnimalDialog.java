package graphics;

import animals.*;

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
        private boolean flag = true;

        public InputsPanel(ArrayList<Animal> animalArrayList, JPanel mainP) {
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
                    }
                    else {
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
                        //String animal = new String(cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString());
                        switch (cbAnimals.getItemAt(cbAnimals.getSelectedIndex()).toString()) {
                            case "Elephant":
                                animalArrayList.add(new Elephant(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Elephant"), Integer.parseInt(tbSize.getText()))));

                                System.out.println(animalArrayList);
                                System.out.println("Test");
                                break;
                            case "Lion":
                                animalArrayList.add(new Lion(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Lion"), Integer.parseInt(tbSize.getText()))));
                                //mainP.add(animal.getPan());
                                System.out.println(animalArrayList);
                                break;
                            case "Giraffe":
                                animalArrayList.add(new Giraffe(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Giraffe"), Integer.parseInt(tbSize.getText()))));
                                //mainP.add(animal.getPan());
                                System.out.println(animalArrayList);
                                break;
                            case "Turtle":
                                animalArrayList.add(new Turtle(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Turtle"), Integer.parseInt(tbSize.getText()))));
                                //mainP.add(animal.getPan());
                                System.out.println(animalArrayList);
                                break;
                            case "Bear":
                                animalArrayList.add(new Bear(Integer.parseInt(tbSize.getText()),
                                        Integer.parseInt(tbHspeed.getText()),
                                        Integer.parseInt(tbVspeed.getText()),
                                        cbColors.getItemAt(cbColors.getSelectedIndex()).toString(),
                                        getWeight(("Bear"), Integer.parseInt(tbSize.getText()))));
                                //mainP.add(animal.getPan());
                                System.out.println(animalArrayList);
                                break;
                        }
                        JOptionPane.showMessageDialog(null, "The animal was added successfully");
                        tbSize.setText(""); tbHspeed.setText(""); tbVspeed.setText("");
                    }
                    }
                }
            });
        }

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

    public AddAnimalDialog(ArrayList<Animal> animalArrayList, JPanel mainP)
    {
        this.setTitle("Add Animal");
        inputs = new InputsPanel(animalArrayList,mainP);
        inputs.add(mainP);
        this.add(inputs);
        //this.add(new CalculatePanel());
        //this.setLayout(null);
        this.setSize(350, 350);
        //this.pack();
        this.setVisible(true);
        }
    }

