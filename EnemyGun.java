public class EnemyGun {
    public int maxAmmo = 1;
    public int currAmmo;
    public int cooldown;
    public int counter;
    public boolean isAmmoInfinite = false;
    private int gunMode;
    private Enemy enemy;
    
    public EnemyGun(int gunMode, Enemy enemy) {
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
            case 3:
                cooldown = 10;
                isAmmoInfinite = true;
                break;
        }
        
        this.currAmmo = maxAmmo;
        this.counter = 0;
        this.gunMode = gunMode;
        this.enemy = enemy;
    }
    
    public void cool() { counter--; }
      
    public void shoot() {
        if (currAmmo > 0 && counter <= 0) {
            counter = cooldown;
            
            if (!isAmmoInfinite) { currAmmo--; }
            
            enemy.getWorld().addObject(new Bullet(gunMode), enemy.getX(), enemy.getY());
        }
    }
}
