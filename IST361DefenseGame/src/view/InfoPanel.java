/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    
    
    public InfoPanel(){
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(3,3,3,3);
        
        setNameLabel(new JLabel("Name: "));
        setEmptyLabel(new JLabel(" "));
        setScoreLabel(new JLabel("Score: "));
        setMoneyLabel(new JLabel("Money: "));
        setHealthLabel(new JLabel("Health: "));
        setDifficultyLabel(new JLabel("Difficulty: "));
        setTower1Label(new JLabel("Homework Tosser: "));
        setTower2Label(new JLabel("Eraser Cannon: "));
        setTower3Label(new JLabel("Paper Football Launcher: "));
        setTower1Button(new JButton("Tower1"));
        setTower2Button(new JButton("Tower2"));
        setTower3Button(new JButton("Tower3"));

        c.gridx = 0;
        c.gridy = 0;
        this.add(getNameLabel(), c);
        c.gridx = 1;
        c.gridy = 0;
        this.add(getScoreLabel(), c);
        c.gridx = 0;
        c.gridy = 1;
        this.add(getMoneyLabel(), c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(getHealthLabel(), c);
        c.gridx = 0;
        c.gridy = 2;
        this.add(getDifficultyLabel(), c);
        c.gridx = 0;
        c.gridy = 3;
        this.add(getEmptyLabel(),c);
        c.gridx = 0;
        c.gridy = 4;
        this.add(getTower1Label(), c);
        c.gridx = 1;
        c.gridy = 4;
        this.add(getTower1Button(), c);
        c.gridx = 0;
        c.gridy = 5;
        this.add(getTower2Label(), c);
        c.gridx = 1;
        c.gridy = 5;
        this.add(getTower2Button(), c);
        c.gridx = 0;
        c.gridy = 6;
        this.add(getTower3Label(), c);
        c.gridx = 1;
        c.gridy = 6;
        this.add(getTower3Button(), c);
        
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
    public void setMoneyLabel(JLabel moneyLabel) {
        this.moneyLabel = moneyLabel;
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
    public void setHealthLabel(JLabel healthLabel) {
        this.healthLabel = healthLabel;
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
}
