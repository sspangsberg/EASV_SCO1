import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private final int TIMER = 0; // instans variabel
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Elephant e = new Elephant();
        addObject(e, 100, 200);
        e.name = "Peter";
        // tælle variabel; betingelse / condition; justering af tællevariabel
        for (int i = 0; i < 10; i++) // sålænge i er mindre end 5, fortsætter løkken
        {
            Fries f =  new Fries();
            addObject(f, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())); 
        }
        
        
        
        
    }
    
    
    public void act() {
        
        timer++;
        
        if (timer > 100) {
            Fries f =  new Fries();
            addObject(f, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            
            timer = 0; // reset timer
        }
        
        //int rndNumber = Greenfoot.getRandomNumber(25);
        
        //if (rndNumber == 5) {
        //}
        
    }
    
}
















