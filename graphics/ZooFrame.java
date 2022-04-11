package graphics;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ZooFrame extends JFrame { // Main function
    JMenu File, Background, Help, submenu;
    JMenuItem i1, i2, i3, i4, i5;
    ZooFrame(){
        JFrame f= new JFrame("Zoo");
        f.setLayout(new BorderLayout()); // ?

        //  ZooPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(new JButton("Add Animal"));
        buttonPanel.add(new JButton("Move Animal"));
        buttonPanel.add(new JButton("Clear"));
        buttonPanel.add(new JButton("Food"));
        buttonPanel.add(new JButton("Info"));
        buttonPanel.add(new JButton("Exit"));

        JMenuBar mb=new JMenuBar();
        File=new JMenu("File");
        Background = new JMenu("Background");
        Help = new JMenu("Help");
        submenu=new JMenu("Sub Menu");
        i1=new JMenuItem("Exit");
        i2=new JMenuItem("Image");
        i3=new JMenuItem("Green");
        i4=new JMenuItem("None");
        i5=new JMenuItem("Help");
        //f.setLayout(new BoxLayout(f.getContentPane(),  BoxLayout.X_AXIS)); // ?
        File.add(i1);
        Background.add(i2);
        Background.add(i3);
        Background.add(i4);
        Help.add(i5);
        //submenu.add(i4);
        //submenu.add(i5);
        //menu.add(submenu);
        mb.add(File);
        mb.add(Background);
        mb.add(Help);
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.setJMenuBar(mb);
        f.setSize(1000,500);

        //f.setLayout(null); // not good




        //f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new ZooFrame();
//        JFrame frame = new JFrame("Zoo");
//
//
    }
}
