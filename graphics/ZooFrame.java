package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

public class ZooFrame extends JFrame { // Main function
    JFrame f= new JFrame("Zoo");
    JMenu File, Background, Help, submenu;
    JMenuItem i1, i2, i3, i4, i5;
    JMenuBar mb=new JMenuBar();
    BufferedImage backgroundImage;

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
                paint(f.getGraphics());
            }
        });
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
        /*
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        f.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        f.setLayout(null);
        f.pack();
        */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paint(Graphics g)
    {
        ZooFrame.super.paint(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);
        setSize(1000,500);
        setResizable(false);
        //setVisible(true);
    }
    @Override
    public Dimension getPreferredSize() {
        if (backgroundImage != null) {
            int w = backgroundImage.getWidth();
            int h = backgroundImage.getHeight();
            return new Dimension(w, h);
        } else {
            return super.getPreferredSize();
        }
    }
    public static void main(String[] args)
    {
        new ZooFrame();
    }
}
