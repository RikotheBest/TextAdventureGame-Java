package Design;

import Units.Player;
import Weapons.Stick;

import java.awt.*;
import javax.swing.*;

public class UI {
    JFrame window;
    JPanel titlePanel, startPanel, mainPanel, choiceButtonPanel, playerPanel;
    JLabel title, hpLabel, weaponLabel;
    JButton startButton, choice1, choice2, choice3, choice4, choice5;
    Font font, startFont;
    JTextArea mainText;
    Player player;



    public void startGame(Choice choice, Player player) {

        window = new JFrame();
        title = new JLabel("Adventure");

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);

        title = new JLabel("Adventure");
        title.setForeground(Color.white);
        titlePanel.add(title);

        font = new Font("Times New Roman", Font.PLAIN, 90);
        title.setFont(font);

        window.add(titlePanel);

        startPanel = new JPanel();
        startPanel.setBackground(Color.black);
        startPanel.setBounds(300, 400, 200, 100);
        startButton = new JButton("Start");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startFont = new Font("Times New Roman", Font.PLAIN, 22);
        startButton.setFont(startFont);
        startButton.addActionListener(choice);
        startButton.setActionCommand("start");
        startPanel.add(startButton);

        window.add(startPanel);


        window.setVisible(true);


        mainPanel = new JPanel();
        mainPanel.setBounds(100, 100, 600, 250);
        mainPanel.setBackground(Color.black);
        window.add(mainPanel);

        mainText = new JTextArea();
        mainText.setEditable(false);
        mainText.setBounds(100, 100, 600, 250);
        mainText.setBackground(Color.black);
        mainText.setForeground(Color.white);
        mainText.setFont(startFont);
        mainText.setLineWrap(true);
        mainPanel.add(mainText);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 400, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new BorderLayout());
        window.add(choiceButtonPanel);

        choice1 = new JButton("North");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFocusPainted(false);
        choice1.setBorderPainted(false);
        choice1.setFont(startFont);
        choice1.addActionListener(choice);
        choice1.setActionCommand("N");
        choiceButtonPanel.add(choice1, BorderLayout.NORTH);

        choice2 = new JButton("South");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFocusPainted(false);
        choice2.setBorderPainted(false);
        choice2.addActionListener(choice);
        choice2.setActionCommand("S");
        choice2.setFont(startFont);
        choiceButtonPanel.add(choice2, BorderLayout.SOUTH);

        choice3 = new JButton("West");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFocusPainted(false);
        choice3.setBorderPainted(false);
        choice3.addActionListener(choice);
        choice3.setActionCommand("W");
        choice3.setFont(startFont);
        choiceButtonPanel.add(choice3, BorderLayout.WEST);

        choice4 = new JButton("East");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFocusPainted(false);
        choice4.setBorderPainted(false);
        choice4.addActionListener(choice);
        choice4.setActionCommand("E");
        choice4.setFont(startFont);
        choiceButtonPanel.add(choice4, BorderLayout.EAST);

        choice5 = new JButton("Interact");
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.white);
        choice5.setFocusPainted(false);
        choice5.setBorderPainted(false);
        choice5.addActionListener(choice);
        choice5.setActionCommand("I");
        choice5.setFont(startFont);
        choiceButtonPanel.add(choice5, BorderLayout.CENTER);


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 25);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,7));
        window.add(playerPanel);




        hpLabel = new JLabel("HP: " + player.getHp());
        hpLabel.setFont(startFont);
        hpLabel.setBackground(Color.black);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);


        weaponLabel = new JLabel("Weapon: " + player.weapon.getName());
        weaponLabel.setFont(startFont);
        weaponLabel.setBackground(Color.black);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);


    }









}



