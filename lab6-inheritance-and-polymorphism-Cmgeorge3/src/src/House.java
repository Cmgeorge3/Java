public class House extends Dwelling {
    private double acreage;
    private int garageSize;

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public int getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(int garageSize) {
        this.garageSize = garageSize;
    }
    public void House(){
        acreage = 0.0;
        garageSize = 0;
    }
    @Override
    public String toString(){
        String s = super.toString();

        return s + "|" + acreage + "|" +garageSize;
    }
}
