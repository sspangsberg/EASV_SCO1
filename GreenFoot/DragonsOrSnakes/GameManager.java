/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager  
{
    private static int score;
    private static boolean gameIsRunning = false;
    private static int totalGameTime, timer, spawnRate;
    private static Wizard player;
    private static MyWorld startWorld;

    /**
     * 
     */
    public static void startGame(MyWorld startWorldParam) {
        
        if (startWorldParam != null) {
            
            startWorld = startWorldParam;
            gameIsRunning = true;
            player = new Wizard();
            startWorld.addObject(player, 100, 200);
            timer = 0;
            
            // 11) Extend the game so a built-in timer increases the Dragon spawn-rate
            spawnRate = 100;
            totalGameTime = 0;
        }
    }
    
    /**
     * 
     */
    public static void runAct() {
        
        if (gameIsRunning) {
            
            // player is dead and we should stop the game
            if (player.getHealth() <= 0) {
                setIsGameRunning(false);
                player = null;                 
            }
            
            int timer = getTimer();
            int totalTime = getTotalGameTime();
            
            increaseTimer();
            increaseTotalGameTime();
            
            // 6) Spawn new dragons randomly
            if (timer > getSpawnRate()) {
                startWorld.randomDragons(1);
                
                setTimer(0);
                
                // 11) Extend the game so a built-in timer increases the Dragon spawn-rate
                if (totalTime > 1000) 
                {
                    setSpawnRate(70);
                    
                    // spawn DragonBoss
                    startWorld.spawnBoss();
                }
                if (totalTime > 1200) setSpawnRate(50);
                if (totalTime > 1700) setSpawnRate(30);
            }
            
            
        }
    }
    
    /**
     * Get the player
     */
    public static Wizard getPlayer() {
        return player;
    }
    

    /**
     * 
     */
    public static int getScore() {
        return score;
    }
    
    
    /**
     * Increases the score with 1
     * 7) Scoreboard with amount of dragon kills
     */
    public static void increaseScore() {
        score += 1;
    }
    
    
    /**
     * Return whether the game is still running or finished (player is dead)
     */
    public static boolean isGameRunning() {
        return gameIsRunning;
    }
    
    /**
     * 
     */
    public static void setIsGameRunning(boolean isRunning) {
        gameIsRunning = isRunning;
    }
    
    /**
     * 
     */
    public static int getTotalGameTime() {
        return totalGameTime;
    }
    
    
    /**
     * 
     */
    public static int getTimer() {
        return timer;
    }

    /**
     * 
     */
    public static void setTimer(int timeParam) {
        timer = timeParam;
    }
    
    /**
     * 
     */
    public static void increaseTimer() {
        timer += 1;
    }
    
    /**
     * 
     */
    public static void increaseTotalGameTime() {
        //totalGameTime =+ 1; just assignment (same as totalGameTime = +1)
        //totalGameTime += 1; // add one and re-assign
        totalGameTime = totalGameTime + 1; // "best" readability
    }
    
    /**
     * 
     */
    public static void setSpawnRate(int spawnRateParam) {
        spawnRate = spawnRateParam;
    }
    
    /**
     * 
     */
    public static int getSpawnRate() {
        return spawnRate;
    }
    
}
