import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

// importer Random klasse fra Java
import java.util.Random;

/**
 * Wombat. A Wombat moves forward until it can't do so anymore, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Wombat extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int stepsTaken = 0;
    private int leavesEaten = 0;
    private int direction;
    private int pregnancy = -1; // Exercise D
    private boolean isChild = false; // Exercise D
    private int age = 0; // Exercise D

    public Wombat(boolean isChildParam) // konstruktør
    {
        setDirection(EAST);
        leavesEaten = 0;
        stepsTaken = 0; // Exercise 2 // vi ændrer værdien
        this.isChild = isChildParam;   // Exercise D
        
        // Exercise D
        if (isChild) {
            GreenfootImage image = getImage();
            image.scale(25, 25);
            setImage(image);
        }
    }

    
    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {   
        // Exercise D
        if (isChild)
            age++;
            
        if (age == 10) {
            isChild = false;
            setImage(new GreenfootImage("wombat.png"));
        }
        
        
        if(foundLeaf()) {
            eatLeaf();            
        }
        else if (foundStone() && leavesEaten >= 3) { // Exercise 5
            eatStone();
        }
        else if(canMove()) {
            move(); 
            
            // call method
            handleSteps(); 
        }
        else {
            turnLeft();
            
        }
        
    }

    private void handleSteps() { // Exercise 2+3
         if (stepsTaken < 50) {
            
            // Exercise D
            if (!isChild && pregnancy != -1 && pregnancy < 9)
                pregnancy++;
            else if (pregnancy == 9) {
                Wombat child = new Wombat(true);
                getWorld().addObject(child, getX(), getY());
                pregnancy = -1;
            }
            
            stepsTaken++; // shorthand notation
        }
        else {
            //if (this != null && getWorld() != null)
                getWorld().removeObject(this); // ask WombatWorld to remove this Wombat            
        }
    }
    
    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    /**
     * Check whether there is a stone in the same cell as we are.
     */
    public boolean foundStone()
    {
        Actor stone = getOneObjectAtOffset(0, 0, Stone.class);
        if(stone != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundAnotherAdultWombat()
    {
        // Exercise D
        Wombat wombat = (Wombat) getOneObjectAtOffset(0, 0, Wombat.class);
        if(wombat != null && !wombat.isChild()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        
        
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1;
            
            // adjust steps (Exercise 4)
            if (stepsTaken <= 25)
                stepsTaken = 0;
            else
                stepsTaken = stepsTaken - 25;
        }
    }
    
    
    /**
     * Eat a stone.
     */
    public void eatStone()
    {
        Actor stone = getOneObjectAtOffset(0, 0, Stone.class);
        
        if(stone != null) 
        {
            // eat the stone...
            getWorld().removeObject(stone);
            leavesEaten = leavesEaten - 5;
        }
    }
    
    
    
    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
        if (!canMove()) 
        {
            return;
        }
        
        // Exercise B
        // Java
        //Random rnd = new Random(); // Random objekt
        // Object method         ObjectName.methodName()
        //int randomDirection = rnd.nextInt(4); // giv et tilfældigt til mellem 0 og 3
        
        // Greenfoot random
        // Static method      ClassName.methodName()
        int randomDirection = Greenfoot.getRandomNumber(4);
        
        setDirection(randomDirection);
        
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
        
        // Exercise D
        if (foundAnotherAdultWombat()) {
            pregnancy = 0;
        }
        
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {                
        if (getWorld() == null) 
            return false; // wombat is not in any world and cannot move... :(
            
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Sets the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) {
            this.direction = direction;
        }
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
    
    // Exercise D
    public boolean isChild() {
        return isChild;
    }
}