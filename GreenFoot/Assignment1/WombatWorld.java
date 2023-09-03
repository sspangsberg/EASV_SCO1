import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * A world where wombats live.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(8, 8, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Wombat.class, Leaf.class);
        //populate();
    }

    
    public void act() {
        
        randomLeaves(1);
        randomStones(1);
    }
    
    
    
    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */    
    public void populate()
    {        
        randomWombats(2);
        randomLeaves(15);
        randomStones(2);
    }
    
    
    /**
     * Place a number of wombats into the world at random places.
     * The number of wombats can be specified.
     */
    public void randomWombats(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Wombat newWombat = new Wombat();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            
            addObject(newWombat, x, y);
        }
    }
    
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }
    
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomStones(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Stone stone = new Stone();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
                        
            addObject(stone, x, y);
        }
    }
}