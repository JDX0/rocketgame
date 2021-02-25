import greenfoot.*;

public class InfoPanel extends Actor
{
    public InfoPanel()
    {
        setImage(new GreenfootImage("Raketa", 16, Color.WHITE, new Color(0, 0, 0, 0)));
    }
    
    public void write(String s)
    {
        setImage(new GreenfootImage(s, 16, Color.WHITE, new Color(0, 0, 0, 0)));
    }

}
