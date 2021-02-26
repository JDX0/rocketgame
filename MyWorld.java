import greenfoot.*;

public class MyWorld extends World {
    private Rocket rocket;
    private InfoPanel data;
    private Spawner spawner;
    public Debugger debbie;
    private int overCooldown = 50;
    
    public boolean godMode = false;
    
    public MyWorld() {    
        super(1366, 768, 1); 
        prepare();
    }

    private void prepare() {
        rocket = new Rocket(20, 1, 0.13, 0.5, godMode);
        addObject(rocket, 653, 542);
        
        data = new InfoPanel();
        addObject(data, getWidth() / 2, 10);
        
        debbie = new Debugger(4);
        addObject(debbie, 10, 10);
        
        spawner = new Spawner(this);
        
        addObject(new StarBackground(getWidth(), getHeight()), getWidth() / 2, getHeight() / 2);
        
        setPaintOrder(Debugger.class, InfoPanel.class, Marker.class, Explosion.class, Rocket.class, Bullet.class, Fuel.class, Asteroid.class, Planet.class, StarBackground.class);
    }
    
    public void act() {
        data.write("Distance: " + rocket.getDistance() + "km" + " Fuel: " + rocket.getTank().getActFuel() + " Ammo: " + (godMode?"Infinite":rocket.getGun().getAmmo()));
        spawner.act();
        
        if (getObjects(Rocket.class).size() == 0) {
            overCooldown--;
        }
        
        if (overCooldown == 0) {
            Greenfoot.setWorld(new GameOverScreen());
        }
    }
}
