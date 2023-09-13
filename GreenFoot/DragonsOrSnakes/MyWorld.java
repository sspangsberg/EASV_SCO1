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
    // 1) Write code and make it work without errors and exceptions
    // 2) Understand code (including experiment with different loops)
    // 3) Wizard movement + shooting using the keyboard
    // 4) Play sound when wizard fires off fireball
    // 5) Play sound when dragon dies
    // 6) Spawn new dragons randomly
    // 7) Scoreboard with amount of dragon kills
    // 8) Wizard has health and can die...
    
    // 9) Add a win condition (fx. 10 dragon kills wins) 
    //10) Extend your dragon class so its constructor accepts a speed parameter etc.
    //11) Extend the game so a built-in timer increases the Dragon spawn-rate
    //12) Add a dragon boss class with a) increased speed and b) is able to kill the wizard by thouching it
    //Hint: use inheritance and super
    
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
