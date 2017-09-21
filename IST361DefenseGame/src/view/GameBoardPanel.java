/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    
    public GameBoardPanel(){
        
        this.setLayout(new GridLayout(12,12));
        
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
    
    
}
