import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class for all falling and removing objects
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RemovingObject extends Actor
{
    private int speed;
    public RemovingObject(int sp)
     {
      this.speed = sp;   
     }
     
     public int getSpeed()
     {
      return this.speed;   
     }
    /**
     * Act - do whatever the RemovingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      
      if(this.isAtEdge())
       {
        this.getWorld().removeObject(this); 
       } else{
              this.setLocation(this.getX(), this.getY()+this.speed);   
             }

    }    
}
