/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MainFrame;
import view.MenuUI;

/**
 *
 * @author cmg5831
 */
public class NavigationController {
    private MainFrame theMainMenu;
    
    public NavigationController(){
        theMainMenu = new MainFrame(this);
    }
    
}
