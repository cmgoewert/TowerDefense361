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
import javax.swing.Timer;
import view.GameTile;
import view.GameUI;
import view.InfoPanel;

/**
 *
 * @author cmg5831
 */
public class GameController implements ActionListener{
    private GameUI gameUI;
    private InfoPanel infoPanel;
    private Tower currentTower;
    private int[] towerInfo;
    private boolean towerPlaceable = false;
    private int enemyCount;
    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Tower> towers;
    boolean waveOver;
    private Timer waveTimer;
    private int waveEnemyCount;
    private int currentLevel;
    private int lives;
    private int money = 200;
    private boolean startFlag = false;
    
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
        currentLevel = 1;
        
        waveOver = true;
        
        projectiles = new ArrayList<>();
        towers = new ArrayList<>();
        
        enemyPic1 = new File("alien2.png");
        enemyPic2 = new File("alien.png");
        enemyPic3 = new File("alien3.png");
        
        lives = 20;
        
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
    
    public boolean getWaveOver(){
        return waveOver;
    }

    /**
     * @return the towers
     */
    public ArrayList<Tower> getTowerTiles() {
        return towers;
    }

    /**
     * @return the towerPlaceable
     */
    public boolean isTowerPlaceable() {
        return towerPlaceable;
    }

    /**
     * @param towerPlaceable the towerPlaceable to set
     */
    public void setTowerPlaceable(boolean towerPlaceable) {
        this.towerPlaceable = towerPlaceable;
    }
    
    class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(waveOver){
                startNewWave();
            }
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(enemyCount < waveEnemyCount){
            addEnemy(currentLevel * 100, 0 + (int)(Math.random() * ((2 - 0) + 1)));
            enemyCount++;
            waveOver = false;
        } else {
            waveTimer.stop();
        }
        
    }
    
    public void decrementHealth(){
        lives--;
        if(lives == 0){
            gameUI.gameOver(currentLevel);
            gameUI.revalidate();
            gameUI.repaint();
        }
        System.out.println("Lives remaining: " + lives);
        
        //infopanel needs to be updated here with lives left
    }
    
    public void addProj() {
        if(startFlag == true) {
            for(Enemy enemy : enemies){
                for(Tower tower : towers){
                    int diffX = Math.abs(enemy.x - tower.getX());
                    int diffY = Math.abs(enemy.y - tower.getY());

                    if(diffX < tower.getRadius() && diffY < tower.getRadius()){
                        projectiles.add(new Projectile(tower, tower.getX(), tower.getY(), 25,25, enemy));
                    }  
                }   
            }
        }
    }
    
    private void addEnemy(int health, int path){
        switch (path){
                    case 0:
                        enemies.add(new Enemy(175,0,50,50,0, enemyPic1, health));
                        break;
                    case 1:
                        enemies.add(new Enemy(155,0,50,50,1, enemyPic2, health));
                        break;
                    case 2:
                        enemies.add(new Enemy(195,0,50,50,2, enemyPic3, health));                       
                        break;
                }
    }
    
    public void endWave(){
        System.out.println("called endwave");
        //startFlag = false;
        waveOver = true;
        money += currentLevel * 200;
        
    }

    public void startNewWave() {
        startFlag = true;
        enemyCount = 0;
        waveEnemyCount = currentLevel * 3;

        if (enemies == null) {
            enemies = new ArrayList<Enemy>();
        }
        
        waveTimer = new Timer(400, this);
        waveTimer.start();
        waveOver = false;
        
        currentLevel++;
    }
    
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }
    
    public void setEnemies(ArrayList<Enemy> newEnemies){
        this.enemies = newEnemies;
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
    public void setMoney() {
            money = money - towerInfo[0];
        }
    //TODO: Logic for when certain tower is selected
    class TowerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == gameUI.getInfoPanel().getTower1Button()) {               
                towerInfo = gameUI.getTheGameBoard().getTowerInfo1();
                if (money >= towerInfo[0]) {
                    setCurrentTower(currentTower.getTowerOne());
                    System.out.println(money);
                    setTowerPlaceable(true);
                    //gameUI.getInfoPanel().setMoneyLabel(money);
                } else {
                    System.out.println("not enough money");
                    setTowerPlaceable(false);
                } 
            }
            else if (e.getSource() == gameUI.getInfoPanel().getTower2Button()) {
                towerInfo = gameUI.getTheGameBoard().getTowerInfo2();
                if (money >= towerInfo[0]) {
                    setCurrentTower(currentTower.getTowerTwo()); 
                    System.out.println(money);
                    setTowerPlaceable(true);
                } else {
                    System.out.println("not enough money");
                    setTowerPlaceable(false);
                }           
            } 
            else {
                towerInfo = gameUI.getTheGameBoard().getTowerInfo3();
                if (money >= towerInfo[0]) {
                    setCurrentTower(currentTower.getTowerThree()); 
                    System.out.println(money);
                    setTowerPlaceable(true);
                } else {
                    System.out.println("not enough money");
                    setTowerPlaceable(false);
                }  
            }
            
        }
        
        
    }

}
