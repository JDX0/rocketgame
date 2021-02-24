import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int length;
    public Explosion(int length){
        this.length = length;
    }
    public void act() 
    {
        this.getWorld().removeObject(this);
    }    
}
