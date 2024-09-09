import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // instans variable
    private int timer = 0;
    private Elephant e = new Elephant(); 
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    
        // tilføj vores elefant til verdenen
        addObject(e, 100, 200); 
        
        // tælle variabel; betingelse / condition; justering af tællevariabel
        for (int i = 0; i < 2; i++) // sålænge i er mindre end 5, fortsætter løkken
        {
            // generér et tilfældigt nummer mellem 0-399
            int fryCalories = Greenfoot.getRandomNumber(400);
            Fries f =  new Fries(fryCalories);
            
            // Tilføj fritten til verdenen på tilfældig placering (x,y)
            addObject(f, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight())); 
        }
        
        // while // ofte
        // do-while // sjældent
        // foreach // meget ofte
        
    }
    
    
    public void act() {
        timer++;
        
        if (timer > 100) {
            int fryCalories = Greenfoot.getRandomNumber(400);
            Fries f =  new Fries(fryCalories); //
           
            addObject(f, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            
            timer = 0; // reset timer
        }
        
        // Print to the screen - concatenate String and calories
        int totalCalsTemp = e.getTotalCalories();
        showText("Total Calories: " + totalCalsTemp, 100, 30);
    }
    
}

















