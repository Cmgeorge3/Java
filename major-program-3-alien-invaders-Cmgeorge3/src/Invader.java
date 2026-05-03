//Christopher George
//11/19/2025
//Comp 167-02
//Invader class for space Invaders
public abstract class Invader extends GameObject {
    private int pointValue; // Points awarded when hit with projectile

    public Invader() {
        super();
    }

    public Invader(double direction, double speed, double parentWidth, double parentHeight) {
        super(direction, speed, parentWidth, parentHeight);
    }

    // Getters and setters
    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
}