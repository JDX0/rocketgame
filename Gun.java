/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun  
{
  private int maxAmmo;  //max počet nábojů
  private int currAmmo; //akt počet nábojů
  private int cooldown; //počet actů, za jak dlouho můžu vystřelit
  private int counter;  //počítač ochlazení - zbraň může vystřelit, pokud je cooldown <=0
  
  //na zacatku je zbran plne nabita
  public Gun(int maxAmmo, int cooldown)
  {
   this.maxAmmo =  maxAmmo;
   this.cooldown = cooldown;
   this.currAmmo = maxAmmo;
   this.counter = 0;
  }
  
  /**
   * Ochladí zbran o 1
   */
  public void cool()
  {
   this.counter --;  
  }
  
  /**
   * Vystřelí náboj a zahřeje zbraň
   * 
   */
  public boolean canShoot()
  {
   if(this.currAmmo > 0 && this.counter<=0)         // AND
    {
     this.currAmmo --;          //this.currAmmo = this.currAmmo - 1;
     this.counter = this.cooldown;
     return true;    
    } else
      {
        return false;  
      }
  }
  
}
