import greenfoot.*;

public class Explosion extends RemovingObject
{
    public Explosion(int sp, int size) {    
        super(sp); 
        getImage().scale(size, size);
    }
    
    public void act() {
        GreenfootImage image = getImage();
        if (image.getTransparency() >= 4) {
            image.setTransparency(image.getTransparency() - 4);
            super.act(); 
        } else {
            getWorld().removeObject(this);
        }
    }
}
