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
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
    int countThis = 0;
    
    int pathTiles[]={3,4,15,16,27,28,29,30,31,32,33,39,40,41,42,43,44,45,56,57,68,69,80,81,92,93,96,97,98,99,100,101,102,103,104,105,108,109,110,111,112,113,114,115,116,117};
    int size = pathTiles.length;
    
    public GameBoardPanel(GameController theCtrl){
        parentCtrl = theCtrl;
        initComponents();
    }
    
    private void initComponents(){
        theLayout = new GridLayout(12,12);
        this.setLayout(theLayout);
   
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
                        theTiles.add(theLabel);
                        this.add(theLabel);
                    }
                
            }
        }        
    
    
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
