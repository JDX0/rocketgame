/**
 * Write a description of class Tank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank  
{
    // instance variables - replace the example below with your own
    private double maxCap;
    private double actCap;

    /**
     * Constructor for objects of class Tank
     */
    public Tank(double max)
    {
     this.maxCap = max;
     this.actCap = max;
    }

    public int getActFuel()
    {
     return (int)this.actCap;
    }
    
    public void refuel(int num)
    {
     this.actCap += num;
     if(actCap > this.maxCap)
      {
       this.actCap = this.maxCap;  
      }
    }
    
    public boolean isEmpty()
    {
     return (this.actCap <= 0);
    }
    
    
    public void consume(double num)
    {
     this.actCap -= num;
     if(this.actCap <= 0)
      {
       this.actCap = 0;  
      }
    }
}
