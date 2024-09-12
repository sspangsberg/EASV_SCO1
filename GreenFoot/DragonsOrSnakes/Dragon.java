import greenfoot.*;

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{ 
    private int speed;
    private MyWorld gameManager;
    
    /**
     * Constructor
     * 10) Extend your dragon class so its constructor accepts a speed parameter etc.
     */
    public Dragon(int speedParam) {
        this.speed = speedParam;
    }
    
    
    /**
     * Act method
     */
    public void act() {
        
        gameManager = (MyWorld) getWorld();
        Wizard player = gameManager.getPlayer();
        
        if (gameManager != null && player != null &&  gameManager.gameIsRunning()) {
            turnTowards(player.getX(), player.getY());
            move(speed);
        }
        
        //Wizard w = (Wizard) getWorld().getObjects(Wizard.class).get(0);
        
    }
}