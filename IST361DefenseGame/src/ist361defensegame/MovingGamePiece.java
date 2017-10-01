/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361defensegame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author cmg5831
 */
public abstract class MovingGamePiece extends Rectangle{
    public double speedX;
    public double speedY;

    public MovingGamePiece(int xLoc, int yLoc, int width, int height) {
        super(xLoc, yLoc, width, height);
        this.speedX = 0;
        this.speedY = 0;
    }

    public void moveRight() {
        Point currLocation = this.getLocation();
        int xLocation = (int) currLocation.getX() + (int) speedX;
        int yLocation = (int) currLocation.getY();

        this.setLocation(xLocation, yLocation);
    }

    public void moveLeft() {
        Point currLocation = this.getLocation();
        int xLocation = (int) currLocation.getX() - (int) speedX;
        int yLocation = (int) currLocation.getY();
//        System.out.println("move left executred");
//        System.out.println(xLocation);
//        System.out.println(speedX);
//        System.out.println(currLocation.getX());
        this.setLocation(xLocation, yLocation);

    }

    public void moveUp() {
        Point currLocation = this.getLocation();
        int xLocation = (int) currLocation.getX();
        int yLocation = (int) currLocation.getY() - (int) speedY;

        this.setLocation(xLocation, yLocation);
    }

    public void moveDown() {
        Point currLocation = this.getLocation();
        int xLocation = (int) currLocation.getX();
        int yLocation = (int) currLocation.getY() + (int) speedY;

        this.setLocation(xLocation, yLocation);
    }

    public void setSpeed(int speedX, int speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}
