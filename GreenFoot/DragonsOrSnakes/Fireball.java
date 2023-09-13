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
    // Variables
    private Dragon target;
    
    /**
     * Constructor for objects of class Fireball
     */
    public Fireball(Dragon dragonParam)
    {
        target = dragonParam;
    }
    
    public void act() {
        
        if (target.getWorld() != null) {
        
            turnTowards(target.getX(), target.getY());
            move(4);
            
            List<Dragon> dragons = getIntersectingObjects(Dragon.class);
             
            // enhanced for loop (foreach)
            for (Dragon d: dragons) {
                MyWorld theWorld = (MyWorld) getWorld();                       
                theWorld.removeObject(d);
                            
                // update scoreboard
                if (theWorld != null) theWorld.increaseScore();
            }
            
            if (dragons.size() > 0) {
                getWorld().removeObject(this);
            }
        }
        else {
            getWorld().removeObject(this);
        }
    }
}
