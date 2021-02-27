public class Gun {
    public int maxAmmo = 1;
    public int currAmmo;
    public int cooldown;
    public int counter;
    public boolean isAmmoInfinite = false;
    private int gunMode;
    private Rocket rocket;
    
    public Gun(int gunMode, Rocket rocket) {
        switch (gunMode) {
            case 0:
                cooldown = 20;
                maxAmmo = 5;
                break;
            case 1:
                cooldown = 2;
                isAmmoInfinite = true;
                break;
            case 2:
                cooldown = 100;
                isAmmoInfinite = true;
                break;
        }
        
        this.currAmmo = maxAmmo;
        this.counter = 0;
        this.gunMode = gunMode;
        this.rocket = rocket;
    }
    
    public void cool() { counter--; }
      
    public void shoot() {
        if (currAmmo > 0 && counter <= 0) {
            counter = cooldown;
            
            if (!isAmmoInfinite) { currAmmo--; }
            
            rocket.getWorld().addObject(new Bullet(gunMode), rocket.getX(), rocket.getY());
        }
    }
}
