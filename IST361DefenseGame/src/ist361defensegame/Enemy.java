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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author cmg5831
 */
public class Enemy extends MovingGamePiece{
    
    
    private BufferedImage image;
    private Image enemyScaled;
    private int pathOption;
    
    public Enemy (int xLoc, int yLoc, int width, int height, int pathOption){
        super(xLoc, yLoc, width, height);
        this.pathOption = pathOption;
        init();
    }
    
    private void init(){
        image = null;
        enemyScaled = null;
        try {
            image = ImageIO.read(new File("alien2.png"));
            enemyScaled = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            System.out.println("caught");
        }
        this.setSpeed(3,3);
    }
    
    @Override
    public void update() {
        switch (pathOption){
            case 0:
                if (y < 150) {
                    super.moveDown();
                    //System.out.println("first stage");
                } else if (x < 450 && y < 200) {
                    super.moveRight();
                    //System.out.println("second stage");
                } else if (y < 450 && x > 450) {
                    super.moveDown();
                    //System.out.println("third stage");
                } else {
                    super.moveLeft();
                    //System.out.println("fourth stage");
                }
            case 1:

            case 2:
        }


        
    }

    @Override
    public void draw(Graphics g) {
        //System.out.println(x + " " + y);
       
        g.drawImage(enemyScaled, x, y, null);
    }
}
