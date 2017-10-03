/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361defensegame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.GameTile;

/**
 *
 * @author reesmcdevitt
 */
public class Projectile extends MovingGamePiece {

    private BufferedImage image;
    private Image projScaled;
    private Enemy enemy;
    
    public Projectile(Tower tower, int xLoc, int yLoc, int width, int height, Enemy enemy) {
        super(xLoc, yLoc, width, height);
        this.enemy = enemy;
        init();
        
    }
    
    private void init(){
        image = null;
        projScaled = null;
        try {
            image = ImageIO.read(new File("alien2.png"));
            projScaled = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            System.out.println("caught");
        }
    }
    @Override
    public void update() {
        int speed = 10;
        int diffX = Math.abs(x - enemy.x);
        int diffY = Math.abs(y - enemy.y);
        //Depending on where enemy is the x and y will increment or decrement until it is equal
        if(x > enemy.x){  
            x -= speed;  
        } else if(x < enemy.x){   
            x += speed;
        }

        if(y > enemy.y){
            y -= speed;
        } else if(y < enemy.y){            
            y += speed;           
        }
        
        //Offset for enemy's constant movement projectile x will never equal enemy.x
        //5 is somewhat arbitary
        if(diffX < 5 && diffY < 5) {
            //System.out.println("Enemy Hit");
        }
        
        //TODO: Handle when enemy x and y is equal to proj x and y
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(projScaled, x, y, null);
    }
    
}
