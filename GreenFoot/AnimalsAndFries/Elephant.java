import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    public String name = "Preben";
    
    //getter / setter
    public String getName() {
        return name;
    }
    
    public void setName(String nameParam) {
        this.name = nameParam;
    }
    
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
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
        
        
        Actor fries = getOneIntersectingObject(Fries.class);
        
        
        if (fries != null) {
        
            getWorld().removeObject(fries);
            
            
            
        }
        
        
        
        // Add your action code here.
    }
}














