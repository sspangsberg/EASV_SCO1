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
    
    private static int score, hp;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); // bigger world
        
        addObject(new Wizard(), 100, 200);
        
        score = 0;
        hp = 100;
        
        randomDragons(5);
        
        
    }
    
    // Runs every frame (30x per second)
    public void act() {
        
        //showText("Test:", 100,100);
        // Concatenation
        showText("Score:  " + score + ".", 60,25);
        showText("HP left:  " + hp, 80,65);
        
        if (Greenfoot.getRandomNumber(200) < 1) {
            randomDragons(1);
        }
    }
    
    public void randomDragons(int numberToSpawn) {
        for (int i = 0; i < numberToSpawn; i++) {          
            int newX = Greenfoot.getRandomNumber(350)+400;
            int newY = Greenfoot.getRandomNumber(550)+25;
            
            addObject(new Dragon(), newX, newY);
        }
    }
    
    
    public void increaseScore() {
        score = score + 1;
    }
    
    public void decreaseHP() {
        if (hp > 0) 
            hp--;
        else {
            // player is dead
            showText("Wizard is dead... :(", 400,300);
            
        }
            
    }
}
