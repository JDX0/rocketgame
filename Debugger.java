import greenfoot.*;
import java.util.*;

public class Debugger extends Actor {
    private ArrayList<String> debugInfo = new ArrayList<String>();
    
    public Debugger(int size) {
        for (int i = 0; i < size; i++) {
            debugInfo.add("");
        }
    }
    
    public void display(int line, String value) {
        debugInfo.set(line, value);
        
        setImage(new GreenfootImage(String.join("\n", debugInfo), 16, Color.BLACK, Color.WHITE));
        setLocation(getImage().getWidth() / 2 + 10, getImage().getHeight() / 2 + 10);
    }    
}
