package graphics;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoveAnimalDialog extends JDialog {
    private final JLabel animalLabel = new JLabel();
    private final JButton bOK = new JButton("OK");
    private final JTextField tbX = new JTextField();
    private final JTextField tbY = new JTextField();
    private final JLabel lX = new JLabel("X coordinate:");
    private final JLabel lY = new JLabel("Y coordinate:");
    private final JLabel lA = new JLabel("Animal:");
    private boolean flag = true;

    public MoveAnimalDialog(ArrayList<Animal> animalArrayList, JPanel mainP) {
        {
            // TESTING-start
            animalArrayList.add(new Elephant(100, 7, 8, "Natural", 500));
            animalArrayList.add(new Lion(125,4,3,"Red",250));
            animalArrayList.add(new Giraffe(150,5,6,"Blue",350));
            System.out.println("Size: " + animalArrayList.size());
            // TESTING-end

            this.setTitle("Move Animal");
            String[] animalsClassName = new String[animalArrayList.size()];
            for (int i=0; i<animalArrayList.size(); i++)
                animalsClassName[i] = new String(animalArrayList.get(i).getClass().getSimpleName() + "-" + animalArrayList.get(i).getColorToString());
            JComboBox cbAnimals = new JComboBox(animalsClassName);
            this.setLayout(new GridLayout(4, 5));
            this.add(lA);
            //lA.setHorizontalAlignment(JLabel.CENTER);
            cbAnimals.setBounds(50, 100, 90, 20);
            this.add(cbAnimals);
            animalLabel.setHorizontalAlignment(JLabel.CENTER);
            animalLabel.setSize(400, 100);
            bOK.setBounds(200, 100, 75, 20);
            this.add(lX);
            //lX.setHorizontalAlignment(JLabel.CENTER);
            this.add(tbX);
            this.add(lY);
            //lY.setHorizontalAlignment(JLabel.CENTER);
            this.add(tbY);
            this.add(bOK);
            this.add(animalLabel);
            //this.setLayout(null);
            this.setSize(350, 350);
            this.setVisible(true);
            bOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String dataZoo = "Animal selected: " + cbAnimals.getItemAt(cbAnimals.getSelectedIndex());
                    animalLabel.setText(dataZoo);
                    if (tbX.getText().isEmpty() || tbY.getText().isEmpty())
                        JOptionPane.showMessageDialog(null, "All text fields should be filled");
                    else {
                        if (Integer.parseInt(tbX.getText()) < 0 || Integer.parseInt(tbX.getText()) > 800) {
                            flag = false;
                            JOptionPane.showMessageDialog(null, "X coordinate should be between 0 and 800");
                        }
                        if (Integer.parseInt(tbY.getText()) < 0 || Integer.parseInt(tbY.getText()) > 600) {
                            flag = false;
                            JOptionPane.showMessageDialog(null, "Y coordinate should be between 0 and 600");
                        }
                        if (flag) {
                            animalArrayList.get(cbAnimals.getSelectedIndex()).setX_dir(Integer.parseInt(tbX.getText()));
                            animalArrayList.get(cbAnimals.getSelectedIndex()).setY_dir(Integer.parseInt(tbY.getText()));
                            //System.out.println("X: " + animalArrayList.get(cbAnimals.getSelectedIndex()).getX_dir()
                            // + "\nY: " + animalArrayList.get(cbAnimals.getSelectedIndex()).getY_dir());
                        }
                    }
                }
            });
        }
    }
}