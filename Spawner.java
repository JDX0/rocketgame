import greenfoot.*;

public class Spawner {
    private int cooldown = 1;
    private World world;
    
    public Spawner(World currentWorld) {
        world = currentWorld;
    }
    
    public void act() {
        cooldown--;
        
        if (cooldown == 0) {
            int x = Greenfoot.getRandomNumber(world.getWidth());
            if (Math.random() < 0.97) {
                world.addObject(new Asteroid(5, Greenfoot.getRandomNumber(60) + 40), x, 0);
            } else {
                world.addObject(new Fuel(3, 5), x, 0);
            }
            cooldown = Greenfoot.getRandomNumber(29) + 1;
        }
    }    
}
