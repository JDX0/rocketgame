import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket extends Actor{
    private int maxSpeed;
    private double friction;
    private double horizontalSpeed;
    private double verticalSpeed;
    private double xPos = 653;
    private double yPos = 542;
    private int distance;
    private int consumption;
    private Gun myGun;
    private Tank tank;

    public Rocket(int spd, int con, double frc)
    {
        getImage().scale(200,200);
        distance = 0;
        
        maxSpeed = spd;
        friction = frc;
        consumption = con;
        
        myGun = new Gun(5, 100);
        tank = new Tank(50);
    }
    
    private void control()
    {
        if (!tank.isEmpty()) {
            if (Greenfoot.isKeyDown("left")) { accelerate(-1, 0); } 
            if (Greenfoot.isKeyDown("right")) { accelerate(1, 0); } 
            if (Greenfoot.isKeyDown("up")) { accelerate(0, -1); } 
            if (Greenfoot.isKeyDown("down")) { accelerate(0, 1); } 
        }
        
        if (Greenfoot.isKeyDown("s") && myGun.canShoot()) {
            getWorld().addObject(new Bullet(10), getX(), getY() - 100);
        }
    }

    public void act() {
        control();
        move();
        slowDown();
        
        myGun.cool();
        tank.consume(this.consumption / 100.0);
        distance++;
        
        collide();
    }
    
    private void collide() {
        if (isTouching(Planet.class)){
            // Greenfoot.setWorld(new TraderWorld(getWorld(), this));
        }
        
        if (isTouching(Fuel.class))
        {
            Fuel fuel = (Fuel)getOneIntersectingObject(Fuel.class);   
            // 1. Doplním nádrž o hodnotu paliva v Barelu (Fuel)
            tank.refuel(fuel.getCount()); 
            // 2. Zobrazím Marker informující o tom, kolik jsem vzal paliva
            Marker marker = new Marker(fuel.getCount());
            getWorld().addObject(marker, fuel.getX(), fuel.getY());
            // 3. Odstraním Barel ze světa
            getWorld().removeObject(fuel);
        }
    }

    private void move()
    {
        xPos += horizontalSpeed;
        yPos += verticalSpeed;

        setLocation((int)xPos, (int)yPos);
    }
    
    private void accelerate(double xAccel, double yAccel)
    {
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
        
        if (Math.abs(horizontalSpeed) <= 0.01) { horizontalSpeed = 0; }
        if (Math.abs(verticalSpeed) <= 0.01) { verticalSpeed = 0; }
    }
    
    public int getDistance() { return this.distance; }
    public Tank getTank() { return this.tank; }
}
