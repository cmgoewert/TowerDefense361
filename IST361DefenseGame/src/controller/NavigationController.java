/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MenuUI;

/**
 *
 * @author cmg5831
 */
public class NavigationController {
    private MenuUI theMainMenu;
    
    public NavigationController(){
        theMainMenu = new MenuUI(this);
    }
}
