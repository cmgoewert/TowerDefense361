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
public class Tower extends ImageIcon{
   
    public int cost, type, strength, radius;
    public ImageIcon image;
    
    private static final Tower nullTower = new Tower (0, 0, 0, 0, new ImageIcon("GameTile2.png"));
    private static final Tower homeworkTosser = new Tower (30, 0, 1, 10, new ImageIcon("Tower_1.gif"));
    private static final Tower eraserCannon = new Tower (20, 0, 1, 10, new ImageIcon("Tower_1.gif"));
    private static final Tower paperFootballLauncher = new Tower (25, 0, 1, 10, new ImageIcon("Tower_1.gif"));
    
    public Tower(int cost, int type, int strength, int radius, ImageIcon image)
	{
		this.cost = cost;
                this.type = type;
                this.strength = strength;
                this.radius = radius;
                this.image = image;
        }

    /**
     * @return the nullTower
     */
    public static Tower getNullTower() {
        return nullTower;
    }

    /**
     * @return the homeworkTosser
     */
    public static Tower getHomeworkTosser() {
        return homeworkTosser;
    }

    /**
     * @return the eraserCannon
     */
    public static Tower getEraserCannon() {
        return eraserCannon;
    }

    /**
     * @return the paperFootballLauncher
     */
    public static Tower getPaperFootballLauncher() {
        return paperFootballLauncher;
    }
    
}
