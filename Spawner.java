import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    long lastAdded = System.currentTimeMillis();
    public void act() 
    {
        long curTime  = System.currentTimeMillis();
        if (curTime >= lastAdded + 250) //5000ms = 5s
        {
            int y = Greenfoot.getRandomNumber(100);
            int x = Greenfoot.getRandomNumber(1366);
            this.getWorld().addObject(new Asteroid(5),x,y);
            lastAdded  = curTime;
        }
    }    
}
