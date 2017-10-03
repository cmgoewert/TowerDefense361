/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ist361defensegame.Tower;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import view.GameUI;
import view.InfoPanel;

/**
 *
 * @author cmg5831
 */
public class GameController {
    private GameUI gameUI;
    private InfoPanel infoPanel;
    private Tower currentTower;
    
    public GameController(){
        gameUI = new GameUI(this);
        gameUI.getInfoPanel().getStartButton().addActionListener(new StartButtonListener());
        gameUI.getInfoPanel().getTower1Button().addActionListener(new TowerListener());
        gameUI.getInfoPanel().getTower2Button().addActionListener(new TowerListener());
        gameUI.getInfoPanel().getTower3Button().addActionListener(new TowerListener());

        currentTower = null;
    }

    /**
     * @return the currentTower
     */
    public Tower getCurrentTower() {
        return currentTower;
    }

    /**
     * @param currentTower the currentTower to set
     */
    public void setCurrentTower(Tower currentTower) {
        this.currentTower = currentTower;
    }
    
    class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next wave starts"); 
            //gameUI.getGameBoardPanel.getTimers 
            //gameUI.getGameBoardPanel.getOtherThings
        }
        
    }
    
    //TODO: Logic for when it increases when but is killed, decreses when bug is
    // leaves the screen
    class ScoreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //This infopanel will problaby need to be gameUI.getInfoPanel instead
            infoPanel.getScoreLabel().setText("Test"); //new Score on action
        }
    
    }
    
    //TODO: Logic for when it decreses when bug is leaves the screen
    class HealthListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //This infopanel will problaby need to be GameUI.getInfoPanel instead
            infoPanel.getHealthLabel().setText("Test");
        }
    
    }
    
    //TODO: Logic for when it increases when but is killed, decreses when
    // tower is placed
    class MoneyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //This infopanel will problaby need to be GameUI.getInfoPanel instead
            infoPanel.getMoneyLabel().setText("Test");
        }
    
    }
    //TODO: Logic for when certain tower is selected
    class TowerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == gameUI.getInfoPanel().getTower1Button()) {
                setCurrentTower(Tower.getHomeworkTosser());
            }
            else if (e.getSource() == gameUI.getInfoPanel().getTower2Button()) {
                setCurrentTower(Tower.getEraserCannon());            
            } 
            else {
                setCurrentTower(Tower.getPaperFootballLauncher());
            }
                  
        }
    
    }

}
