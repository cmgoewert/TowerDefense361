/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import ist361defensegame.Enemy;
import ist361defensegame.Projectile;
import ist361defensegame.Tower;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Timer;


/**
 *
 * @author cmg5831
 */
public class GameBoardPanel extends JPanel  implements ActionListener{
    ArrayList<GameTile> theTiles = new ArrayList<GameTile>();
    LinkedList<Enemy> enemies;
    GameController parentCtrl;
    int enemyCount = 0;
    GridLayout theLayout;
    BufferedImage enemy1;
    BufferedImage projImage;
    //JPanel gamePanel;
    boolean isPresent = false;
    boolean doesExist = false;
    private Timer gameTimer;
    private Timer enemyTimer;
    private Timer projTimer;
    int countThis = 0;
    Tower tower;
    int positionCount = 0;
    boolean reordered = false;
    ArrayList<JLabel> boardTiles = null;
    
    //Tower and Projectile Stuff
    ArrayList<GameTile> towerTiles = new ArrayList<>();
    ImageIcon towerImage1;
    ImageIcon towerImage2;
    ImageIcon towerImage3;
    private int[] towerInfo1 = {100,2,100};
    private int[] towerInfo2 = {150,1,150};
    private int[] towerInfo3 = {300,1,200};
    Component original = null;
    
    private File enemyPic1;
    private File enemyPic2;
    private File enemyPic3;
    
