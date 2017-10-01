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
    
    public String name;
    public int cost, type, dmg, radius;
    public ImageIcon img, projectile;
    
    public Tower(String xName, int xCost, int xType, int xDmg, int xRadius, ImageIcon xImg, ImageIcon xProjectile)
	{
		name = xName;
		cost = xCost;
		type = xType;
		dmg = xDmg;
		radius = xRadius;
		img = xImg;
		projectile = xProjectile;
	}
}
