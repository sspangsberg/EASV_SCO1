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
    // Variables
    private int health = 100;
    private final int MAX_COOLDOWN = 0;
    private int cooldown = MAX_COOLDOWN;
           
    // Sounds
    private GreenfootSound shootEffect = new GreenfootSound("EnergyGun.wav");
        
    
    public void act() {
        cooldown--;
        
        handleUserInput();
        
        if (isTouching(Dragon.class)) {
            MyWorld theWorld = (MyWorld) getWorld();
            
            if (health > 0) {
            // decrease health by 1
            
            if (isTouching(DragonBoss.class))
                health = 0;
            else
                health = health - 1; 
            } 
        }  
    }
    
    private void handleUserInput() {
        if (Greenfoot.isKeyDown("left")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(3);
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 3);
        }        
        if (Greenfoot.isKeyDown("space")) {
            shoot();
        }
    }
    
    
    // Shoot a fireball towards the nearest dragon
    private void shoot() {
        
        Dragon d = getNearestDragon();
        
        if (d != null && cooldown <= 0) {
            Fireball f = new Fireball(d);
                    
            getWorld().addObject(f,this.getX(), this.getY());
            cooldown = MAX_COOLDOWN;
            
            //shootEffect.play();        
        }
    }
    
    
    // Get the nearest dragon
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
    
    // Calculate the distance from this (Wizard) object to parameter Actor a
    private double distance(Actor a) {
        return Math.sqrt(
            Math.abs((getX()-a.getX())^2) +
            Math.abs((getY()-a.getY())^2));
    }
    
    
    // Get the health of the wizard
    public int getHealth() {
        return health;
    }
}
