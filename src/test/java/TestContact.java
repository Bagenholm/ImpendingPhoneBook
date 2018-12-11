import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import data.Contact;

import java.time.LocalDate;

public class TestContact {

    Contact c = new Contact("Oskar", "0737123456",
            "Utsiktsvägen 5", LocalDate.of(1998, 8, 16), "test", "test@iths.se");

    @Test
    void testToString(){
        String expected =
                "Contact[ name=Oskar, phoneNumber=0737123456, address=Utsiktsvägen 5, birthDate=1998-08-16, note=test, email=test@iths.se]";
        assertEquals(expected,c.toString());
    }

    @Test
    void TestGetName() {
        assertEquals(c.getName(),"Oskar");
    }

    @Test
    void TestSetName() {
        c.setName("Rasmus");
        assertEquals("Rasmus",c.getName());
    }

    @Test
    void TestGetPhoneNumber() {
        assertEquals("0737123456",c.getNumber());
    }

    @Test
    void TestSetPhoneNumber() {
        c.setNumber("0756015792");
        assertEquals("0756015792", c.getNumber());
    }

    @Test
    void TestGetAddress() {
        assertEquals("Utsiktsvägen 5", c.getAddress());
    }

    @Test
    void TestSetAddress() {
        c.setAddress("Lunnavägen 34");
        assertEquals("Lunnavägen 34", c.getAddress());
    }

    @Test
    void TestGetBirthDate() {
        assertEquals("1998-08-16", c.getBirthDate().toString());
    }

    @Test
    void TestSetBirthDate() {
        c.setBirthDate(LocalDate.of(1997,1,1));
        assertEquals("1997-01-01", c.getBirthDate().toString());
    }

    @Test
    void TestGetNote() {
        assertEquals("test",c.getNote());
    }

    @Test
    void TestSetNote() {
        c.setNote("Test note method");
        assertEquals("Test note method", c.getNote());
    }

    @Test
    void TestGetEmail() {
        assertEquals("test@iths.se",c.getEmail());
    }

    @Test
    void TestSetEmail() {
        c.setEmail("test@gmail.com");
        assertEquals("test@gmail.com", c.getEmail());
    }

    @Test
    void TestHashCode() {
        Contact x = new Contact();
        Contact y = new Contact();
        assertTrue(x.hashCode() == y.hashCode());
    }

    @Test
    void TestEquals() {
        assertTrue(new Contact("Oskar", "0737123456",
                "Utsiktsvägen 5", LocalDate.of(1998,1,1), "test", "test@iths.se").equals
                (new Contact("Oskar", "0737123456",
                "Utsiktsvägen 5", LocalDate.of(1998,1,1), "test", "test@iths.se")));

    }
}
