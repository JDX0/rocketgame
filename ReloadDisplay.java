import greenfoot.*;

public class ReloadDisplay extends Actor {
    private int SIZE = 160;
    private int WIDTH = 6;
    private int OFFSET = 0;
    
    public void display(double value, double max, Rocket anchor) {
        GreenfootImage img = new GreenfootImage(SIZE + OFFSET * 2, SIZE + OFFSET * 2);
        
        img.setColor(Color.RED);
        
        double points = Math.PI * 160;
        
        for (int i = 0; i < points / max * value; i++) {
            double fraction = i / points;
            
            double xPos = SIZE / 2 + Math.sin(fraction * Math.PI * 2) * (SIZE / 2 - WIDTH / 2) - WIDTH / 2 + OFFSET;
            double yPos = SIZE / 2 + Math.cos(fraction * Math.PI * 2) * (SIZE / 2 - WIDTH / 2) - WIDTH / 2 + OFFSET;
            
            img.fillOval((int)xPos, (int)yPos, WIDTH, WIDTH);
        }
        
        setImage(img);
        setLocation(anchor.getX(), anchor.getY());
    }      
}
