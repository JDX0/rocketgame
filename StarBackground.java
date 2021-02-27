import greenfoot.*;
import java.util.*;

public class StarBackground extends Actor {
    private ArrayList<double[]> stars = new ArrayList();
    private GreenfootImage image;
    
    public StarBackground(int width, int height) {
        image = new GreenfootImage(width, height);
    }
    
    public void act() {
        if (Math.random() < 0.5) {
            stars.add(new double[] {Math.random() * getWorld().getWidth(), 0, Math.pow(Math.random(), 2) * 2 + 0.01});
        }
        
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        
        image.setColor(Color.WHITE);
        for (int i = 0; i < stars.size(); i++) {
            image.fillOval((int)(stars.get(i)[0] - stars.get(i)[2] * 2.5), (int)(stars.get(i)[1] - stars.get(i)[2] * 2.5), (int)(stars.get(i)[2] * 5), (int)(stars.get(i)[2] * 5));
            stars.get(i)[1] += stars.get(i)[2];
            
            if (stars.get(i)[1] > image.getHeight()) {
                stars.remove(i);
                i--;
            }
        }
        
        setImage(image);
        
        getWorld().getObjects(Debugger.class).get(0).display(4, String.valueOf("Number of stars: " + stars.size()));
    }
}
