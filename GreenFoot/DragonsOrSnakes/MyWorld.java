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
    
    // Instance variables
    private Wizard player;
    private int score;
    private boolean gameIsRunning;
    private int totalGameTime, timer, spawnRate;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * Sets up the game world AND works as the game manager (GM)
     * This is why there is a gameManager instance variable in the other classes
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        
        // start game
        gameIsRunning = true;
        timer = 0;
        
        // 11) Extend the game so a built-in timer increases the Dragon spawn-rate
        spawnRate = 100;
        totalGameTime = 0;
        
        // add our wizard to the game
        player = new Wizard();
        addObject(player, 100, 200);
        
        // insert 5 dragons to start with
        randomDragons(5);
        
        // update scoreboard
        updateScoreBoard();
        
        
    }
    
    /**
     * Is automatically called by the Greenfoot framework
     * Explanation on how often it runs: https://www.greenfoot.org/topics/335
     */
    public void act() {
        
        if (gameIsRunning) {
            timer++;
            totalGameTime++;
            
            // 6) Spawn new dragons randomly (can also be implemented with timer)
            if (timer > spawnRate) {
                randomDragons(1);
                timer = 0;
                
                // 11) Extend the game so a built-in timer increases the Dragon spawn-rate
                if (totalGameTime > 1000) 
                {
                    spawnRate = 70;
                    
                    //12) Add a dragon boss class with a) increased speed and b) is able to kill the wizard by thouching it
                    if (this.getObjects(DragonBoss.class).size() == 0)
                        addObject(new DragonBoss(3), 300, 500);
                }
                if (totalGameTime > 1200) spawnRate = 50;
                if (totalGameTime > 1700) spawnRate = 30;
               
                
            }
            
            // player is dead and we should stop the game
            if (player.getHealth() <= 0) {
                gameIsRunning = false;
                player = null;                 
            }
            
            updateScoreBoard();
        }
    }
     
    
    /**
     * Return whether the game is still running or finished (player is dead)
     */
    public boolean gameIsRunning() {
        return gameIsRunning;
    }
    
    
    /**
     * Increases the score with 1
     * 7) Scoreboard with amount of dragon kills
     */
    public void increaseScore() {
        score = score + 1;
    }
    
    /**
     * Get the player
     */
    public Wizard getPlayer() {
        return player;
    }
    
    /**
     * 7) Scoreboard with amount of dragon kills (redundant code)
     */
    private void updateScoreBoard() 
    {
        if (gameIsRunning) {
            showText("Dragons killed: " + score, 110, 30);
            showText("Wizard health: " + player.getHealth(), 120, 60);
            showText("Total Game Time: " + totalGameTime, 120, 90);
            showText("Level: " + spawnRate, 70, 120);

        }
        else
            showText("Wizard is dead. Game over... :(", 400,300);
    }
    
    
    /**
     * Spawn dragons at random positions (x,y)
     * 6) Spawn new dragons randomly
     */
    private void randomDragons(int numberToSpawn) {
        for (int i = 0; i < numberToSpawn; i++) {          
            int newX = Greenfoot.getRandomNumber(350)+400; // make sure dragon is in the right half
            int newY = Greenfoot.getRandomNumber(550)+25;
            int newSpeed = Greenfoot.getRandomNumber(3) + 1; // create random speed of 1-3
            
            // 10) Extend your dragon class so its constructor accepts a speed parameter etc.
            Dragon newDragon = new Dragon(newSpeed); // create a new Dragon object with random speed
            addObject(newDragon, newX, newY); // add new dragon to the world
        }
    }
    
}