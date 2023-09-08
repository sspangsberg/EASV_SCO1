import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // Exercises:
    // 1) write code and make it work without errors and exceptions
    // 2) understand code (including experiment with different loops)
    // 3) wizard movement + shooting using the keyboard
    // 4) play sound when wizard fires off fireball
    // 5) play sound when dragon dies
    // 6) spawn new dragons randomly
    // 7) Scoreboard with amount of dragon kills
    // 8) wizard has health and can die...???
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Wizard(), 100, 200);
        // 
        
        
        for (int i = 0; i < 5; i++) {
            int newX = Greenfoot.getRandomNumber(250)+300;
            int newY = Greenfoot.getRandomNumber(350)+25;
            
            addObject(new Dragon(), newX, newY);
        }
        
    }
}
