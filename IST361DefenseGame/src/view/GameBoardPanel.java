/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
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


/**
 *
 * @author cmg5831
 */
public class GameBoardPanel extends JPanel{
    ArrayList<GameTilePanel> theTiles = new ArrayList<GameTilePanel>();
    GameController parentCtrl;
    GridLayout theLayout;
    JPanel gamePanel;
    boolean isPresent = false;
    boolean doesExist = false;
    int countThis = 0;
    
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
        JPanel gamePanel = new JPanel();
        add(gamePanel);
        theLayout = new GridLayout(12,12);
        gamePanel.setLayout(theLayout);      
        JLabel[][] boardSquares = new JLabel[12][12];
        int counter = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {               
                isPresent = exists(counter);
                counter++;
                if (isPresent) {
                    boardSquares[i][j] = new GameTilePanel(parentCtrl, true);
                } 
                else {
                    final GameTilePanel theTile = new GameTilePanel(parentCtrl, false);
                    boardSquares[i][j] = new GameTilePanel(parentCtrl, false);
                    boardSquares[i][j] = theTile;
                    boardSquares[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ImageIcon imageIcon = new ImageIcon("alien2.png");          
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);
                        theTile.setIcon(imageIcon);
                    }
            });
                }
                
                    gamePanel.add(boardSquares[i][j]);
            }
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
        /*
        for (int i = 0; i < theLayout.getColumns() * theLayout.getRows(); i++) {
            isPresent = false;
                for(int j = 0; j < pathTiles.length; j++){
                
                    if(i == pathTiles[j])
                    {
                        isPresent = true;
                    }
                    
                }
                    if (isPresent) {
                        GameTilePanel theLabel = new GameTilePanel(parentCtrl, true);
                        theTiles.add(theLabel);
                        this.add(theLabel);
                    } else {
                        GameTilePanel theLabel = new GameTilePanel(parentCtrl, false);
                        
                        theLabel.addActionListener(new java.awt.event.ActionListener(){
                        public void actionPerformed(java.awt.event.ActionEvent evt){
                            gameTileClicked(evt, theLabel);
                        }
                        });
                        theTiles.add(theLabel);
                        this.add(theLabel);
                    }
                
            }
        }    */
/*
        private void gameTileClicked(java.awt.event.ActionEvent evt, GameTilePanel thePanel){
            GameTilePanel theLabel = thePanel;
            ImageIcon icon = new ImageIcon("Tower_1.gif");
            theLabel.setIcon(icon);
            //ContactUI.this.c_control.getContactHelpWindow();
        }   */ 
    
    
    //        for(int i = 0; i < 144; i++){
//            JPanel thePanel = new JPanel();
//            if(i%2== 1){
//                thePanel.setBackground(Color.blue);
//            } else {
//                thePanel.setBackground(Color.black);
//            }
//           
//            this.add(thePanel);
//        }
}
