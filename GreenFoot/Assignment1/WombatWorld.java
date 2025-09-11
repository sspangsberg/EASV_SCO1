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
    private int ticks = 0;
    
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(16, 16, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Leaf.class, Wombat.class);
        
        populate();
        
    }  
    
    
    /**
     * 
     */
    public void act() {
        
        if (Greenfoot.getRandomNumber(8) == 1) { // Exercise C
            randomLeaves(5);
            randomStones(1);
        }
    }
    
    
    /**
     * Populate the world with a fixed scenario of actors.
     */    
    public void populate()
    {        
        randomWombats(6);
        randomLeaves(40);
        randomStones(6);
        randomPolarBear(1); // Exercise E
    }
    
    
    /**
     * Place a number of wombats into the world at random places.
     * The number of wombats can be specified.
     */
    public void randomWombats(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Wombat newWombat = new Wombat(false);
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            
            addObject(newWombat, x, y);
        }
    }
    
    
    /**
     * Place a number of PolarBears into the world at random places.
     * The number of PolarBears can be specified.
     * Exercise E
     */
    public void randomPolarBear(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            PolarBear newPolarBear = new PolarBear();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            
            addObject(newPolarBear, x, y);
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
     * Place a number of stones into the world at random places.
     * The number of stones can be specified.
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