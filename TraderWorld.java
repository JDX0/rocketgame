import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TraderWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TraderWorld extends World
{
    private World previous;
    private Rocket myRocket;
    /**
     * Constructor for objects of class TraderWorld.
     * 
     */
    public TraderWorld(World w, Rocket r)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.previous = w;
        this.myRocket = r;
        this.myRocket.getTank().refuel(100);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("x"))
        {
            Greenfoot.setWorld(previous);
        }
    }
}
