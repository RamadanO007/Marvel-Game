package model.world;

import java.awt.*;
import java.util.Random;

/**
 * A class representing Covers in the game.
 * Takes parameters (x,y) as location.
 * Locations range from 0-4.
 */
public class Cover {
    private int currentHP;
    private Point location;
    public Cover(int x, int y) {
        location = new Point(x, y);
        Random rand = new Random();
        setCurrentHP(rand.nextInt(900) + 100);
    }
    
    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public Point getLocation() {
        return location;
    }
}
