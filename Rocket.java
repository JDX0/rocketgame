import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    private int maxSpeed;
    private int horizontalSpeed;
    private int verticalSpeed;
    private int distance;  //vzdálenost uletěná raketou počítaná v kilometrech
    private int consumption; //počet litrů na 100 kilometrů
    private Gun myGun;      //připojená zbraň
    private Tank tank;  //pripojena nadrz
    
    public Rocket(int spd, int con)
    {
     this.getImage().scale(200,200);
     this.maxSpeed = spd;
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
       this.horizontalSpeed = 0; 
       this.verticalSpeed = 0;
      }
     if(Greenfoot.isKeyDown("left"))
      {
       this.accelerateLeft();       
      } 
     if(Greenfoot.isKeyDown("right"))
      {
       this.accelerateRight();
      }
     if(Greenfoot.isKeyDown("up"))
      {
       this.accelerateUp();
      }
     if(Greenfoot.isKeyDown("down"))
      {
       this.accelerateDown();
      }
     if(Greenfoot.isKeyDown("s"))
      {
        if(this.myGun.canShoot())
         {
          this.getWorld().addObject(new Bullet(10), this.getX(), this.getY() - 100);    
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
     this.move();
     
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
     public void move()
     {
         this.setLocation(this.getX() + this.horizontalSpeed, this.getY() + this.verticalSpeed);

     }
     public void accelerateRight()
     {
        if(this.horizontalSpeed<=this.maxSpeed){
        this.horizontalSpeed += 1;
        }
     }
     public void accelerateLeft()
     {
        if(this.horizontalSpeed>=this.maxSpeed * -1){
        this.horizontalSpeed -= 1;
        }
     }
     public void accelerateUp()
     {
        if(this.verticalSpeed>=this.maxSpeed * -1){
        this.verticalSpeed -= 1;
        }
     }
     public void accelerateDown()
     {
        if(this.verticalSpeed<=this.maxSpeed){
        this.verticalSpeed += 1;
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
