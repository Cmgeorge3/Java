public class Dwelling {
    private String streetAddress;
    private String City;
    private String State;
    private String zip;
    private int bedrooms;
    private double bathrooms;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }
    public void Dwelling() {
        streetAddress = null;
        City = null;
        State = null;
        zip = null;
        bedrooms = 0;
        bathrooms = 0.0;
    }
@Override
    public String toString(){

        return streetAddress + "|" + State + "|" + City + "|" + zip + "|" + bedrooms + "|" + bathrooms;
    }
}
