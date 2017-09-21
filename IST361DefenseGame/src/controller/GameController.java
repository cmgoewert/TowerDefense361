/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.GameUI;

/**
 *
 * @author cmg5831
 */
public class GameController {
    private GameUI theGameUI;
    
    public GameController(){
        theGameUI = new GameUI(this);
    }
}
