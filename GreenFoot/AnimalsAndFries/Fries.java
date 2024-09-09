import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fries extends Actor
{
    private int calories; // instans variabel - heltal
    
    
    public Fries(int caloriesParam) // Input til konstruktør
    { 
        calories = caloriesParam;
    }
    
    
    public int getCalories() // Getter (kontrolleret "dør" ind til data)
    {
        return calories;
    }
    
    /**
     * Act - do whatever the Fries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
