/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    private JLabel emptyLabel;
    private JButton startButton;
    private int score;
    private int health;
    private int money;
    private String userName;
   
    
    public InfoPanel(String userName){
        this.userName = userName;
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(3,3,3,3);
        setScore(0);

        
        moneyLabel = new JLabel();
        moneyLabel.setPreferredSize(new Dimension(100,20));
        setMoneyLabel(1000);
        setNameLabel(new JLabel("Name: " + userName));
        setEmptyLabel(new JLabel(" "));
        setScoreLabel(new JLabel("Score: " + getScore()));        
        //setHealthLabel(new JLabel("Health: " + getHealth()));
        healthLabel = new JLabel("Health: " + Integer.toString(getHealth()));
        setDifficultyLabel(new JLabel("Difficulty: "));
        setTower1Label(new JLabel("Tower 1 ($100): "));
        setTower2Label(new JLabel("Tower 2 ($150): "));
        setTower3Label(new JLabel("Tower 3 ($200): "));
        setTower1Button(new JButton("Tower1"));
        setTower2Button(new JButton("Tower2"));
        setTower3Button(new JButton("Tower3"));
        startButton = new JButton("Next Wave");

        c.gridx = 0;
        c.gridy = 0;
        this.add(getNameLabel(), c);
        c.gridx = 0;
        c.gridy = 1;
        this.add(getScoreLabel(), c);
        c.gridx = 0;
        c.gridy = 2;
        this.add(getMoneyLabel(), c);
        c.gridx = 0;
        c.gridy = 3;
        this.add(healthLabel, c);
        c.gridx = 0;
        c.gridy = 4;
        this.add(getDifficultyLabel(), c);
        c.gridx = 0;
        c.gridy = 5;
        this.add(getEmptyLabel(),c);
        c.gridx = 0;
        c.gridy = 6;
        this.add(getTower1Label(), c);
        c.gridx = 0;
        c.gridy = 7;
        this.add(getTower1Button(), c);
        c.gridx = 0;
        c.gridy = 8;
        this.add(getTower2Label(), c);
        c.gridx = 0;
        c.gridy = 9;
        this.add(getTower2Button(), c);
        c.gridx = 0;
        c.gridy = 10;
        this.add(getTower3Label(), c);
        c.gridx = 0;
        c.gridy = 11;
        this.add(getTower3Button(), c);
        c.gridx = 0;
        c.gridy = 12;
        this.add(getEmptyLabel(),c);
        c.gridx = 0;
        c.gridwidth = 2;   
        c.gridy = 13;
        this.add(getStartButton(), c);
    }

    /**
     * @return the nameLabel
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * @param nameLabel the nameLabel to set
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * @return the scoreLabel
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    /**
     * @param scoreLabel the scoreLabel to set
     */
    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    /**
     * @return the moneyLabel
     */
    public JLabel getMoneyLabel() {
        return moneyLabel;
    }

    /**
     * @param moneyLabel the moneyLabel to set
     */
    public void setMoneyLabel(int money) {
        moneyLabel.setText("Money: $" + String.valueOf(money));
    }

    /**
     * @return the healthLabel
     */
    public JLabel getHealthLabel() {
        return healthLabel;
    }

    /**
     * @param healthLabel the healthLabel to set
     */
    public void setHealthLabel(int health) {
        healthLabel.setText("Health: " + String.valueOf(health));
    }

    /**
     * @return the difficultyLabel
     */
    public JLabel getDifficultyLabel() {
        return difficultyLabel;
    }

    /**
     * @param difficultyLabel the difficultyLabel to set
     */
    public void setDifficultyLabel(JLabel difficultyLabel) {
        this.difficultyLabel = difficultyLabel;
    }

    /**
     * @return the tower1Label
     */
    public JLabel getTower1Label() {
        return tower1Label;
    }

    /**
     * @param tower1Label the tower1Label to set
     */
    public void setTower1Label(JLabel tower1Label) {
        this.tower1Label = tower1Label;
    }
    
    public void setEmptyLabel(JLabel emptyLabel) {
        this.emptyLabel = emptyLabel;
    }

    public JLabel getEmptyLabel() {
        return emptyLabel;
    }
    /**
     * @return the tower2Label
     */
    public JLabel getTower2Label() {
        return tower2Label;
    }

    /**
     * @param tower2Label the tower2Label to set
     */
    public void setTower2Label(JLabel tower2Label) {
        this.tower2Label = tower2Label;
    }

    /**
     * @return the tower3Label
     */
    public JLabel getTower3Label() {
        return tower3Label;
    }

    /**
     * @param tower3Label the tower3Label to set
     */
    public void setTower3Label(JLabel tower3Label) {
        this.tower3Label = tower3Label;
    }

    /**
     * @return the tower1Button
     */
    public JButton getTower1Button() {
        return tower1Button;
    }

    /**
     * @param tower1Button the tower1Button to set
     */
    public void setTower1Button(JButton tower1Button) {
        this.tower1Button = tower1Button;
    }

    /**
     * @return the tower2Button
     */
    public JButton getTower2Button() {
        return tower2Button;
    }

    /**
     * @param tower2Button the tower2Button to set
     */
    public void setTower2Button(JButton tower2Button) {
        this.tower2Button = tower2Button;
    }

    /**
     * @return the tower3Button
     */
    public JButton getTower3Button() {
        return tower3Button;
    }

    /**
     * @param tower3Button the tower3Button to set
     */
    public void setTower3Button(JButton tower3Button) {
        this.tower3Button = tower3Button;
    }

    /**
     * @return the startButton
     */
    public JButton getStartButton() {
        return startButton;
    }
   
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
