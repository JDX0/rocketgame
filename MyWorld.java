import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Rocket rocket;
    private InfoPanel data;
    private Spawner spawner;
    public Debugger debbie;
    
    public MyWorld()
    {    
        // Create a new world with 600x800 cells with a cell size of 1x1 pixels.
        super(1366, 768, 1); 
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        rocket = new Rocket(10, 1, 0.13);
        addObject(rocket,653,542);
        
        data = new InfoPanel();
        addObject(data, getWidth() / 2, 10);
        
        debbie = new Debugger(2);
        addObject(debbie, 10, 10);
        
        spawner = new Spawner(this);
        
        addObject(new StarBackground(getWidth(), getHeight()), getWidth() / 2, getHeight() / 2);
        
        setPaintOrder(Debugger.class, InfoPanel.class, Marker.class, Explosion.class, Rocket.class, Bullet.class, Fuel.class, Asteroid.class, Planet.class, StarBackground.class);
    }
    
    public void act() {
        data.write("Distance: " + rocket.getDistance() + "km" + " Fuel: " + rocket.getTank().getActFuel());
        spawner.act();
    }
}
