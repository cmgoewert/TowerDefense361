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
    ArrayList<GameTilePanel> theTiles = new ArrayList<GameTilePanel>();
    ArrayList<Enemy> enemies;
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
    
    //Tower and Projectile Stuff
    ArrayList<Point> towerLocations = new ArrayList<>();
    ArrayList<Projectile> projectiles;
    
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
        
    }
    
    private void initComponents(){
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        enemies = new ArrayList<Enemy>();
        projectiles = new ArrayList<>();
        
//        JLabel background = new JLabel(new ImageIcon("pathBackground.png"));
//        this.setContentPane(background);
        
        enemyPic1 = new File("alien2.png");
        enemyPic2 = new File("alien.png");
        enemyPic3 = new File("alien3.png");
        
        theLayout = new GridLayout(12, 12);
        this.setLayout(theLayout);
        JLabel[][] boardSquares = new JLabel[12][12];
        int counter = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                isPresent = exists(counter);
                counter++;
                if (isPresent) {
                    boardSquares[i][j] = new GameTilePanel(parentCtrl, true);
                } else {
                    final GameTilePanel theTile = new GameTilePanel(parentCtrl, false);
                    boardSquares[i][j] = new GameTilePanel(parentCtrl, false);
                    boardSquares[i][j] = theTile;
                    boardSquares[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getHomeworkTosser()) {
                                ImageIcon imageIcon = new ImageIcon("Tower_1.gif");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                                imageIcon = new ImageIcon(newimg);
                                theTile.setIcon(imageIcon);
                                theTile.setHasTower();
                                
                                Point towerLoc = new Point(theTile.getX()+25, theTile.getY()+25);
                                towerLocations.add(towerLoc);
                                System.out.println(towerLocations);

                            } 
                            if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getEraserCannon()) {
                                ImageIcon imageIcon = new ImageIcon("Tower_2.gif");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                                imageIcon = new ImageIcon(newimg);
                                theTile.setIcon(imageIcon);
                                theTile.setHasTower();
                                
                                Point towerLoc = new Point(theTile.getX()+25, theTile.getY()+25);
                                towerLocations.add(towerLoc);
                                System.out.println(towerLocations);

                            }
                            if (!theTile.getHasTower() && parentCtrl.getCurrentTower() == tower.getPaperFootballLauncher()) {
                                ImageIcon imageIcon = new ImageIcon("Tower_3.gif");
                                Image image = imageIcon.getImage();
                                Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                                imageIcon = new ImageIcon(newimg);
                                theTile.setIcon(imageIcon);
                                theTile.setHasTower();
                                
                                Point towerLoc = new Point(theTile.getX()+25, theTile.getY()+25);
                                towerLocations.add(towerLoc);
                                System.out.println(towerLocations);

                            }else {
                                System.out.println("already has a tower!");
                            }

                        }
                    });
                }
                this.add(boardSquares[i][j]);
            }
        }
        gameTimer = new Timer(1000 / 50, this);
        
        enemyTimer = new Timer(4000 / 50, this);
        enemyTimer.setDelay(4000);
        
        gameTimer.start();
        enemyTimer.start();
        
        projTimer = new Timer(1000, this);
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
        //page.drawImage(enemyScaled, 200, 50, null);
        for(Enemy enemy : enemies){           
            enemy.update();
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
        
        
        for(Projectile proj : projectiles) {
            
            proj.draw(g);
            
        }
        
      }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        //The game world updates when the GameTimer event fires
        if (o == gameTimer) {
            for(Enemy enemy : enemies){
                enemy.update();
            }  
            for(Projectile proj : projectiles) {
                proj.update();
            }
            this.repaint();
            //physics.update();   
        }
        
        Object i = e.getSource();
        
         // TODO: When the Enemy's timer fires, create a new Enemy that will persue the player!
        if(i == enemyTimer){
            while(enemyCount < 3){
                switch (enemyCount){
                    case 0:
                        enemies.add(new Enemy(175,0,50,50,0, enemyPic1));
                        projectiles.add(new Projectile(25, 25, 25,25, enemies.get(enemyCount)));
                        enemyCount ++;
                        break;
                    case 1:
                        enemies.add(new Enemy(155,0,50,50,1, enemyPic2));
                        enemyCount++;
                        break;
                    case 2:
                        enemies.add(new Enemy(195,0,50,50,2, enemyPic3));
                        enemyCount++;
                        break;
                }
                
             ;   
            }
            
            //155(path 1),175 (path 0),195 (path 2) are the starting positions
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
}
