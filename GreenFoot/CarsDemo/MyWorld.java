import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Klasse   var navn  = new Klasse();
        //Car         vw_bubble = new Car(1);  // vi laver er nyt objekt 
        
        Car c1 = null; // declaration = reservere plads i RAM      
        c1 = new Car(1); // instantiation = vi giver den en værdi
        
        Car c2 = new Car(1); // declaration + instantiering      
        
        
        Car tesla_model_s = new Car(5);
        addObject(tesla_model_s, 200,200);
        
    }
    
    
    
    
    
    
    
}
