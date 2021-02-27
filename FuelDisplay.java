import greenfoot.*;

public class FuelDisplay extends Actor {
    public void display(double value, double max) {
        GreenfootImage img = new GreenfootImage(getWorld().getWidth() - 20, 30);
        double width = getImage().getWidth() / max * value;
        
        img.setColor(new Color(255, 255, 0, 128));
        img.fillRect((int)(img.getWidth() - width), 0, (int)width, (int)(img.getHeight()));
        
        setImage(img);
        setLocation(getWorld().getWidth() - getImage().getWidth() / 2 - 10, getWorld().getHeight() - getImage().getHeight() / 2 - 10);
    }    
}
