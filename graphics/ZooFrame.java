package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ZooFrame extends JFrame { // Main function
    JFrame f= new JFrame("Zoo");
    JMenu File, Background, Help, submenu;
    JMenuItem i1, i2, i3, i4, i5;
    JMenuBar mb=new JMenuBar();
    BufferedImage backgroundImage;
    Color color = UIManager.getColor ( "Panel.background" ); // default background color

    ZooFrame(){
        try {
            backgroundImage = ImageIO.read(new File("assignment2_pictures/savanna.jpg"));
        } catch (IOException ex) {System.out.println("Cannot load image");}
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
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint(f.getContentPane().getGraphics());
            }
        });
        Background.add(i3);
        Background.add(i4);
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getContentPane().setBackground(color); // default background color
            }
        });
        Help.add(i5);
        /*
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        */
        mb.add(File);
        mb.add(Background);
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               f.getContentPane().setBackground(Color.GREEN);
            }
        });
        mb.add(Help);
        i5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");
            }
        });
        f.setJMenuBar(mb);
        f.setSize(1000,500);
        ZooPanel zooPanel = new ZooPanel();
        f.add(zooPanel.buttonPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paint(Graphics g)
    {
        ZooFrame.super.paint(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);
        setSize(1000,500);
        //setResizable(false);
        //setVisible(true);
    }

    public static void main(String[] args)
    {
        new ZooFrame();
    }
}

