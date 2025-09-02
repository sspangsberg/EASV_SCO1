import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class PolarBear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PolarBear extends Actor
{
    // Exercise E
    private int direction;
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    
    
    public PolarBear() {
    }
    
    
    /**
     * Act - do whatever the PolarBear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (canMove()) 
        {
            hunt();
        }
        else {
            turnLeft();
            
        }
            
    }
    
    
    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }
    
    
    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {                
        if (getWorld() == null) 
            return false; 
            
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }
    
    
    /**
     * Check whether there is a wombat within distance or on location as polarbear.
     */
    public void hunt()
    {
        List<Wombat> wombats = getObjectsInRange(3, Wombat.class);
        Actor foundWombat = getOneObjectAtOffset(0,0, Wombat.class);
        
        if (foundWombat != null)
        {
            // if polarbear has found a wombat at the same location, eat it
            getWorld().removeObject(foundWombat);  
        }
        else if (!wombats.isEmpty()) 
        {
            // if not on location with wombat, take the first wombat nearby and move toward it
            this.turnTowards(wombats.get(0).getX(), wombats.get(0).getY());
            move(1); // move 1 cell closer to wombat
        }
        else {
            move(); // if far away from wombats (nothing in list), move randomly   
        }
        
    }
    
    
    
    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
        // Greenfoot random
        int randomDirection = Greenfoot.getRandomNumber(4);
        
        setDirection(randomDirection);
        
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }    
        

        
        /**
     * Sets the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) {
            this.direction = direction;
        }
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }
    
    
}
