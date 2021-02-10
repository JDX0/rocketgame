import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for bullet od rocket´s gun
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    public Bullet(int speed)
     {
      this.speed = speed;   
   
     }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      this.setLocation(this.getX(), this.getY()- speed);
       if(this.isAtEdge())
       {
        this.getWorld().removeObject(this); 
       } 
    }    
}
