package graphics;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ZooFrame extends JFrame { // Main function
    JMenu File, Background, Help, submenu;
    JMenuItem i1, i2, i3, i4, i5;
    ZooFrame(){
        JFrame f= new JFrame("Zoo");
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
        f.setJMenuBar(mb);
        f.setSize(1000,500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new ZooFrame();
//        JFrame frame = new JFrame("Zoo");
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }
}
