import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    private int totalCalories; // heltals + instans variabel
    
    // Getter
    public int getTotalCalories() {
        return totalCalories;
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // lokal variabel
        boolean keyDown = Greenfoot.isKeyDown("left");
        if ( keyDown ) {
            move(-3);
        }
        if ( Greenfoot.isKeyDown("right") ) {
            move(3);
        }
        if ( Greenfoot.isKeyDown("up") ) {
            setLocation(getX(), getY() - 3);
        }
        if ( Greenfoot.isKeyDown("down") ) {
            setLocation(getX(), getY() + 3);
        }
        
        // Vi henter fritten
        Fries fry = (Fries) getOneIntersectingObject(Fries.class); // type-casting
        
        if (fry != null) {
            // Objekter kommunikerer med hinanden
            totalCalories = totalCalories + fry.getCalories();
            
            getWorld().removeObject(fry);
        }
    }
}














