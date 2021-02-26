import greenfoot.*;

public class Fuel extends RemovingObject{
    private int capacity;
    
    public Fuel(int c, int sp) {
        super(sp);   
        this.capacity = c;
    }
    
    public int getCount() {
        return this.capacity;
    }
}
