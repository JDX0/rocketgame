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
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
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
        rocket = new Rocket(10, 1, 0.07);
        addObject(rocket,653,542);
        Fuel fuel = new Fuel(5, 1);
        addObject(fuel,706,36);
        data = new InfoPanel();
        addObject(data, 400, 10);
        Planet planet = new Planet(1);
        addObject(planet,958,162);
        planet.setLocation(980,13);
        Spawner spawner = new Spawner();
        addObject(spawner,644,77);
        setPaintOrder(InfoPanel.class, Marker.class, Explosion.class, Rocket.class, Bullet.class, Planet.class, Fuel.class, Asteroid.class);
    }
    
    public void act() {
        data.write("Distance: " + rocket.getDistance() + "km" + " Fuel: " + rocket.getTank().getActFuel());
    }
}
