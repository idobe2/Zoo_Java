package graphics;

import animals.Animal;

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
        private final JLabel label = new JLabel();
        private final String animals[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
        private final JComboBox cb = new JComboBox(animals);

        public InputsPanel() {
            this.setLayout(new GridLayout(5, 2));
            this.add(new JLabel("Size:"));
            this.add(tbSize = new JTextField());
            this.add(new JLabel("Horizontal speed:"));
            this.add(tbHspeed = new JTextField());
            this.add(new JLabel("Vertical speed:"));
            this.add(tbVspeed = new JTextField());
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setSize(400, 100);
            JButton b = new JButton("OK");
            b.setBounds(200, 100, 75, 20);
            //String animals[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
            cb.setBounds(50, 100, 90, 20);
            this.add(cb);
            this.add(b);
            this.add(label);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String data = "Animal Selected: "
                            + cb.getItemAt(cb.getSelectedIndex());
                    label.setText(data);
                    boolean flag = true;
                    if (Integer.parseInt(tbSize.getText()) <= 50 || Integer.parseInt(tbSize.getText()) >= 300)
                    {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Size should be between 50 and 300");
                    }
                    if (Integer.parseInt(tbHspeed.getText()) <= 1 || Integer.parseInt(tbHspeed.getText()) >= 10)
                    {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                    }
                    if (Integer.parseInt(tbVspeed.getText()) <= 1 || Integer.parseInt(tbVspeed.getText()) >= 10)
                    {
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Speed should be between 1 and 10");
                    }
//                    if (flag) {
//                        if (cb.getItemAt(cb.getSelectedIndex()).equals("Elephant")
//
//                        }
//                    }
                    System.out.println(cb.getItemAt(cb.getSelectedIndex())); // String of animal
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

