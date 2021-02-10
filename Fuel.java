import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fuel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fuel extends RemovingObject
{
    private int capacity; //kolik nese paliva

    
    public Fuel(int c, int sp)
    {
     super(sp);   
     this.capacity = c;

    }
    
    public int getCount()
    {
     return this.capacity;
    }
    
     
 
}
