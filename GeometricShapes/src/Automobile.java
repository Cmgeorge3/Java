public class Automobile implements Drivable {
    private String make;
    private String model;
    private int year;

    public Automobile(){}

    @Override
    public void forward() {
        System.out.println("Place in drive gear and press the accelerator");
    }

    @Override
    public void reverse() {
        System.out.println("Place in reverse gear and press the accelerator");
    }

    @Override
    public void stop() {
        System.out.println("Press the break pedal");
    }

    @Override
    public void left() {
        System.out.println("Turn steering wheel left");
    }

    @Override
    public void right() {
        System.out.println("Turn steering wheel right");
    }
}
