package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooPanel extends JPanel { // implements Runnable

    JPanel buttonPanel = new JPanel();

    //public void run() {}

    ZooPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addAnimalButton = new JButton("Add Animal");
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAnimalDialog();
            }
        });
        buttonPanel.add(new JButton("Move Animal"));
        buttonPanel.add(new JButton("Clear"));
        buttonPanel.add(new JButton("Food"));
        buttonPanel.add(new JButton("Info"));
        buttonPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
                buttonPanel.setBackground(Color.CYAN);
    }
}
