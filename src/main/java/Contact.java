import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private int phoneNumber;
    private String address;
    private int BirthYear;
    private String note;
    private String email;

    public Contact(String name, int phoneNumber, String address, int birthYear, String note, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        BirthYear = birthYear;
        this.note = note;
        this.email = email;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
