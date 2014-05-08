/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rockpaperscissors;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.Random;

/**
 *
 * @author Davey Nicewander
 */
public class MainFrame extends JFrame {
    
    public MainFrame()
    {
        addElements();
        
        setSize(WIDTH, HEIGHT);
        setTitle("Rock, Paper, Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    class RockListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            userChoice = 1;
            userWeapon.setText("Your Choice: Rock");
            computerDecision();
            
            if (computerChoice == 1)
            {
                outcome.setText("Outcome: Draw!");
            }
            else if (computerChoice == 2)
            {
                outcome.setText("Outcome: Defeat!");
            }
            else if (computerChoice == 3)
            {
                outcome.setText("Outcome: Victory!");
            }
            else
            {
                System.out.println("ERROR IN LISTENER IF STATEMENTS");
            }
        }
    }
    
    class PaperListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            userChoice = 2;  
            userWeapon.setText("Your Choice: Paper");
            
            computerDecision();
            
            if (computerChoice == 1)
            {
                outcome.setText("Outcome: Victory!");
            }
            else if (computerChoice == 2)
            {
                outcome.setText("Outcome: Draw!");
            }
            else if (computerChoice == 3)
            {
                outcome.setText("Outcome: Defeat!");
            }
            else
            {
                System.out.println("ERROR IN LISTENER IF STATEMENTS");
            }
        }
    }
    
    class ScissorsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            userChoice = 3;
            userWeapon.setText("Your Choice: Scissors");
            
            computerDecision();
            
            if (computerChoice == 1)
            {
                outcome.setText("Outcome: Defeat!");
            }
            else if (computerChoice == 2)
            {
                outcome.setText("Outcome: Victory!");
            }
            else if (computerChoice == 3)
            {
                outcome.setText("Outcome: Draw!");
            }
            else
            {
                System.out.println("ERROR IN LISTENER IF STATEMENTS");
            }
        }
    }
    
    public void computerDecision()
    {
        Random numberGenerator = new Random();
        computerChoice = numberGenerator.nextInt(3) + 1;
        System.out.println(computerChoice);            //for testing
        
        if (computerChoice == 1)
        {
            computerWeapon.setText("Computer Choice: Rock");
        }
        else if (computerChoice == 2)
        {
            computerWeapon.setText("Computer Choice: Paper");
        }
        else if (computerChoice == 3)
        {
            computerWeapon.setText("Computer Choice: Scissors");
        }
        else
        {
            System.out.println("PROBLEM WITH RANDOM GEN");
        }
    }
    
    
    private void addElements()
    {
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        
        
        
        rock = new JButton("Rock");
        ActionListener rockListener = new RockListener();
        rock.addActionListener(rockListener);
        paper = new JButton("Paper");
        ActionListener paperListener = new PaperListener();
        paper.addActionListener(paperListener);
        scissors = new JButton("Scissors");
        ActionListener scissorsListener = new ScissorsListener();
        scissors.addActionListener(scissorsListener);
        
        
        makeChoice = new JLabel("Choose Your Weapon:");
        
        JPanel choicePanel = new JPanel();
        
        
        choicePanel.add(makeChoice);
        choicePanel.add(rock);
        choicePanel.add(paper);
        choicePanel.add(scissors);
        
        containerPanel.add(choicePanel, BorderLayout.NORTH);
        
        JPanel dataPanel = new JPanel();
        
        userWeapon = new JLabel("Your Choice: None");
        computerWeapon = new JLabel("Computer Choice: None");
        outcome = new JLabel("Outcome: None");
        dataPanel.add(userWeapon);
        dataPanel.add(computerWeapon);
        dataPanel.add(outcome);
        containerPanel.add(dataPanel, BorderLayout.CENTER);
        
        
        add(containerPanel);
    }
    
    
    private JButton rock;
    private JButton paper;
    private JButton scissors;
    
    private JLabel makeChoice;
    private JLabel userWeapon;
    private JLabel computerWeapon;
    private JLabel outcome;
    
    private static final int WIDTH = 500;
    private static final int HEIGHT = 175;
    
    private int userChoice;
    private int computerChoice;
}