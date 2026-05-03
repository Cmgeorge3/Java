public class Apartment extends Dwelling{
    private String apptNum;
    private boolean laundry;

    public String getApptNum() {
        return apptNum;
    }

    public void setApptNum(String apptNum) {
        this.apptNum = apptNum;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }
    public void Apartment(){
        apptNum = null;
        laundry = false;
    }
    @Override
    public String toString(){
        String s = super.toString();

        return s + "|" + apptNum + "|" + laundry;
    }
}
