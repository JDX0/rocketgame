import greenfoot.*;

public class Asteroid extends RemovingObject {
    private int rotation;
    public int size;
    
    public Asteroid(int sp, int size) {    
        super(sp);
        rotation = Greenfoot.getRandomNumber(20) - 10;
        getImage().scale(size, size);
        this.size = size;
    }
    
    public void act() {
        this.turn(rotation);
        super.act(); 
    }    
}
