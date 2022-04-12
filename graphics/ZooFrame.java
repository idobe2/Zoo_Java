package graphics;

import javax.swing.*;
import java.awt.*;

public class ZooFrame extends JFrame { // Main function
    JMenu File, Background, Help, submenu;
    JMenuItem i1, i2, i3, i4, i5;
    JMenuBar mb=new JMenuBar();

    ZooFrame(){
        JFrame f= new JFrame("Zoo");
        f.setLayout(new BorderLayout()); // ?
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
        /*
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        */
        mb.add(File);
        mb.add(Background);
        mb.add(Help);
        f.setJMenuBar(mb);
        f.setSize(1000,500);
        ZooPanel zooPanel = new ZooPanel();
        f.add(zooPanel.buttonPanel, BorderLayout.SOUTH);
        /*
        // f.setLayout(null);
        //f.pack();
        */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        ZooFrame mainFrame = new ZooFrame();
//        JFrame frame = new JFrame("Zoo");
//
//
    }
}
