import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestContact {

    Contact c = new Contact("Oskar", "0737123456",
            "Utsiktsvägen 5", 1998, "test", "test@iths.se");

    @Test
    void testToString(){
        String expected =
                "Contact[ name=Oskar, phoneNumber=0737123456, address=Utsiktsvägen 5, birthYear=1998, note=test, email=test@iths.se]";
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
        assertEquals("0737123456",c.getPhoneNumber());
    }

    @Test
    void TestSetPhoneNumber() {
        c.setPhoneNumber("0756015792");
        assertEquals("0756015792", c.getPhoneNumber());
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
    void TestGetBirthYear() {
        assertEquals(1998, c.getBirthYear());
    }

    @Test
    void TestSetBirthYear() {
        c.setBirthYear(1997);
        assertEquals(1997, c.getBirthYear());
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
                "Utsiktsvägen 5", 1998, "test", "test@iths.se").equals
                (new Contact("Oskar", "0737123456",
                "Utsiktsvägen 5", 1998, "test", "test@iths.se")));

    }
}
