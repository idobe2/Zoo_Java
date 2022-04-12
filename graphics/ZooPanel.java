package graphics;

import javax.swing.*;
import java.awt.*;

public class ZooPanel extends JPanel implements Runnable {

    JPanel buttonPanel = new JPanel();

    public void run() {}

    ZooPanel() {
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(new JButton("Add Animal"));
        buttonPanel.add(new JButton("Move Animal"));
        buttonPanel.add(new JButton("Clear"));
        buttonPanel.add(new JButton("Food"));
        buttonPanel.add(new JButton("Info"));
        buttonPanel.add(new JButton("Exit"));
    }
}
