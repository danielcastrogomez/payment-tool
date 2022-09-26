package Model;

public class User {

    private String firstName;
    private String lastName;
    private String position;
    private int compensationLevel;

    public User(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCompensationLevel() {
        return compensationLevel;
    }

    public void setCompensationLevel(int compensationLevel) {
        this.compensationLevel = compensationLevel;
    }

    @Override
    public String toString() {
        return
                "Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Position: " + position + "\n" +
                "Payment Level: " + compensationLevel + "\n";
    }
}
