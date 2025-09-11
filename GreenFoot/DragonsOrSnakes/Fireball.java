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
    private Dragon target;
    
    /**
     * Constructor for objects of class Fireball
     */
    public Fireball(Dragon dragonParam)
    {
        target = dragonParam;
    }
    
    public void act() {
        
        if (getWorld() == null) return;
        else
        {
            // only move if we have a dragon target and a scene (world)
            if (target != null && target.getWorld() != null) {
                turnTowards(target.getX(), target.getY()); 
            }
            
            move(4);
            
            // remove all dragons that fireball hit
            List<Dragon> dragons = getIntersectingObjects(Dragon.class);
            
            for(int i=0; i<dragons.size(); i++) {
                getWorld().removeObject(dragons.get(i)); // List / arrays indexes are zero based (0,1,2,3,4)
            }
            
            // remove fireball if it has passed nearby dragons or 
            // is at the edge of scene
            if (dragons.size() > 0 || isAtEdge()) {
                getWorld().removeObject(this);
                return;
            }
        }
        
    }
}
