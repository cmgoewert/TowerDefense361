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
    
    private JLabel highScore;
    
    public MenuUI (NavigationController navCtrl) {
        this.navCtrl = navCtrl;
        this.setVisible(true);
        this.setBounds(0, 0, 750, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        this.nameLabel = new JLabel("Please enter your name: ");
        this.nameField = new JTextField("");
        
        this.difficultyLabel = new JLabel("Select a difficulty.");
        this.difficulty = new ArrayList<>();
        difficulty.add(new JButton("easy"));
        difficulty.add(new JButton("medium"));
        difficulty.add(new JButton("hard"));
        
        for (JButton button : difficulty) {
            button.addActionListener(this);
        }
        
        this.highScore = new JLabel("High score: ");
    }
    
    public void setHighScore(String score) {
        highScore.setText("High score : " + score);
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
