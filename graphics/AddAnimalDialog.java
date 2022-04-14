package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    JDialog d = new JDialog();
    JFrame f = new JFrame("Add Animal");

    AddAnimalDialog() {
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        JButton b = new JButton("Show");
        b.setBounds(200, 100, 75, 20);
        String languages[] = {"Elephant", "Lion", "Giraffe", "Turtle", "Bear"};
        final JComboBox cb = new JComboBox(languages);
        cb.setBounds(50, 100, 90, 20);
        this.add(cb);
        this.add(label);
        this.add(b);
        this.setLayout(null);
        this.setSize(350, 350);
        this.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Animal Selected: "
                        + cb.getItemAt(cb.getSelectedIndex());
                label.setText(data);
                //System.out.println(cb.getItemAt(cb.getSelectedIndex())); // String of animal
            }
        });
    }
}
//    AddAnimalDialog() {
//        d.setLayout( new FlowLayout() );
//        JCheckBox checkBoxElephant = new JCheckBox("Elephant");
//        JCheckBox checkBoxLion = new JCheckBox("Lion");
//        JCheckBox checkBoxGiraffe = new JCheckBox("Giraffe");
//        JCheckBox checkBoxTurtle = new JCheckBox("Turtle");
//        JCheckBox checkBoxBear = new JCheckBox("Bear");
//        d.add(checkBoxElephant);
//        d.add(checkBoxLion);
//        d.add(checkBoxGiraffe);
//        d.add(checkBoxTurtle);
//        d.add(checkBoxBear);
//        d.setSize(300,300);
//        d.setVisible(true);
//    }