package data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fileio.LocalDateDeserializer;
import fileio.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;


/**
 *Class generated to try out contactBook with fileio. Should be replaced with real contact later.
 * Needs deserializer for date to show correctly.
 */

public class Contact {

    private String number;
    private String name;
    private String email;
    private String note;
    private String address;    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate birthDate;
    public Contact(String name, String number, String address, LocalDate birthDate, String note, String email) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.note = note;
        this.address = address;
    }

    public Contact() {
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Contact[" +
                " name=" + name + ", phoneNumber=" + number +
                ", address=" + address + ", birthDate=" + birthDate +
                ", note=" + note + ", email=" + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getNumber(), contact.getNumber()) &&
                Objects.equals(getName(), contact.getName()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getNote(), contact.getNote()) &&
                Objects.equals(getAddress(), contact.getAddress()) &&
                Objects.equals(getBirthDate(), contact.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getName(), getEmail(), getNote(), getAddress(), getBirthDate());
    }
}
