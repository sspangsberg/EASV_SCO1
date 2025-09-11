import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * smsj 
 * 
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
    
    private ScoreBoard scoreBoard;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 200,100);
        GameManager.startGame(this);
        
        randomDragons(5);       
        
    }
    
    
    /**
     * Is automatically called by the Greenfoot framework
     * Explanation on how often it runs: https://www.greenfoot.org/topics/335
     */
    public void act() {
        scoreBoard.updateScoreBoard();
        GameManager.runAct();
    }
    
    /**
     * 
     */
    public void spawnBoss() {
        //12) Add a dragon boss class with a) increased speed and b) is able to kill the wizard by thouching it
        if (this.getObjects(DragonBoss.class).size() == 0)
            addObject(new DragonBoss(3), 300, 500);
    }
    
    
    /**
     * Spawn dragons at random positions (x,y)
     * 6) Spawn new dragons randomly
     */
    public void randomDragons(int numberToSpawn) {
        for (int i = 0; i < numberToSpawn; i++) {          
            int newX = Greenfoot.getRandomNumber((this.getWidth() / 2) - 50)+350; // make sure dragon is in the right half
            int newY = Greenfoot.getRandomNumber(this.getHeight() - 50);
            int newSpeed = Greenfoot.getRandomNumber(3) + 1; // create random speed of 1-3
            
            // 10) Extend your dragon class so its constructor accepts a speed parameter etc.
            Dragon newDragon = new Dragon(newSpeed); // create a new Dragon object with random speed
            addObject(newDragon, newX, newY); // add new dragon to the world
        }
    }
}








