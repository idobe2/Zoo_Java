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

public class ZooFrame extends JFrame {
    private JPanel mainP = new JPanel();
    private final JMenu File, Background, Help, submenu;
    private final JMenuItem i1, i2, i3, i4, i5; // i1=Exit,i2=Image,i3=Green,i4=None,i5=Help
    private final JMenuBar mb=new JMenuBar();
    private final Color color = UIManager.getColor ( "Panel.background" ); // default background color
    private final ZooPanel zooPanel = new ZooPanel();
    private BufferedImage backgroundImage = null;

    ZooFrame() {
        this.setTitle("Zoo");
        // Read image file
        try {
            backgroundImage = ImageIO.read(new File("assignment2_pictures/savanna.jpg"));
        } catch (IOException ex) {System.out.println("Cannot load image");}

        this.setLayout(new BorderLayout()); // Background color, image not working without it
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
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Background.add(i2); // TODO image
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintImg();
            }
        });
        Background.add(i3);
        Background.add(i4);
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { paintClr(color); }
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
                paintClr(Color.GREEN);
            }
        });
        mb.add(Help);
        i5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Home Work 2\nGUI");
            }
        });
        this.setJMenuBar(mb);
        this.setSize(1000,500);
        // ZooPanel
        this.add(mainP, BorderLayout.CENTER);
        this.add(zooPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

//    public void paintComponent(Graphics g) {
//        super.paintComponents(g) ;
//        if(backgroundImage!=null) {
//            g.drawImage(backgroundImage,0,0,getWidth(),getHeight(), this);
//            //setSize(1000,500);
//            //setResizable(true);
//        }
//    }

//    public ZooPanel getZooPanel() {
//        return zooPanel;
//    }

    public void paintImg()
    {
        //zooPanel.paintImg();
        this.mainP.getGraphics().drawImage(backgroundImage,0,0,getWidth(),getHeight(), mainP);
    }

    public void paintClr(Color color)
    {
        this.mainP.setBackground(color);
    }

    public static void main(String[] args)
    {
        new ZooFrame();
    }
}

