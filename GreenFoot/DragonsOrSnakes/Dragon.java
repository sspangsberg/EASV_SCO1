import greenfoot.*;

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{ 
    private int hp;
    
    public void act() {
        Wizard w = (Wizard) getWorld().getObjects(Wizard.class).get(0);
        turnTowards(w.getX(), w.getY());
        move(1);
    }
}
