package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog {
    JDialog d = new JDialog();
    JFrame f= new JFrame("Add Animal");
    AddAnimalDialog() {
        //f=new JFrame("ComboBox Example");
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,100);
        JButton b=new JButton("Show");
        b.setBounds(200,100,75,20);
        String languages[]={"C","C++","C#","Java","PHP"};
        final JComboBox cb=new JComboBox(languages);
        cb.setBounds(50, 100,90,20);
        f.add(cb); f.add(label); f.add(b);
        f.setLayout(null);
        f.setSize(350,350);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Programming language Selected: "
                        + cb.getItemAt(cb.getSelectedIndex());
                label.setText(data);
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

