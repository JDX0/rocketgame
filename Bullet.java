import greenfoot.*;

public class Bullet extends Actor {
    private int speed;
    private GreenfootImage bullet = new GreenfootImage("images/beeper.png");
    private GreenfootImage ray = new GreenfootImage("images/ray.png");
    
    public Bullet(int type) {
        switch (type) {
            case 0:
            case 1:
                speed = 10;
                setImage(bullet);
                break;
            case 2:
                speed = 15;
                setImage(ray);
            case 3:
                speed = -10;
                setImage(ray);
        }
    }
    
    public void act() {
        this.destroy();
        this.setLocation(this.getX(), this.getY() - speed);
        if (this.isAtEdge()) { this.getWorld().removeObject(this); }
    }
    
    public void destroy() {
        if (this.isTouching(Asteroid.class)) {
            Asteroid asteroid = (Asteroid)this.getOneIntersectingObject(Asteroid.class);   
            Explosion explosion = new Explosion(5, 100 + Greenfoot.getRandomNumber(150));
            getWorld().addObject(explosion, asteroid.getX(), asteroid.getY());
            getWorld().removeObject(asteroid);
        }
    }
}
