/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import javax.swing.JFrame;

/**
 *
 * @author cmg5831
 */
public class GameUI extends JFrame{
    GameController gameCtrl;
    private GameBoardPanel theGameBoard;
    
    public GameUI (GameController gameCtrl) {
        this.gameCtrl = gameCtrl;
        this.setVisible(true);
        this.setBounds(0, 0, 750, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        initComponenets();
    }
  
    private void initComponenets() {
        theGameBoard = new GameBoardPanel(gameCtrl);

        this.add(theGameBoard);
    }
}
