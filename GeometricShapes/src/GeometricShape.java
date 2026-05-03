public class GeometricShape {
    private String color;
    private boolean filled;

    public GeometricShape() {
        setColor("Red");
        setFilled(false)
    }

    public GeometricShape(String color, boolean filled) {
        this.setColor(color);
        this.seFilled(filled);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    @Override
    public String toString() {
        return color + "#" + filled;
    }

    public double area() {
        return 0;
    }

    public double perimenter() {
        return 0;
    }
}
