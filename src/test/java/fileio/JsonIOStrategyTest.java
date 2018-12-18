package fileio;

import data.Contact;
import data.ContactBook;
import org.junit.jupiter.api.Test;
import util.Handler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JsonIOStrategyTest {


    @Test
    void throwsExceptionIfHandlerIsNullInConstructor() {

        assertThrows(IllegalArgumentException.class, () -> new JsonIOStrategy(null));

    }



    @Test
    void readFromJsonReturnsNullWhenNoFileMatch() {
        assertNull(JsonIOStrategy.autoLoadFromJson("45648918949818915616aeg6ea1g6ea1g6"));

    }

    @Test
    void throwsExceptionIfStringIsNull() {

        assertThrows(IllegalArgumentException.class, () -> JsonIOStrategy.autoLoadFromJson(null));

    }

    @Test
    void fileWriteReturnsNewFileWithSameInformation() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        StringBuilder out = new StringBuilder();
        out.append("test-ipb-").append(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        JsonIOStrategy.autoSaveToJson(out.toString(), contactBook);
        ContactBook emptyContactBook;
        emptyContactBook = JsonIOStrategy.autoLoadFromJson(out.toString());
        assertEquals(contactBook, emptyContactBook);

    }
    @Test
    void throwsExceptionIfStringIsNullInWriteToJson() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));

        assertThrows(IllegalArgumentException.class, () -> JsonIOStrategy.autoSaveToJson(null, contactBook) );

    }
}