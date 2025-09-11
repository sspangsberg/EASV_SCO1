import greenfoot.*;

import java.util.*;

/**
 * Write a description of class Wizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wizard extends Actor
{
    private static final int MAX_COOLDOWN = 50;
    private int cooldown = MAX_COOLDOWN;
    private int health = 100; //8) Wizard has health and can die...
    
    /**
     * 
     */
    public void act() {
        
        // only allow the player to move, shoot etc. if game is running
        if (GameManager.isGameRunning()) 
        {
            cooldown--;
           
            // call the method to handle user input - 3) Wizard movement + shooting using the keyboard
            handleInput();
            
            if (isTouching(DragonBoss.class))
                health = 0;
            else if (isTouching(Dragon.class)) {
                // 8) Wizard has health and can die...
                if (health > 0) {
                    health = health - 1;
                }
            }            
        }
    }   
    
    /**
     * 8) Wizard has health and can die...
     */
    public int getHealth()
    {
        return this.health;
    }
    
    /**
     * 
     */
    private void handleInput() {
        
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
            move(-3);
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
            move(3);
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
            setLocation(getX(), getY() - 3);
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
            setLocation(getX(), getY() + 3);
        if (Greenfoot.isKeyDown("space"))
            shoot();
    }
    
    /**
     * 
     */
    private void shoot() {
        Dragon d = getNearestDragon();
        
        if (d != null && cooldown <= 0) {
            Fireball f = new Fireball(d);
        
            getWorld().addObject(f,this.getX(), this.getY());
            cooldown = MAX_COOLDOWN;
        }
    }
    
    /**
     * 
     */
    private Dragon getNearestDragon() {
        List<Dragon> dragons = getWorld().getObjects(Dragon.class);
        Dragon nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        
        // enhanced for loop
        for (Dragon d: dragons) {
            
            double currentDistance = distance(d);
            if (currentDistance < nearestDistance) {
                nearestDistance = currentDistance;
                nearest = d;
            }
        }
        
        return nearest;
    }
    
    /**
     * 
     */
    private double distance(Actor a) {
        return Math.sqrt(
            Math.abs((getX()-a.getX())^2) +
            Math.abs((getY()-a.getY())^2));
    }
    
    
}
