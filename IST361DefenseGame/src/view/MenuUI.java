/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.NavigationController;
import java.awt.Color;
import java.awt.Graphics;
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
    private NavigationController navCtrl;
    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel difficultyLabel;
    private ArrayList<JButton> difficulty;
    
    private JLabel highScoreLabel;
    
    public MenuUI (NavigationController navCtrl) {
        this.navCtrl = navCtrl;
        
        setLayout(null);
        
        nameLabel = new JLabel("Please enter your name: ");
        nameLabel.setForeground(Color.WHITE);
        nameField = new JTextField("");
        nameField.setColumns(12);
        
        difficultyLabel = new JLabel("Select a difficulty.");
        difficultyLabel.setForeground(Color.WHITE);
        difficulty = new ArrayList<>();
        difficulty.add(new JButton("easy"));
        difficulty.add(new JButton("medium"));
        difficulty.add(new JButton("hard"));    
        
        highScoreLabel = new JLabel("");
        highScoreLabel.setForeground(Color.WHITE);
        
        add(nameLabel);
        add(nameField);
        add(difficultyLabel);
        //TODO: implement bounds
        //nameLabel.setBounds(50, 700, 30, 20);
        //nameField.setBounds(80, 700, 30, 20);
        for (JButton button : difficulty) {
            button.addActionListener(this);
            //button.setBounds(50, 800, 100, 50);
            add(button);
        }
        add(highScoreLabel);
       
        setVisible(true);
    }
    
    public void setHighScore(String score) {
        highScoreLabel.setText("High score : " + score);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton) e.getSource();
        
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
