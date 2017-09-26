/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cmg5831
 */
public class GameTilePanel extends JLabel{
    GameController gameCtrl;
    
    public GameTilePanel(GameController theCtrl){
        gameCtrl = theCtrl;
    }
}
