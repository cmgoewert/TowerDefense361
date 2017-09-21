/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.NavigationController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cmg5831
 */
public class MenuUI extends JFrame implements ActionListener{
    private NavigationController navCtrl;
    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel difficultyLabel;
    private ArrayList<JButton> difficulty;
    
    private JLabel highScoreLabel;
    
    private JPanel panel;
    
    public MenuUI (NavigationController navCtrl) {
        navCtrl = navCtrl;
        this.setBounds(0, 0, 750, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        nameLabel = new JLabel("Please enter your name: ");
        nameField = new JTextField("");
        
        difficultyLabel = new JLabel("Select a difficulty.");
        difficulty = new ArrayList<>();
        difficulty.add(new JButton("easy"));
        difficulty.add(new JButton("medium"));
        difficulty.add(new JButton("hard"));    
        
        for (JButton button : difficulty) {
            button.addActionListener(this);
        }
        
        highScoreLabel = new JLabel("High score: ");
        
        panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(difficultyLabel);
        for (JButton button : difficulty) {
            panel.add(button);
        }
        panel.add(highScoreLabel);
        panel.setVisible(true);
        this.add(panel);
        this.setVisible(true);
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
}
