/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cmg5831
 */
public class GameTilePanel extends JLabel{
    GameController gameCtrl;
    boolean path;
    
    
    public GameTilePanel(GameController theCtrl, boolean path){
        gameCtrl = theCtrl;
        this.path = path;
        initComponenets();
    }
    
    private void initComponenets() {
        if (!path) {
            ImageIcon icon = new ImageIcon("GameTile.png");
            this.setIcon(icon);
        } else {
            this.setText("path");
        }

    }
}
