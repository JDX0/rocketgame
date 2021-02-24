import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends RemovingObject
{
    public Explosion(int sp)
    {    
     super(sp); 
    }
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     GreenfootImage image = getImage();
     if(image.getTransparency() >= 10)
     {
     image.setTransparency(image.getTransparency() - 10);
     }
     this.turn(1);
     super.act(); 
    }    
}
