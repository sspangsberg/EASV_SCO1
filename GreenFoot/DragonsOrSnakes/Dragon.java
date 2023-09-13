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
    private MyWorld gameManager = (MyWorld) getWorld();
  
    public Dragon(int speedParam) {
        this.speed = speedParam;
    }
    
    public void act() {
       
        Wizard w = gameManager.getWizard();
        
        if (w.getHealth() > 0 && gameManager.isGameRunning()) {
            turnTowards(w.getX(), w.getY());
            move(speed);            
        }
    }
}
