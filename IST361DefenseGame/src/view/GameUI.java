/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cmg5831
 */
public class GameUI extends JFrame{
    GameController gameCtrl;
    private GameBoardPanel theGameBoard;
    private InfoPanel infoPanel;
    
    public GameUI (GameController gameCtrl) {
        this.gameCtrl = gameCtrl;
        this.setVisible(true);
        this.setBounds(0, 0, 750, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        initComponenets();
    }
  
    private void initComponenets() {
        theGameBoard = new GameBoardPanel(gameCtrl);
        theGameBoard.setSize(600,600);
        infoPanel = new InfoPanel();
        
        this.setLayout(new BorderLayout());
        this.add(getInfoPanel(), BorderLayout.EAST);
        this.add(theGameBoard, BorderLayout.CENTER);
        this.pack();
    }

    /**
     * @return the infoPanel
     */
    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
    
    public void gameOver(int level){
        System.out.println("game over called");
        this.remove(theGameBoard);
        JLabel gameOver = new JLabel("GAME OVER!!!");
        gameOver.setForeground(Color.red);
        gameOver.setFont(new Font("Courier New", Font.BOLD, 36));
        gameOver.setHorizontalAlignment(JLabel.CENTER);
        JLabel results = new JLabel("You made it to: Level " + (level -1));
        results.setVerticalAlignment(JLabel.TOP);
        results.setVerticalTextPosition(JLabel.TOP);
        results.setHorizontalAlignment(JLabel.CENTER);
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new BorderLayout());
        gameOverPanel.add(gameOver, BorderLayout.CENTER);
        gameOverPanel.add(results, BorderLayout.SOUTH);
        this.add(gameOverPanel,BorderLayout.CENTER);
    }
}
