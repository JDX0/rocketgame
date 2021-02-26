import greenfoot.*;

public class GameOverScreen extends World {
    private PlayAgainButton btn;
    
    public GameOverScreen() {    
        super(1366, 768, 1);
        
        btn = new PlayAgainButton();
        addObject(btn, 400, 400);
    }
    
    public void act() {
        MouseInfo info = Greenfoot.getMouseInfo();
        if (info != null) {
            btn.setLocation(info.getX(), info.getY());
            
            if (info.getButton() > 0) {
                Greenfoot.setWorld(new MyWorld());
            }
        }
        
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
