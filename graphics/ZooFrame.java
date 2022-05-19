package graphics;

import animals.Animal;
import mobility.Point;
import plants.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A frame class that combined the menu bar,
 * ZooPanel for drawing objects and mainP - bottom panel.
 *
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see ZooPanel
 */
public class ZooFrame extends JFrame {
    protected ArrayList<Animal> Animals = new ArrayList<>();
    private Plant foodType;
    protected JPanel mainP = new JPanel();
    private final JMenu File, Background, Help, submenu;
    private final JMenuItem i1, i2, i3, i4, i5; // i1=Exit,i2=Image,i3=Green,i4=None,i5=Help
    private final JMenuBar mb=new JMenuBar();
    private final Color color = UIManager.getColor ( "Panel.background" ); // Default background color
    private final ZooPanel zooPanel = new ZooPanel(Animals);
    private BufferedImage backgroundImage = null;

    /**
     * ZooFrame constructor - make a frame for all the components to be unit.
     * Main panel Initialization along with all action buttons.
     */
    ZooFrame() {
        this.setTitle("Zoo");
        try {   // Read image file
            backgroundImage = ImageIO.read(new File("assignment2_pictures/savanna.jpg"));
        } catch (IOException ex) {System.out.println("Cannot load image"); }
        this.setLayout(new BorderLayout()); // For image background
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
        Background.add(i2);
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBackgroundImage(backgroundImage);
            }
        });
        Background.add(i3);
        Background.add(i4);
        i4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { zooPanel.setBackgroundColor(color); }
        });
        Help.add(i5);
        mb.add(File);
        mb.add(Background);
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zooPanel.setBackgroundColor(Color.GREEN);
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
        /*--------------------MainPanel--------------------*/
        JButton addAnimalButton = new JButton("Add Animal");
        addAnimalButton.setBackground(Color.LIGHT_GRAY);
