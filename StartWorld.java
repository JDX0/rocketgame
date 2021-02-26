import greenfoot.*;

public class StartWorld extends World {
    public StartWorld() {    
        super(1366, 768, 1); 
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
