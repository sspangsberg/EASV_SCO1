import greenfoot.*;

import java.util.List;

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    // declare instance variables
    private Dragon target;
    private MyWorld gameManager;
    
    /**
     * Constructor for objects of class Fireball
     */
    public Fireball(Dragon dragonParam)
    {
        target = dragonParam;
    }
    
    public void act() {
        
        // Get a reference to MyWorld (NOT World), so we are able to call increaseScore()
        gameManager = (MyWorld) getWorld();
        
        if (target.getWorld() == null) 
            return;
            
        // move towards the dragon target
        turnTowards(target.getX(), target.getY()); 
        move(4);
        
        // Get a list of dragons that this fireball hits
        List<Dragon> dragons = getIntersectingObjects(Dragon.class);
        
        // enhanced for loop (foreach)
        for (Dragon currentDragon : dragons) {
            // remove the dragon and update score, if theWorld is not null
            if (gameManager != null) {
                // a) remove dragon
                gameManager.removeObject(currentDragon);
                
                // b) update score
                gameManager.increaseScore();                
            }
        }
        
        // remove the fireball if 
        if (dragons.size() > 0) {
            getWorld().removeObject(this);
        }
        
        
        /* normal for loop
        for(int i=dragons.size()-1; i >= 0; i--) {
            getWorld().removeObject(dragons.get(i)); // List / arrays indexes are zero based (0,1,2,3,4)
        }
        */
        
    }
}