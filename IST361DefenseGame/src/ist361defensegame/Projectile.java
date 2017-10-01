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
    
    public Projectile(int xLoc, int yLoc, int width, int height) {
        super(xLoc, yLoc, width, height);
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
//            double xDiff = x - 500;
//            double yDiff = y - 500;
//            double sigma = Math.atan2(xDiff, yDiff);
//            double moveMag = Math.min(100, Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));
//            x = (int) (x - (moveMag * Math.cos(sigma)));
//            y = (int) (y - (moveMag * Math.sin(sigma)));

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(projScaled, x, y, null);
    }
    
}
