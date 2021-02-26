public class Gun {
    private int maxAmmo;
    private int currAmmo;
    private int cooldown;
    private int counter;
    private boolean godMode;
    
    public Gun(int maxAmmo, int cooldown, boolean godMode) {
        this.maxAmmo = maxAmmo;
        this.cooldown = cooldown;
        this.currAmmo = maxAmmo;
        this.counter = 0;
        this.godMode = godMode;
    }
    
    public void cool() {
        counter --;  
    }
      
    public boolean canShoot() {
        if (currAmmo > 0 && counter <= 0) {
            if (!godMode) { currAmmo --; }
            counter = cooldown;
            return true;    
        } else {
            return false;  
        }
    }
    
    public int getAmmo() {
        return currAmmo;
    }
    
    public int getMaxAmmo() {
        return maxAmmo;
    }
}
