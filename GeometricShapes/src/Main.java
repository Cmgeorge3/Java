import java.util.ArrayList;

public class Main {


    public static void main( String [] args) {
        ArrayList<GeometricShape> shapes = new ArrayList<>();
        Circle c = new Circle(10);
        Triangle t = new Triangle(5, 20);
        shapes.add(c);
        shapes.add(t);
        Drivable car = new Automobile();
       // GeometricShape c1 = new Circle(30);

        for (GeometricShape s : shapes) {
            System.out.println("area = " + s.area());
        }
    }
}
