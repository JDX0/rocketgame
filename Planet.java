import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Planet extends RemovingObject
{
    private GreenfootImage planetImage = new GreenfootImage("images/planet.png");
    private GreenfootImage litPlanetImage = new GreenfootImage("images/planet2.png");
    
    public Planet(int speed) {
        super(speed);
        getImage().scale(200,200);
    }
    
    public void act() {
        setImage(!isTouching(Rocket.class)?planetImage:litPlanetImage);
        getImage().scale(200,200);
        
        super.act();
    }
}
