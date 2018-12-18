import data.Contact;
import data.ContactBook;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestContactBook {

    @Test
    void testThatContactBookThrowsExceptionWhenInputtingNull() {
        assertThrows(IllegalArgumentException.class, () -> new ContactBook(null));
    }

    @Test
    void testThatAddMethodDoesNotAcceptNullAsInput() {

        ContactBook contactBook = new ContactBook();
        contactBook.add(null);
        assertEquals(0,contactBook.getContactList().size());
    }

    @Test
    void testThatSizeMethodReturns0sizeWhenContactListIsNull () {

        ContactBook contactBook = new ContactBook();
        contactBook.setContactList(null);
        assertEquals(0, contactBook.size());

    }

    @Test
    void testThatAddMethodDoesNotAddDuplicatesWhenChoosingTwo() {

        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        ContactBook contactBook = new ContactBook();
        contactBook.add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        contactBook.add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        assertEquals(1, contactBook.size());

        System.setIn(System.in);
    }

    @Test
    void testThatAddMethodAddsDuplicatesWhenChoosingOne() {

        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        ContactBook contactBook = new ContactBook();
        contactBook.add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987, 12, 06), "My note says hi", "svennyboy@gmail.com"));
        contactBook.add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987, 12, 06), "My note says hi", "svennyboy@gmail.com"));
        assertEquals(2, contactBook.size());

        System.setIn(System.in);

    }
}  