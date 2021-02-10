import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InfoPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfoPanel extends Actor
{
    public InfoPanel()
    {
     this.setImage(new GreenfootImage("Raketa", 16, Color.BLACK, Color.WHITE));
    }
    /**
     * Act - do whatever the InfoPanel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void write(String s)
    {
     this.setImage(new GreenfootImage(s, 16, Color.BLACK, Color.WHITE));
    }

}
