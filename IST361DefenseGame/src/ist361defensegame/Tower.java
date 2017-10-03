/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361defensegame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author reesmcdevitt
 */
public class Tower extends JLabel{
   
    public int cost, type, strength, radius;
    public ImageIcon image;
    private static final Tower nullTower = new Tower (0, 0, 0);
    private static final Tower towerOne = new Tower (20, 1, 10);
    private static final Tower towerTwo = new Tower (20, 1, 10);
    private static final Tower towerThree = new Tower (25, 1, 10);
    
    public Tower(int cost, int strength, int radius) {
        this.cost = cost;
        this.strength = strength;
        this.radius = radius;        
    }

    /**
     * @return the nullTower
     */
    public static Tower getNullTower() {
        return nullTower;
    }

    /**
     * @return the towerOne
     */
    public static Tower getTowerOne() {
        return towerOne;
    }

    /**
     * @return the towerTwo
     */
    public static Tower getTowerTwo() {
        return towerTwo;
    }

    /**
     * @return the towerThree
     */
    public static Tower getTowerThree() {
        return towerThree;
    }
    
}
