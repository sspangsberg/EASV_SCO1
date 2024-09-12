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
    private final int MAX_COOLDOWN = 50; // const
    private int cooldown = MAX_COOLDOWN;    
    private int health = 100; //8) Wizard has health and can die...
    private MyWorld gameManager; // declare instance variable to the game manager 
    
    /**
     * 
     */
    public void act() {
        
        gameManager = (MyWorld) getWorld(); // assign variable
        
        // only allow the player to move, shoot etc. if game is running
        if (gameManager.gameIsRunning()) 
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
     * Handles keyboard input from the user
     * 3) Wizard movement + shooting using the keyboard
     */
    private void handleInput() {
        
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
    
    /**
     * 8) Wizard has health and can die...
     */
    public int getHealth()
    {
        return this.health;
    }

    
    
    /**
     * Shoots a fireball against a dragon
     * 3) Wizard movement + shooting using the keyboard
     */
    private void shoot() 
    {
        Dragon dragon = getNearestDragon(); // get a reference to the closest dragon object
        
        // if we have a dragon d AND we are able to fire (cooldown <=0)
        if (dragon != null && cooldown <= 0) 
        {
            Fireball newFireball = new Fireball(dragon); // create Fireball object with dragon as the target
        
            getWorld().addObject(newFireball,this.getX(), this.getY()); // add the fireball to the game world
            cooldown = MAX_COOLDOWN; // reset cooldown
            
            // 4) Play sound when wizard shoots a fireball
            //new GreenfootSound("EnergyGun.wav").play(); // play sound
        }  
    }
    
    
    /**
     * Find the dragon closest to the player
     */
    private Dragon getNearestDragon() {
        // Get a list of all dragons in the game world
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
     * Internal helper method to find the nearest dragon
     */
    private double distance(Actor a) {
        return Math.sqrt(
            Math.abs((getX()-a.getX())^2) +
            Math.abs((getY()-a.getY())^2));
    }
    
    
}