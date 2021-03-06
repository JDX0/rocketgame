import greenfoot.*;

public class Marker extends Actor {
    private int num;
    private int speed = 0;
    
    public Marker(int num) {
         this.num = num;
         this.setImage(new GreenfootImage("+" + num, 20, Color.RED, new Color(0, 0, 0, 0)));
    }
    
    public void act() {
        setLocation(getX(), getY() - speed);
        speed += 1;
        
        if (isAtEdge()) {
            getWorld().removeObject(this); 
        }
    }    
}
