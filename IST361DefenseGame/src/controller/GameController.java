/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ist361defensegame.Enemy;
import ist361defensegame.Projectile;
import ist361defensegame.Tower;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import view.GameTile;
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
    private int enemyCount;
    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;
    private ArrayList<GameTile> towerTiles;
    boolean waveOver = false;
    
    private File enemyPic1;
    private File enemyPic2;
    private File enemyPic3;
    
    public GameController(){
        gameUI = new GameUI(this);
        gameUI.getInfoPanel().getStartButton().addActionListener(new StartButtonListener());
        gameUI.getInfoPanel().getTower1Button().addActionListener(new TowerListener());
        gameUI.getInfoPanel().getTower2Button().addActionListener(new TowerListener());
        gameUI.getInfoPanel().getTower3Button().addActionListener(new TowerListener());

        currentTower = null;
        
        projectiles = new ArrayList<>();
        towerTiles = new ArrayList<>();
        
        enemyPic1 = new File("alien2.png");
        enemyPic2 = new File("alien.png");
        enemyPic3 = new File("alien3.png");
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

    /**
     * @return the towerTiles
     */
    public ArrayList<GameTile> getTowerTiles() {
        return towerTiles;
    }
    
    class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!waveOver)
                startNewWave(1);
        }
        
    }
    
    public void startNewWave(int level){
        enemyCount = 0;
        int waveEnemyCount = level * 3;

            if(enemies == null){
                enemies = new ArrayList<Enemy>();
            }
             while(enemyCount < waveEnemyCount){
                 
                switch (enemyCount){
                    case 0:
                        enemies.add(new Enemy(175,0,50,50,0, enemyPic1, 100));
                        projectiles.add(new Projectile(25, 25, 25,25, enemies.get(enemyCount))); //The location of this may have to change when towers are added
                        enemyCount ++;
                        break;
                    case 1:
                        enemies.add(new Enemy(155,0,50,50,1, enemyPic2, 100));
                        projectiles.add(new Projectile(450, 25, 25,25, enemies.get(enemyCount)));
                        enemyCount++;
                        break;
                    case 2:
                        enemies.add(new Enemy(195,0,50,50,2, enemyPic3, 100));
                        projectiles.add(new Projectile(25, 300, 25,25, enemies.get(enemyCount)));
                        enemyCount++;
                        break;
                }
                
            }
            //gameUI.getGameBoardPanel.getTimers 
            //gameUI.getGameBoardPanel.getOtherThings
    }
    
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    
    public ArrayList<Projectile> getProjectiles(){
        return projectiles;
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
                setCurrentTower(Tower.getTowerOne());
            }
            else if (e.getSource() == gameUI.getInfoPanel().getTower2Button()) {
                setCurrentTower(Tower.getTowerTwo());            
            } 
            else {
                setCurrentTower(Tower.getTowerThree());
            }
                  
        }
    
    }

}
