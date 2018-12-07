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

    String number;
    String name;
    String email;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate birthDate;

    public Contact(String number, String name, String email, LocalDate birthDate) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Contact() {
    }

    public String getNumber() {
        return number;
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

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(number, contact.number) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(birthDate, contact.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, email, birthDate);
    }
}