//        JButton moveAnimalButton = new JButton("Move Animal");
        JButton sleepButton = new JButton("Sleep");
        sleepButton.setBackground(Color.LIGHT_GRAY);
        JButton wakeUpButton = new JButton("Wake up");
        wakeUpButton.setBackground(Color.LIGHT_GRAY);
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.LIGHT_GRAY);
        JButton foodButton = new JButton("Food");
        foodButton.setBackground(Color.LIGHT_GRAY);
        JButton infoButton = new JButton("Info");
        infoButton.setBackground(Color.LIGHT_GRAY);
        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.LIGHT_GRAY);
        //mainP.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainP.setLayout(new GridLayout(1,7));
        /*--------------------AddAnimal--------------------*/
        mainP.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Animals.size() < 10 )
                    new AddAnimalDialog(Animals, zooPanel);
                else JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            }
        });
        /*--------------------MoveAnimal(Saved)--------------------*/
        /*mainP.add(moveAnimalButton);
        moveAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveAnimalDialog(Animals, zooPanel);
            }
        });*/
        /*--------------------Sleep--------------------*/
        mainP.add(sleepButton);
        sleepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<Animals.size(); i++)
                    Animals.get(i).setSuspended();
                repaint();
            }
        });
        /*--------------------WakeUp--------------------*/
        mainP.add(wakeUpButton);
        wakeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (this) {
                    for (int i = 0; i < Animals.size(); i++) {
                        Animals.get(i).setResumed();
                    }
                    repaint();
                }
            }
        });
        /*--------------------Clear--------------------*/
        mainP.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Animals.size(); i++) {
                    Animals.get(i).stop();
                    zooPanel.remove(Animals.get(i).getPan());
                }
                zooPanel.setFood(null);
                Animals.clear();
                zooPanel.setBackgroundColor(null);
                zooPanel.setBackgroundImage(null);
                zooPanel.repaint();
            }
        });
        /*--------------------Food--------------------*/
        mainP.add(foodButton);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame foodFrame = new JFrame("Food for animals");
                JPanel panel = new JPanel();
                GroupLayout layout = new GroupLayout(panel);
                JLabel lF = new JLabel("Please choose food");
                lF.setSize(400, 200);
                lF.setHorizontalAlignment(JLabel.CENTER);
                foodFrame.add(lF);
                JButton b1 = new JButton("Lettuce");
                JButton b2 = new JButton("Cabbage");
                JButton b3 = new JButton("Meat");
                GroupLayout.SequentialGroup leftToRight = layout.createSequentialGroup();
                leftToRight.addComponent(b1);
                leftToRight.addComponent(b2);
                leftToRight.addComponent(b3);
                GroupLayout.ParallelGroup rowBottom = layout.createParallelGroup();
                rowBottom.addComponent(b1);
                rowBottom.addComponent(b2);
                rowBottom.addComponent(b3);
                layout.setHorizontalGroup(leftToRight);
                foodFrame.add(panel, BorderLayout.PAGE_END);
                foodFrame.setSize(400,200);
                foodFrame.setVisible(true);
                /*--------------------Lettuce--------------------*/
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        foodType = new Lettuce();
                        foodType.setLocation(new Point(zooPanel.getWidth()/2, zooPanel.getHeight()/2));
                        foodType.loadImages("Lettuce");
                        foodType.setPan(zooPanel);
                        foodType.drawObject(zooPanel.getGraphics());
                        zooPanel.setFood(foodType);
                        foodFrame.dispose();
                    }
                });
                /*--------------------Cabbage--------------------*/
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        foodType = new Cabbage();
                        foodType.setLocation(new Point(zooPanel.getWidth()/2, zooPanel.getHeight()/2));
                        foodType.loadImages("Cabbage");
                        foodType.setPan(zooPanel);
                        foodType.drawObject(zooPanel.getGraphics());
                        zooPanel.setFood(foodType);
                        foodFrame.dispose();
                    }
                });
                /*--------------------Meat--------------------*/
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        foodType = new Meat();
                        foodType.setLocation(new Point(zooPanel.getWidth()/2, zooPanel.getHeight()/2));
                        foodType.loadImages("Meat");
                        foodType.setPan(zooPanel);
                        foodType.drawObject(zooPanel.getGraphics());
                        zooPanel.setFood(foodType);
                        foodFrame.dispose();
                    }
                });
            }
        });
        /*--------------------Info--------------------*/
        mainP.add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame infoFrame = new JFrame("Info");
                String column[] = {"Animal", "Color", "Weight", "Hor. speed", "Ver. speed", "Eat counter"};
                int totalEatCount = 0;
                String[][] animalsData = new String[Animals.size()+1][6];
                for (int i = 0; i < Animals.size(); i++) {
                    for (int j = 0; j < 6; j++) {
                        switch (j) {
                            case 0: // Animal
                                animalsData[i][j] = new String(Animals.get(i).getClass().getSimpleName());
                                break;
                            case 1: // Color
                                animalsData[i][j] = new String(Animals.get(i).getColorToString());
                                break;
                            case 2: // Weight
                                animalsData[i][j] = new String(String.valueOf(Animals.get(i).getWeight()));
                                break;
                            case 3: // Hor. speed
                                animalsData[i][j] = new String(String.valueOf(Animals.get(i).getHorSpeed()));
                                break;
                            case 4: // Ver. speed
                                animalsData[i][j] = new String(String.valueOf(Animals.get(i).getVerSpeed()));
                                break;
                            case 5: // Eat counter
                                animalsData[i][j] = new String(String.valueOf(Animals.get(i).getEatCount()));
                                totalEatCount += Animals.get(i).getEatCount();
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid input...");
                        }
                    }
                }
                String[] endLine = {"Total", "", "", "", "", String.valueOf(totalEatCount)};
                animalsData[Animals.size()] = endLine;
                JTable infoTable = new JTable(animalsData,column);
                infoTable.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(infoTable);
                infoFrame.add(sp);
                infoFrame.setSize(500,350);
                infoFrame.setVisible(true);
            }
        });
        /*--------------------Exit--------------------*/
        mainP.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Animals.size(); i++)
                    Animals.get(i).stop();
                System.exit(0);
            }
        });
        this.setBackground(Color.CYAN);
        mainP.setBackground(Color.GRAY);
        this.add(mainP, BorderLayout.SOUTH);
        this.add(zooPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new ZooFrame();
    }
}

