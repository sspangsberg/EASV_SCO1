import greenfoot.*;

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    private int speed; // Integer - 180 km/t
    private double tirePressure = 2.5; // float, double 
    private boolean canDrive = true; // can drive true/false
    private String model = "Tesla Model S";
    
    // primitive vs. object typer
    
    /**
     * Constructor for objects of class Car
     */
    public Car(int speedParam)
    {
        this.speed = speedParam;
    }
    
    
    
    public boolean isFast() {
        
        if (speed > 170)
            return true;
        else
            return false;
    }
    
    
    // Action / command
    public void act() {
           
        if (isTouching(Car.class)) {
            
            Actor intersectedCar = null;//getOneObjectAtOffset(0,0, Car.class);
            
            //if (intersectedCar != null)
                getWorld().removeObject(null); 
        }
        
        move(speed);
        
    
    }

    // isTouching()
    // Question
    public int getSpeed() {
        return speed;
    }
}





