import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InfoPanel extends Actor
{
    public InfoPanel()
    {
        this.setImage(new GreenfootImage("Raketa", 16, Color.BLACK, Color.WHITE));
    }
    
    public void write(String s)
    {
        this.setImage(new GreenfootImage(s, 16, Color.BLACK, Color.WHITE));
    }

}
