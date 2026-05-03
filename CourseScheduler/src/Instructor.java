public class Instructor {

    private String firstName;
    private String lastName;
    private String officeBuilding;
    private int roomNumber;

    // Default constructor
    public Instructor() {
        firstName = "Albert";
        lastName = "Einstein";
        officeBuilding = "McNair";
        roomNumber = 420;
    }

    public Instructor(String firstName, String lastName, String officeBuilding, int roomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeBuilding = officeBuilding;
        this.roomNumber = roomNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficeBuilding() {
        return officeBuilding;
    }

    public void setOfficeBuilding(String officeBuilding) {
        this.officeBuilding = officeBuilding;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString(){
        return firstName + "*" + lastName + "*" + officeBuilding + "*" + roomNumber;
    }

    public static void main(String[] args) {
        Instructor instructor = new Instructor();
        Instructor instructor2 = new Instructor("Kelvin", "Bryant", "Martin", 490);

        System.out.println(instructor);
        System.out.println(instructor2);
    }
}