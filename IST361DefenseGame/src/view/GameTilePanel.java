/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    boolean hasTower;
    
    
    public GameTilePanel(GameController theCtrl, boolean path){
        gameCtrl = theCtrl;
        this.path = path;
        initComponenets();
    }
    
    private void initComponenets() {
        if (!path) {
            ImageIcon imageIcon = new ImageIcon("GameTile2.png");
            
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            this.setIcon(imageIcon);
        } else {
            this.setText("");
        }
        
        hasTower = false;

    }

    void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean getHasTower() {
        return hasTower;
    }
    
    public void setHasTower(){
        hasTower = true;
    }
    
       
}
