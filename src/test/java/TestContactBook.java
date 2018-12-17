import data.ContactBook;
import org.junit.jupiter.api.Test;

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
}  