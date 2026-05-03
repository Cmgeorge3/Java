public class Triangle {
    private int base;
    private int height;



    public Triangle(){
        base = 2;
        height = 12;

    }
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public double area(int base, int height){
       double area = 0.5 (base * height);
        return area;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
