/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
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
    private JButton tower1Button;
    private JButton tower2Button;
    private JButton tower3Button;
    
    
    public InfoPanel(){
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        nameLabel = new JLabel("Name: ");
        scoreLabel = new JLabel("Score: ");
        moneyLabel = new JLabel("Money: ");
        healthLabel = new JLabel("Health: ");
        difficultyLabel = new JLabel("Difficulty: ");
        tower1Label = new JLabel("Homework Tosser: ");
        tower2Label = new JLabel("Eraser Cannon: ");
        tower3Label = new JLabel("Paper Football Launcher: ");
        tower1Button = new JButton("Tower1");
        tower2Button = new JButton("Tower2");
        tower3Button = new JButton("Tower3");

        c.gridx = 0;
        c.gridy = 0;
        this.add(nameLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        this.add(scoreLabel, c);
        c.gridx = 2;
        c.gridy = 0;
        this.add(moneyLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        this.add(healthLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(difficultyLabel, c);
        c.gridx = 2;
        c.gridy = 1;
        this.add(tower1Label, c);
        c.gridx = 1;
        c.gridy = 3;
        this.add(tower1Button, c);
        c.gridx = 1;
        c.gridy = 4;
        this.add(tower2Label, c);
        c.gridx = 1;
        c.gridy = 5;
        this.add(tower2Button, c);
        c.gridx = 1;
        c.gridy = 6;
        this.add(tower3Label, c);
        c.gridx = 1;
        c.gridy = 7;
        this.add(tower3Button, c);
        
    }
}
