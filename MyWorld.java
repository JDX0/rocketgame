import greenfoot.*;

public class MyWorld extends World {
    private Rocket rocket;
    private Enemy enemy;
    private InfoPanel data;
    private Spawner spawner;
    private FuelDisplay fuelie;
    public ReloadDisplay loadie;
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
        enemy = new Enemy(15, 3, 0.13, 0.6, godMode);
        addObject(enemy, 653, 200);
        
        data = new InfoPanel();
        addObject(data, getWidth() / 2, 10);
        
        debbie = new Debugger(5);
        addObject(debbie, 10, 10);
        
        spawner = new Spawner(this);
        
        fuelie = new FuelDisplay();
        addObject(fuelie, 0, 0);
        
        loadie = new ReloadDisplay();
        addObject(loadie, 0, 0);
        
        addObject(new StarBackground(getWidth(), getHeight()), getWidth() / 2, getHeight() / 2);
        
        setPaintOrder(Debugger.class, InfoPanel.class, FuelDisplay.class, ReloadDisplay.class, Marker.class, Explosion.class,Enemy.class, Rocket.class, Bullet.class, Fuel.class, Asteroid.class, Planet.class, StarBackground.class);
    }
    
    public void act() {
        // UI
        data.write("Distance: " + rocket.getDistance() + "km; Fuel: " + (int)Math.ceil(rocket.getTank().getActFuel()) + "; Ammo: " + (rocket.getGun().isAmmoInfinite?"Infinite":rocket.getGun().currAmmo));
        fuelie.display(rocket.getTank().getActFuel(), rocket.getTank().getMaxFuel());
        
        spawner.act();
        
        if (getObjects(Rocket.class).size() == 0) {
            if (loadie != null) {
                removeObject(loadie);
            }
            overCooldown--;
        }
        
        if (overCooldown == 0) {
            Greenfoot.setWorld(new GameOverScreen());
        }
    }
}
