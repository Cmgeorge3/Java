import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private final static double TWO_PI = 2 * Math.PI;
    private int speed = 8;//slower but smoother, faster but choppier
    private double direction = 45;//unit circle upside down,


    public Ball( double xLoc, double yLoc) {
        this.setCenterX(xLoc);//locate by center of the circle
        this.setCenterY(yLoc);
        this.setStroke(Color.RED);
        this.setFill(Color.RED);
        this.setRadius(15);//size

    }

    public void move() {
        // Pane pane = (Pane) this.getParent();
        //
        this.setCenterX( this.getCenterX() + getSpeed() * Math.cos( getDirection() /360 * TWO_PI));//x axis
        this.setCenterY( this.getCenterY() + getSpeed() * Math.sin( getDirection() /360 * TWO_PI));//y axis
    }
    //contro
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
