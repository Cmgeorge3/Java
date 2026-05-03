//Christopher George
//11/19/2025
//Comp 167-02
//GameObject class for space Invaders
public abstract class GameObject extends javafx.scene.image.ImageView implements Movable {
    private double direction; // Current direction in degrees
    private double speed; // Num pixels that the object moves at each update
    private double parentWidth; // Width of the enclosing container
    private double parentHeight; // Height of the enclosing container

    public GameObject() {
        setDirection(DirectionConstants.EAST);
        setSpeed(0.0);
        setParentWidth(0.0);
        setParentHeight(0.0);
    }

    public GameObject(double direction, double speed, double parentWidth, double parentHeight) {
        this.setDirection(direction);
        this.setSpeed(speed);
        this.setParentWidth(parentWidth);
        this.setParentHeight(parentHeight);
    }

    @Override
    public void move() {
        // Use trigonometric movement
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        double newY = this.getY() + getSpeed() * Math.sin(Math.toRadians(getDirection()));
        this.setX(newX);
        this.setY(newY);
    }

    // Getters and setters
    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getParentWidth() {
        return parentWidth;
    }

    public void setParentWidth(double parentWidth) {
        this.parentWidth = parentWidth;
    }

    public double getParentHeight() {
        return parentHeight;
    }

    public void setParentHeight(double parentHeight) {
        this.parentHeight = parentHeight;
    }
}