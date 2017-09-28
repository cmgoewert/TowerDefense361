/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.NavigationController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cmg5831
 */
public class MenuUI extends JPanel implements ActionListener{
    private NavigationController navController;
    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel difficultyLabel;
    private ArrayList<JButton> difficulty;
    
    private JLabel highScoreLabel;
    
    public MenuUI (NavigationController navController) {
        this.navController = navController;
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        
        gb.gridwidth = 1;
        gb.gridheight = 1;
        gb.weightx = .5;
        gb.weighty = .5;
        gb.fill = GridBagConstraints.NONE;
        gb.ipady = 20;
        
        
        //setLayout(null);
        
        nameLabel = new JLabel("Please enter your name: ");
        nameLabel.setForeground(Color.WHITE);
        gb.gridx = 1;
        gb.gridy = 1;
        gb.insets = new Insets(0,200,0,0);
        add(nameLabel, gb);
        
        nameField = new JTextField("");
        gb.gridx = 2;
        gb.gridy = 1;
        gb.insets = new Insets(0,200,0,0);
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(nameField, gb);
        
        
        gb.fill = GridBagConstraints.NONE;
        
        highScoreLabel = new JLabel("Score");
        highScoreLabel.setForeground(Color.WHITE);
        gb.gridx = 3;
        gb.gridy = 1;
        gb.insets = new Insets(0,200,0,0);
        add(highScoreLabel, gb);
        
        difficultyLabel = new JLabel("Select a difficulty.");
        difficultyLabel.setForeground(Color.WHITE);
        gb.gridx = 1;
        gb.gridy = 2;
        gb.insets = new Insets(0,0,10,0);
        add(difficultyLabel, gb);
        
        difficulty = new ArrayList<>();
        difficulty.add(new JButton("easy"));
        difficulty.add(new JButton("medium"));
        difficulty.add(new JButton("hard"));    
        
        gb.gridx = 2;
        gb.gridy = 2;
        gb.insets = new Insets(0,0,10,0);
        for (JButton button : difficulty) {
            button.addActionListener(this); 
            add(button, gb);
            gb.gridx++;
        }
        
        setVisible(true);
    }
    
    public void setHighScore(String score) {
        highScoreLabel.setText("High score : " + score);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton) e.getSource();
        //TODO: add difficulty functionality
        navController.startGame();
        if (eventSource == difficulty.get(0)) { //easy difficulty
            //TODO pass diff to nav controller
        }
        else if (eventSource == difficulty.get(1)) { //medium difficulty
            
        }
        else { //hard difficulty
            
        }
        
        //when diff passed to navController, navController should start game
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
        g.drawImage(background, 0, 0, this);
    }
}
