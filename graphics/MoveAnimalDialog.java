package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import mobility.Point;

/**
 * A dialog class that allows you to select an existing animal
 * and move it to new X and Y coordinates.
 *
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see AddAnimalDialog
 */
public class MoveAnimalDialog extends JDialog {
    private final JLabel animalLabel = new JLabel();
    private final JButton bOK = new JButton("OK");
    private final JTextField tbX = new JTextField();
    private final JTextField tbY = new JTextField();
    private final JLabel lX = new JLabel("X coordinate:");
    private final JLabel lY = new JLabel("Y coordinate:");
    private final JLabel lA = new JLabel("Animal:");
    private boolean flag = true;

    /**
     * A Ctor of MoveAnimalDialog, make a dialog for moving an animal.
     * @param animalArrayList
     *          ArrayList<Animal> of all existing animals.
     * @param zooPanel
     *          Provided ZooPanel for drawing animals.
     */
    public MoveAnimalDialog(ArrayList<Animal> animalArrayList, ZooPanel zooPanel) {
        {
            this.setTitle("Move Animal");
            String[] animalsClassName = new String[animalArrayList.size()];
            for (int i=0; i<animalArrayList.size(); i++)
                animalsClassName[i] = new String(animalArrayList.get(i).getClass().getSimpleName() + "-" + animalArrayList.get(i).getColorToString());
            JComboBox cbAnimals = new JComboBox(animalsClassName);
            this.setLayout(new GridLayout(4, 5));
            this.add(lA);
            cbAnimals.setBounds(50, 100, 90, 20);
            this.add(cbAnimals);
            animalLabel.setHorizontalAlignment(JLabel.CENTER);
            animalLabel.setSize(400, 100);
            bOK.setBounds(200, 100, 75, 20);
            this.add(lX);
            this.add(tbX);
            this.add(lY);
            this.add(tbY);
            this.add(bOK);
            this.add(animalLabel);
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
                            Point point = new Point((Integer.parseInt(tbX.getText())),Integer.parseInt(tbY.getText()));
                            animalArrayList.get(cbAnimals.getSelectedIndex()).setLocation(point);
                            animalArrayList.get(cbAnimals.getSelectedIndex()).changeCoored();
                            zooPanel.repaint();
                            zooPanel.manageZoo();
                        }
                    }
                }
            });
        }
    }
}