import greenfoot.*;

public class TraderWorld extends World {
    private World previous;
    private Rocket myRocket;
    private Trader trader1;
    
    public TraderWorld(World w, Rocket r) {    
        super(1366, 768, 1);
        this.previous = w;
        this.myRocket = r;
        this.myRocket.getTank().refuel(100);
        trader1 = new Trader("?", 1);
        this.addObject(trader1, 300, 600);
    }
    
    public void act() {
        if (Greenfoot.mousePressed(trader1)) {
            String resp = Greenfoot.ask(trader1.getQuestion());
            trader1.setResponse(resp);
        }
        
        if (Greenfoot.isKeyDown("x")) { Greenfoot.setWorld(previous); }
    }
}
