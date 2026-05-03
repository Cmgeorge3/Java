public class Circle extends GeometricShape{
    private double radius;

    public Circle() {
        setRadius(0);
    }

    public Circle( double radius) {
        this.setRadius(radius;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
    @Override
    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(){
        this.setRadius(getRadius());
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
