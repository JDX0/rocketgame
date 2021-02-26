import greenfoot.*;

public class Asteroid extends RemovingObject
{
    private int rotation;
    
    public Asteroid(int sp) {    
        super(sp);
        rotation = Greenfoot.getRandomNumber(20) - 10;
        getImage().scale(60, 60);
    }
    
    public void act() 
    {
        this.turn(rotation);
        super.act(); 
    }    
}
