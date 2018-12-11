import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {

    private String name;
    private String phoneNumber;
    private String address;
    private int birthYear;
    private String note;
    private String email;

    public Contact(String name, String phoneNumber, String address, int birthYear, String note, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthYear = birthYear;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
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

    @Override
    public String toString() {
        return "Contact[" +
                " name=" + name + ", phoneNumber=" + phoneNumber +
                ", address=" + address + ", birthYear=" + birthYear +
                ", note=" + note + ", email=" + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return birthYear == contact.birthYear &&
                name.equals(contact.name) &&
                phoneNumber.equals(contact.phoneNumber) &&
                address.equals(contact.address) &&
                note.equals(contact.note) &&
                email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, address, birthYear, note, email);
    }
}
