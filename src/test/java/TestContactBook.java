import data.ContactBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestContactBook {

    @Test
    void testThatContactBookThrowsExceptionWhenInputtingNull() {
        assertThrows(IllegalArgumentException.class, () -> new ContactBook(null));
    }
}  