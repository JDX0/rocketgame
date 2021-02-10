import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Marker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marker extends Actor
{
    private int num;
    private int speed = 0;
    
    public Marker(int num)
    {
     this.num = num;
     this.setImage(new GreenfootImage("+"+num, 20, Color.RED, Color.BLACK));
    }
    /**
     * Act - do whatever the Marker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      this.setLocation(this.getX(), this.getY()-this.speed);
      speed += 1;
      if(this.isAtEdge())
       {
        this.getWorld().removeObject(this); 
       }
    }    
}
