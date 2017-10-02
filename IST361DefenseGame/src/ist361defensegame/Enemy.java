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
    private int stage;
    File enemy;
    
    public Enemy (int xLoc, int yLoc, int width, int height, int pathOption, File enemy){
        super(xLoc, yLoc, width, height);
        System.out.println("created enemy");
        this.pathOption = pathOption;
        this.enemy = enemy;
        stage = 0;
        init();
    }
    
    private void init(){
        image = null;
        enemyScaled = null;
        try {
            image = ImageIO.read(enemy);
            enemyScaled = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            System.out.println("caught");
        }
        this.setSpeed(3,3);
    }

    @Override
    public void update() {
        switch (pathOption) {
            case 0:
                if(stage == 0){
                    if(y>125)
                        stage = 1;
                    else
                        super.moveDown();
                } else if(stage == 1){
                    if(x > 425)
                        stage = 2;
                    else
                        super.moveRight();
                } else if(stage == 2){
                    if(y > 425)
                        stage = 3;
                    else
                        super.moveDown();
                } else if(stage == 3){
                    super.moveLeft();
                    //System.out.println("fourth stage");
                }
                break;
            case 1:
                if(stage == 0){
                    if(y>145)
                        stage = 1;
                    else
                        super.moveDown();
                } else if(stage == 1){
                    if(x > 405)
                        stage = 2;
                    else
                        super.moveRight();
                } else if(stage == 2){
                    if(y > 405)
                        stage = 3;
                    else
                        super.moveDown();
                } else if(stage == 3){
                    super.moveLeft();
                }
                break;
            case 2:
                if (stage == 0) {
                    if (y > 105) {
                        stage = 1;
                    } else {
                        super.moveDown();
                    }
                } else if (stage == 1) {
                    if (x > 445) {
                        stage = 2;
                    } else {
                        super.moveRight();
                    }
                } else if (stage == 2) {
                    if (y > 445) {
                        stage = 3;
                    } else {
                        super.moveDown();
                    }
                } else if (stage == 3) {
                    super.moveLeft();
                }
                break;
        }


        
    }

    @Override
    public void draw(Graphics g) {
       
        g.drawImage(enemyScaled, x, y, null);
    }
}
