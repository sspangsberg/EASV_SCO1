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
    // 1) Write/copy code and make it work without errors and exceptions
    // 2) Understand code and experiment with different loops
    
    // Implement these coooool features:
    // 3) Wizard movement + shooting using the keyboard
    // 4) Play sound when wizard shoots a fireball
    // 5) Play sound when dragon dies
    // 6) Spawn new dragons randomly
    // 7) Scoreboard with amount of dragon kills
    // 8) Wizard has health and can die...
    // 9) Add a win condition (fx. 10 dragon kills wins) 
    //10) Extend your dragon class so its constructor accepts a speed parameter etc.
    //11) Extend the game so a built-in timer increases the Dragon spawn-rate
    //12) Add a dragon boss class with a) increased speed and b) is able to kill the wizard by thouching it
    //Hint: use inheritance and super
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Wizard(), 100, 200);
        
        for (int i = 0; i < 5; i++) {
            int newX = Greenfoot.getRandomNumber(250)+300;
            int newY = Greenfoot.getRandomNumber(350)+25;
            
            addObject(new Dragon(), newX, newY);
        }
        
    }
}