    static int pathTiles[]={3,4,15,16,27,28,29,30,31,32,33,39,40,41,42,43,44,45,56,57,68,69,80,81,92,93,96,97,98,99,100,101,102,103,104,105,108,109,110,111,112,113,114,115,116,117};
    static int pathTiles2[][] = {{0,3},{0,4},{1,3},{1,4},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8},{2,9},{3,3},{3,4},
            {3,5},{3,6},{3,7},{3,8},{3,9},{4,8},{4,9},{5,8},{5,9},{6,8},{6,9},{7,8},{7,9},{8,0},{8,1},
            {8,2},{8,3},{8,4},{8,5},{8,6},{8,7},{8,8},{8,9},{9,0},{9,1},
            {9,2},{9,3},{9,4},{9,5},{9,6},{9,7},{9,8},{9,9}};
    static int pathTiles3[][] = {{0,1,2,3,4,5,6,7,8,9},{0,1,2,3,4,5,6,7,8,9}};
    int size = pathTiles.length;
    
    public GameBoardPanel(GameController theCtrl){
        parentCtrl = theCtrl;
        initComponents();
        //original = this.getComponent(143);
    }
    
    private void initComponents(){
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        enemies = new LinkedList<Enemy>();
        
        enemyPic1 = new File("alien2.png");
        enemyPic2 = new File("alien.png");
        enemyPic3 = new File("alien3.png");
        towerImage1 = new ImageIcon("tower1.png");
        towerImage2 = new ImageIcon("tower2.png");
        towerImage3 = new ImageIcon("tower3.png");
        
        
        theLayout = new GridLayout(12, 12);
        this.setLayout(theLayout);
        boardTiles = new ArrayList<JLabel>();
        int counter = 0;
        
        for (counter = 0; counter < 144; counter++){
            isPresent = exists(counter);
            if(isPresent){
                boardTiles.add(new GameTile(parentCtrl, true));
            }
            else {
                boardTiles.add(new GameTile(parentCtrl, false));
                GameTile theTile = (GameTile) boardTiles.get(counter);
                boardTiles.get(counter).addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getTowerOne() && parentCtrl.isTowerPlaceable()) {
                                placeTower(theTile, towerImage1, getTowerInfo1());
                                
                            } else if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getTowerTwo() && parentCtrl.isTowerPlaceable()) {
                                placeTower(theTile, towerImage2, getTowerInfo2());

                            } else if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getTowerThree() && parentCtrl.isTowerPlaceable()) {
                                placeTower(theTile, towerImage3, getTowerInfo3());

                            } else {
                                System.out.println("Not enough money or already has a tower!");
                            }

                        }
                    });
            }
            this.add(boardTiles.get(counter));
        }

        gameTimer = new Timer(1000 / 50, this);
        projTimer = new Timer(400, this); //Change tower fire rate
        
        enemyTimer = new Timer(4000 / 50, this);
        enemyTimer.setDelay(4000);
        
        getGameTimer().start();
        enemyTimer.start();
        projTimer.start();
        
        
        this.repaint();
    }
    
    public void paintComponent(Graphics page) {
        BufferedImage img = null;
        Image enemyScaled = null;
        
        try {
            enemy1 = ImageIO.read(new File("alien2.png"));
            enemyScaled = enemy1.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            
            img = ImageIO.read(new File("pathBackground6.png"));
            //img = ImageIO.read(new File("alien2.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(GameBoardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        super.paintComponent(page);
        
        page.drawImage(img, 0, 0, null);
        LinkedList<Enemy> enemies = parentCtrl.getEnemies();
        if(enemies == null){
            enemies = new LinkedList<Enemy>();
        }
        //page.drawImage(enemyScaled, 200, 50, null);
        for(Enemy enemy : enemies){           
            //enemy.update();
            enemy.draw(page);
        }
              
    }
    
    //Paints over tiles
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        
        Image projScaled = null;
        
        try {

            projImage = ImageIO.read(new File("alien2.png"));
            projScaled = projImage.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
               
        } catch (IOException ex) {
            Logger.getLogger(GameBoardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        for(Projectile proj : parentCtrl.getProjectiles()) {  
            proj.draw(g);          
        }
        
      }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        enemies = parentCtrl.getEnemies();
        if(enemies == null){
            enemies = new LinkedList<Enemy>();
        }
        Object o = e.getSource();

        //The game world updates when the GameTimer event fires
        if (o == getGameTimer()) {
            for(int i = 0; i < enemies.size(); i++){
                if(enemies.get(i).decrementUsersLife()){
                    enemies.remove(i);
                    System.out.println("removed enemy");
                    parentCtrl.decrementHealth();
                    parentCtrl.setEnemies(enemies);
                    reordered = true;
                } else {
//                    if(reordered){
//                        System.out.println(original.equals(this.getComponent(143)));
//                    }
                    System.out.println("Enemy"+i+" Health: "+ enemies.get(i).getHealth());
                    enemies.get(i).update();
                }   
            }
            
            for(int i = 0; i < parentCtrl.getProjectiles().size(); i++) { 
                
                
                parentCtrl.getProjectiles().get(i).update();
                
                
                if(parentCtrl.getProjectiles().get(i).getFrame().intersects(parentCtrl.getProjectiles().get(i).getEnemy().getFrame())){
                    parentCtrl.getProjectiles().get(i).getEnemy().decrementEnemyHealth(20);//parentCtrl.getProjectiles().get(i).getTower().getStrength());
                   
                    System.out.println(parentCtrl.getProjectiles().get(i).getEnemy().getHealth());
                    if(parentCtrl.getProjectiles().get(i).getEnemy().getHealth() == 0) {
                        if(parentCtrl.getEnemies().size() != 0){
                            parentCtrl.getEnemies().remove(0);
                            System.out.println("called remove enemy");
                        }
                        
                      
                    }
                    parentCtrl.getProjectiles().remove(i);
                }
            }

            this.repaint();
            this.revalidate();
            
            if(enemies.isEmpty() && !parentCtrl.getWaveOver()){
                parentCtrl.endWave();
            }
            //physics.update();   
        } else if (o == projTimer){
            parentCtrl.addProj();
           
            
        }
    }

    private static boolean exists(int count){
        boolean exists = false;
        int check = count;       
        for(int i = 0; i < pathTiles.length; i++){
            if(pathTiles[i] == check){
                exists = true;
            }          
        }       
        return exists;
    }  
    
    public void placeTower(GameTile theTile, ImageIcon towerImage, int[] data) {
        
        Tower tower = new Tower(data[0],data[1],data[2]);
        tower.setIcon(towerImage);
        tower.setSize(50, 50);
        tower.setLocation(theTile.getLocation());
        int location = 0;
        for(int i = 0; i < boardTiles.size(); i++){
            if(theTile.equals((GameTile) boardTiles.get(i))){
                location = i;
            }
        }
        remove(theTile);
        add(tower, location);
        
        parentCtrl.getTowerTiles().add(tower);
        parentCtrl.setTowerPlaceable(false);
        parentCtrl.setMoney();
    }

    public Timer getGameTimer() {
        return gameTimer;
    }

    public int[] getTowerInfo1() {
        return towerInfo1;
    }

    public int[] getTowerInfo2() {
        return towerInfo2;
    }

    public int[] getTowerInfo3() {
        return towerInfo3;
    }
}
