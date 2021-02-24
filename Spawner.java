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
            world.addObject(new Asteroid(5), x, 0);
            cooldown = 15;
        }
    }    
}
