/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.NavigationController;
import javax.swing.JFrame;

/**
 *
 * @author ariannascheidell
 */
public class MainFrame extends JFrame{
    private NavigationController navController;
    public MainFrame (NavigationController navController) {
        this.navController = navController;
        MenuUI menuUI = new MenuUI(navController);
        this.setBounds(0, 0, 750, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.add(menuUI);
        this.setVisible(true);        
    }
}
