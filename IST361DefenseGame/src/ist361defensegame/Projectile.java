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

/**
 *
 * @author reesmcdevitt
 */
public class Projectile extends MovingGamePiece {

    private BufferedImage image;
    private Image projScaled;
    private Enemy enemy;
    
    public Projectile(int xLoc, int yLoc, int width, int height, Enemy enemy) {
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
        this.setSpeed(3,3);
    }
    @Override
    public void update() {

        if(x > enemy.x){
            
            x -= 10;
            
        } else if(x < enemy.x){
            
            x += 10;
        }

        if(y > enemy.y){

            y -= 10;

        } else if(y < enemy.y){
            
            y += 10;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(projScaled, x, y, null);
    }
    
}
