 
import greenfoot.*;

public class Rocket extends Actor{
    private int maxSpeed;
    private double friction;
    private double horizontalSpeed;
    private double verticalSpeed;
    private double xPos = 653;
    private double yPos = 542;
    private double acceleration;
    private int distance;
    private int consumption;
    private boolean godMode;
    private Gun myGun;
    private Tank tank;

    public Rocket(int spd, int con, double frc, double acc, boolean god) {
        getImage().scale(100, 100);
        distance = 0;
        
        maxSpeed = spd;
        friction = frc;
        consumption = con;
        acceleration = acc;
        
        godMode = god;
        
        myGun = new Gun(5, (god)?2:20, god);
        tank = new Tank(10);
    }
    
    private void control() {
        if (!tank.isEmpty()) {
            if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) { accelerate(-acceleration, 0); } 
            if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) { accelerate(acceleration, 0); } 
            if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) { accelerate(0, -acceleration); } 
            if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) { accelerate(0, acceleration); } 
        }
        
        if ((Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) && myGun.canShoot()) {
            getWorld().addObject(new Bullet(10), getX(), getY());
            if (isTouching(Planet.class)) {
                Greenfoot.setWorld(new TraderWorld(getWorld(), this));
            }
        }
    }

    public void act() {
        control();
        move();
        slowDown();
        
        myGun.cool();
        tank.consume(this.consumption / 100.0);
        distance++;
        
        getWorld().getObjects(Debugger.class).get(0).display(0, String.valueOf("X speed: " + horizontalSpeed));
        getWorld().getObjects(Debugger.class).get(0).display(1, String.valueOf("Y speed: " + verticalSpeed));
        getWorld().getObjects(Debugger.class).get(0).display(2, String.valueOf("X position: " + xPos));
        getWorld().getObjects(Debugger.class).get(0).display(3, String.valueOf("Y position: " + yPos));
        
        collide();
    }
    
    private void collide() {
        if (isTouching(Fuel.class)) {
            Fuel fuel = (Fuel)getOneIntersectingObject(Fuel.class);
            tank.refuel(fuel.getCount());
            Marker marker = new Marker(fuel.getCount());
            getWorld().addObject(marker, fuel.getX(), fuel.getY());
            getWorld().removeObject(fuel);
        }
        
        if (isTouching(Asteroid.class)) {
            Asteroid asteroid = (Asteroid)getOneIntersectingObject(Asteroid.class);
            
            getWorld().addObject(new Explosion(5), asteroid.getX(), asteroid.getY());
            
            if (!godMode) {
                getWorld().removeObject(this);
            } else {
                getWorld().removeObject(asteroid);
            }
        }
    }

    private void move() {
        xPos += horizontalSpeed;
        yPos += verticalSpeed;
        
        if (xPos < 0) {
            xPos = 0;
            if (horizontalSpeed < 0) { horizontalSpeed = -horizontalSpeed; }
        }
        
        if (yPos < 0) {
            yPos = 0;
            if (verticalSpeed < 0) { verticalSpeed = -verticalSpeed; }
        }
        
        if (xPos > getWorld().getWidth()) {
            xPos = getWorld().getWidth();
            if (horizontalSpeed > 0) { horizontalSpeed = -horizontalSpeed; }
        }
        
        if (yPos > getWorld().getHeight()) {
            yPos = getWorld().getHeight();
            if (verticalSpeed > 0) { verticalSpeed = -verticalSpeed; }
        }

        setLocation((int)xPos, (int)yPos);
    }
    
    private void accelerate(double xAccel, double yAccel) {
        horizontalSpeed += xAccel;
        verticalSpeed += yAccel;
        
        if ( horizontalSpeed >= maxSpeed ) { horizontalSpeed = maxSpeed; }
        if ( horizontalSpeed <= -maxSpeed ) { horizontalSpeed = -maxSpeed; }
        if ( verticalSpeed >= maxSpeed ) { verticalSpeed = maxSpeed; }
        if ( verticalSpeed <= -maxSpeed ) { verticalSpeed = -maxSpeed; }
    }
    
    private void slowDown() {
        if (horizontalSpeed > 0) { horizontalSpeed -= friction; }
        if (horizontalSpeed < 0) { horizontalSpeed += friction; }
        if (verticalSpeed > 0) { verticalSpeed -= friction; }
        if (verticalSpeed < 0) { verticalSpeed += friction; }
        
        if (Math.abs(horizontalSpeed) <= friction) { horizontalSpeed = 0; }
        if (Math.abs(verticalSpeed) <= friction) { verticalSpeed = 0; }
    }
    
    public int getDistance() { return distance; }
    public Tank getTank() { return tank; }
    public Gun getGun() { return myGun; }
}
