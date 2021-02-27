public class Tank {
    private double maxCap;
    private double actCap;

    public Tank(double max) {
        this.maxCap = max;
        this.actCap = max;
    }

    public double getActFuel() { return actCap; }
    public double getMaxFuel() { return maxCap; }
    public boolean isEmpty() { return (this.actCap <= 0); }

    public void refuel(int num) {
        this.actCap += num;
        if (actCap > this.maxCap) { this.actCap = this.maxCap; }
    }

    public void consume(double num) {
        this.actCap -= num;
        if (this.actCap <= 0) { this.actCap = 0; }
    }
}
