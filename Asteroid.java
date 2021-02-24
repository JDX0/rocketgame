import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends RemovingObject
{
    private int rotation;
    
    public Asteroid(int sp)
    {    
     super(sp);
     rotation = Greenfoot.getRandomNumber(20) - 10;
     getImage().scale(60, 60);
    }
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
  
     this.turn(rotation);
     super.act(); 
    }    
}
