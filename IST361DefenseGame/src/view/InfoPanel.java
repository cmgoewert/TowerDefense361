/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author reesmcdevitt
 */
public class InfoPanel extends JPanel{
    
    private JLabel nameLabel;
    private JLabel scoreLabel;
    private JLabel moneyLabel;
    private JLabel healthLabel;
    private JLabel difficultyLabel;
    private JLabel tower1Label;
    private JLabel tower2Label;
    private JLabel tower3Label;
    
    public InfoPanel(){
        initComponents();
    }
    
    private void initComponents(){
        nameLabel.setText("Name: ");
        scoreLabel.setText("Score: ");
        moneyLabel.setText("Money: ");
        healthLabel.setText("Health: ");
        difficultyLabel.setText("Difficulty: ");
        tower1Label.setText("Homework Tosser: ");
        tower2Label.setText("Eraser Cannon: ");
        tower3Label.setText("Paper Football Launcher: ");
        
        this.add(nameLabel);
        this.add(scoreLabel);
        this.add(moneyLabel);
        this.add(healthLabel);
        this.add(difficultyLabel);
        this.add(tower1Label);
        this.add(tower2Label);
        this.add(tower3Label);

       
    }
}
