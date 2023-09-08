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
    private static final int MAX_COOLDOWN = 0;
    private int cooldown = MAX_COOLDOWN;
    private GreenfootSound shootEffect = new GreenfootSound("EnergyGun.wav");
    
    public void act() {
        cooldown--;
        
        // if vs. else-if > try it out...
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
    
    private void shoot() {
        
        Dragon d = getNearestDragon();
        
        if (d != null && cooldown <= 0) {
            Fireball f = new Fireball(d);
        
            
            getWorld().addObject(f,this.getX(), this.getY());
            cooldown = MAX_COOLDOWN;
            
            shootEffect.play();
        }
    }
    
    
    
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
    
    
    private double distance(Actor a) {
        return Math.sqrt(
            Math.abs((getX()-a.getX())^2) +
            Math.abs((getY()-a.getY())^2));
    }
    
    
}
