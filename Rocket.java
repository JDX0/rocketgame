import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    private int speed;
    private int distance;  //vzdálenost uletěná raketou počítaná v kilometrech
    private int consumption; //počet litrů na 100 kilometrů
    private Gun myGun;      //připojená zbraň
    private Tank tank;  //pripojena nadrz
    
    public Rocket(int spd, int con)
    {
     this.getImage().scale(60,30);
     this.turn(-90);
     this.speed = spd;
     this.distance = 0;
     this.consumption = con;
     this.myGun = new Gun(5, 100); //max 5 nábojů a musí čekat 100 actů na další výstřel
     this.tank = new Tank(50);  //nadrž s kapacitou 50
    }
    
    public Tank getTank()
    {
     return this.tank;    
    }
   
    
    
    private void control()
    {
     if(this.tank.isEmpty())
      {
       this.speed = 0;  
      }
     if(Greenfoot.isKeyDown("left"))
      {
       this.setLocation(this.getX() - this.speed, this.getY());  
      }else 
       if(Greenfoot.isKeyDown("right"))
        {
         this.setLocation(this.getX() + this.speed, this.getY());  
        }
         else 
       if(Greenfoot.isKeyDown("s"))
        {
          if(this.myGun.canShoot())
           {
            this.getWorld().addObject(new Bullet(10), this.getX(), this.getY());    
           }
        }
      
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     this.control();
     //ochladnutí zbraně
     this.myGun.cool();
     this.distance ++;
     //uber nádrž
     this.tank.consume(this.consumption / 100.0);  //!! dělím celé číslo reálným -> výsledek je reálný
     this.takeFuel();
     this.visitPlanet();
    }
    
    public void visitPlanet()
    {
        if(this.isTouching(Planet.class)){
            Planet p = (Planet)this.getOneIntersectingObject(Planet.class);
            this.getWorld().removeObject(p);
            Greenfoot.setWorld(new TraderWorld(this.getWorld(),this));
        }
    }
    
     //
     public void takeFuel()
     {
       if(this.isTouching(Fuel.class))
        {
         Fuel fuel = (Fuel)this.getOneIntersectingObject(Fuel.class);   
      //1. Doplním nádrž o hodnotu paliva v Barelu (Fuel)
         this.tank.refuel(fuel.getCount()); 
      //2. Zobrazím Marker informující o tom, kolik jsem vzal paliva
         Marker marker = new Marker(fuel.getCount());
         this.getWorld().addObject(marker, fuel.getX(), fuel.getY());
      //3. Odstraním Barel ze světa
         this.getWorld().removeObject(fuel);
        }
     }
    
 
    //DU
    //Vyzkoušejte udělat to samé pro sebrání nových nábojů
    // 1. Vytvořte novou Třídu pro náboje jako RemovingObject
    // 2. Zobrazte je ve světě
    // 3. implementujte "sebrání" nábojů -> zvýší se počet nábojů ve zbrani
    
    
    

    public int getDistance()
    {
     return this.distance;
    }

}
