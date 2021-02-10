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
        super(800, 700, 1); 
        prepare();
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        rocket = new Rocket(2,1);
        addObject(rocket,272,542);
        rocket.setLocation(406,758);
        Asteroid asteroid = new Asteroid(4);
        addObject(asteroid,81,53);
        Asteroid asteroid2 = new Asteroid(3);
        addObject(asteroid2,738,113);
        Asteroid asteroid3 = new Asteroid(2);
        addObject(asteroid3,219,75);
        Asteroid asteroid4 = new Asteroid(3);
        addObject(asteroid4,399,63);
        Fuel fuel = new Fuel(5, 1);
        addObject(fuel,706,36);
        data = new InfoPanel();
        addObject(data, 400, 10);
        data.write("Zde jsou data o raketě");
        rocket.setLocation(396,659);
    }
    
    public void act()
    {
     data.write("Distance: "+ rocket.getDistance() + "km" + " Fuel: "+rocket.getTank().getActFuel() );
    }
}
