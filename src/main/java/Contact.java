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
    
}
