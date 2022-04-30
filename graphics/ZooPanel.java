package graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.GroupLayout.Alignment.*;

public class ZooPanel extends JPanel { // implements Runnable // public void run() {}
    protected ArrayList<Animal> animalArrayList = new ArrayList<>();
    private final JButton addAnimalButton = new JButton("Add Animal");
    private final JButton moveAnimalButton = new JButton("Move Animal");
    private final JButton clearButton = new JButton("Clear");
    private final JButton foodButton = new JButton("Food");
    private final JButton infoButton = new JButton("Info");
    private final JButton exitButton = new JButton("Exit");

    public ZooPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(addAnimalButton);
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Size:" + animalArrayList.size()); // TEST
                if (animalArrayList.size() < 10 )
                    new AddAnimalDialog(animalArrayList, new JPanel()); // TODO which panel to use?
                else JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals");
            }
        });
        this.add(moveAnimalButton);
        moveAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MoveAnimalDialog(animalArrayList);
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
                    }
                });
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Cabbage");
                    }
                });
                b3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Meat");
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
}
