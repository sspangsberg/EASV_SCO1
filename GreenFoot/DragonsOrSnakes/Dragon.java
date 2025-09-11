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
    
    /**
     * 
     */
    public Dragon(int speedParam) {
        this.speed = speedParam;
    }
    
    
    /**
     * Act method
     */
    public void act() {
        
        Wizard player = GameManager.getPlayer();
        
        if (player != null && GameManager.isGameRunning()) {
            turnTowards(player.getX(), player.getY());
            move(speed);
        }        
    }
}
