package graphics;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import graphics.ZooFrame;

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

    public static void main(String[] args)
    {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
//        panel.add(new JButton("Add Animal"));
//        panel.add(new JButton("Move Animal"));
//        panel.add(new JButton("Clear"));
//        panel.add(new JButton("Food"));
//        panel.add(new JButton("Info"));
//        panel.add(new JButton("Exit"));
        //Thread zoo = new Thread(new ZooPanel());
        //zoo.start();
    }

}
