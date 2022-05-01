package graphics;

import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Meat;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import graphics.ZooFrame;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    protected ArrayList<Animal> animalArrayList = new ArrayList<>();
    private Plant foodType;

    public ZooPanel(JPanel mainP) {
        JButton addAnimalButton = new JButton("Add Animal");
        JButton moveAnimalButton = new JButton("Move Animal");
        JButton clearButton = new JButton("Clear");
        JButton foodButton = new JButton("Food");
        JButton infoButton = new JButton("Info");
        JButton exitButton = new JButton("Exit");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Size:" + animalArrayList.size()); // TEST
                if (animalArrayList.size() < 10 )
                    new AddAnimalDialog(animalArrayList, mainP); // TODO which panel to use?
                else JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            }
        });
        this.add(moveAnimalButton);
        moveAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveAnimalDialog(animalArrayList, mainP);
            }
        });
        this.add(clearButton);
        this.add(foodButton);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame foodFrame = new JFrame("Food for animals");
                JPanel panel = new JPanel();
                //foodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                b1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Lettuce");
                        setPlant("Lettuce", mainP);
                        foodFrame.dispose();
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Cabbage");
                        setPlant("Cabbage", mainP);
                        foodFrame.dispose();
                    }
                });
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Meat");
                        setPlant("Meat", mainP);
                        foodFrame.dispose();
                    }
                });
            }
        });
        this.add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame infoFrame = new JFrame("Info");
                String column[] = {"Animal", "Color", "Weight", "Hor. speed", "Ver. speed", "Eat counter"};
                int totalEatCount = 0;
                String[][] animalsData = new String[animalArrayList.size()+1][6];
                for (int i = 0; i < animalArrayList.size(); i++) {
                    for (int j = 0; j < 6; j++) {
                        switch (j) {
                            case 0: // Animal
                                animalsData[i][j] = new String(animalArrayList.get(i).getClass().getSimpleName());
                                break;
                            case 1: // Color
                                animalsData[i][j] = new String(animalArrayList.get(i).getColorToString());
                                break;
                            case 2: // Weight
                                animalsData[i][j] = new String(String.valueOf(animalArrayList.get(i).getWeight()));
                                break;
                            case 3: // Hor. speed
                                animalsData[i][j] = new String(String.valueOf(animalArrayList.get(i).getHorSpeed()));
                                break;
                            case 4: // Ver. speed
                                animalsData[i][j] = new String(String.valueOf(animalArrayList.get(i).getVerSpeed()));
                                break;
                            case 5: // Eat counter
                                animalsData[i][j] = new String(String.valueOf(animalArrayList.get(i).getEatCount()));
                                totalEatCount += animalArrayList.get(i).getEatCount();
                                break;
                            default:
                                System.out.println("Error");
                                break;
                        }
                    }
                }
                String[] endLine = {"Total", "", "", "", "", String.valueOf(totalEatCount)};
                animalsData[animalArrayList.size()] = endLine;
                JTable infoTable = new JTable(animalsData,column);
                infoTable.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(infoTable);
                infoFrame.add(sp);
                infoFrame.setSize(500,350);
                infoFrame.setVisible(true);
                // Testing-start
                    for (int i = 0; i < animalArrayList.size(); i++) {
                        for (int j = 0; j < 6; j++)
                            System.out.print(animalsData[i][j] + " ");
                        System.out.println();
                    }
                // Testing-end
                }
        });
        this.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.setBackground(Color.CYAN);
    }

    public void setPlant(String food, JPanel mainP)
    {
        switch (food)
        {
            case "Cabbage":
                this.foodType = new Cabbage();
                break;
            case "Lettuce":
                this.foodType = new Lettuce();
                break;
            case "Meat":
                this.foodType = new Meat();
                break;
            default:
                this.foodType = null;
        }
        this.foodType.loadImages("");
        Image img = foodType.getImg();
        //Image resizedImg = img.getScaledInstance(50,50, Image.SCALE_DEFAULT);
        ImageIcon IconImg = new ImageIcon(img.getScaledInstance(50,50, Image.SCALE_DEFAULT));
        JLabel pic = new JLabel();
        pic.setIcon(IconImg);
        pic.setBounds(450,150, 100, 100);
        mainP.add(pic);
        mainP.repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    ZooPanel(Animal animal, JPanel mainP)
    {
        //animal.setPan();
//        Image animalImg = animal.getImg();
//        Image newImg = animalImg.getScaledInstance(animal.getSize(), animal.getSize(), Image.SCALE_DEFAULT);
//        ImageIcon lec = new ImageIcon(newImg);
//        JLabel pic = new JLabel();
//        pic.setIcon(lec);
//        pic.setBounds(animal.getX_dir(), animal.getY_dir(), 300, 300);
        mainP.add(animal.getPan());
        mainP.repaint();
    }
}
