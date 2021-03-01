import greenfoot.*;

public class Enemy extends Actor{
    private int maxSpeed;
    private double friction;
    private double horizontalSpeed;
    private double verticalSpeed;
    private double xPos = 653;
    private double yPos = 200;
    private double acceleration;
    private int distance;
    private int consumption;
    private int playerX;
    private boolean godMode;
    private boolean isDead = false;
    private int gunType = 0;
    private EnemyGun myGun;

    public Enemy(int spd, int con, double frc, double acc, boolean god) {
        getImage().scale(100, 100);
        distance = 0;
        
        maxSpeed = spd;
        friction = frc;
        consumption = con;
        acceleration = acc;
        turn(180);
        
        godMode = god;
        
       
        
        myGun = new EnemyGun(3, this);
    }

    public void act() {
        // Movement
        control();
        move();
        slowDown();
        
        // Gun & Tank
        myGun.cool();
        distance++;
        playerX = getWorld().getObjects(Rocket.class).get(0).getX();
        
        // Die
        if (isDead) {
            getWorld().removeObject(this);
        }
    }
    
    private void control() {
            if (playerX < getX()) { accelerate(-acceleration, 0); } 
            if (playerX > getX()) { accelerate(acceleration, 0); } 
            
            if (playerX - getX() < 50 && playerX - getX() > -50) {myGun.shoot();};
        //   getWorld().addObject(new Explosion(5, 100), getX(), getY());
        //    isDead = true;
        
    }
    
   

    private void move() {
        xPos += horizontalSpeed;
        yPos += verticalSpeed;
        
        if (xPos < 0) {
            xPos = 0;
            if (horizontalSpeed < 0) { horizontalSpeed = -horizontalSpeed; }
        }
        
        
        if (xPos > getWorld().getWidth()) {
            xPos = getWorld().getWidth();
            if (horizontalSpeed > 0) { horizontalSpeed = -horizontalSpeed; }
        }
        

        setLocation((int)xPos, (int)yPos);
    }
    
    private void accelerate(double xAccel, double yAccel) {
        horizontalSpeed += xAccel;
        verticalSpeed += yAccel;
        
        if ( horizontalSpeed >= maxSpeed ) { horizontalSpeed = maxSpeed; }
        if ( horizontalSpeed <= -maxSpeed ) { horizontalSpeed = -maxSpeed; }
    }
    
    private void slowDown() {
        if (horizontalSpeed > 0) { horizontalSpeed -= friction; }
        if (horizontalSpeed < 0) { horizontalSpeed += friction; }
        
        
        if (Math.abs(horizontalSpeed) <= friction) { horizontalSpeed = 0; }
      
    }
    
    public int getDistance() { return distance; }
    public EnemyGun getGun() { return myGun; }
}
