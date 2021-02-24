import greenfoot.*;

public class RemovingObject extends Actor {
    private int speed;

    public RemovingObject(int sp)
    {
        speed = sp;   
    }

    public int getSpeed() {
        return speed;   
    }

    public void act() {
        if (getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this); 
        } else{
            setLocation(getX(), getY() + speed);   
        }
    }    
}
