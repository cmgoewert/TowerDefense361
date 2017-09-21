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
    
    public GameBoardPanel(GameController theCtrl){
        parentCtrl = theCtrl;
        initComponents();
    }
    
    private void initComponents(){
        theLayout = new GridLayout(12,12);
        this.setLayout(theLayout);
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
