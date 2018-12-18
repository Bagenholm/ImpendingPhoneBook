package fileio;

import data.Contact;
import data.ContactBook;
import org.junit.jupiter.api.Test;
import util.Handler;

import java.io.ByteArrayInputStream;
import java.io.File;
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
    void exportAndImporToTestContactBookInformationPersists() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        Handler handler = new Handler();
        handler.contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        StringBuilder out = new StringBuilder();
        out.append("test-ipb-").append(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        File path = new File(System.getProperty("user.home") + File.separator + out + ".json");
        JsonIOStrategy jsonIOStrategy = new JsonIOStrategy(handler);
        jsonIOStrategy.exportTo(path,2);

        ContactBook emptyContactBook;
        emptyContactBook = jsonIOStrategy.autoLoadFromJson(out.toString());
        assertEquals(handler.contactBook, emptyContactBook);

        System.setIn(System.in);

    }

    @Test
    void exportToTestContactBookInformationPersistsWhenSavingContact() {

        ByteArrayInputStream in = new ByteArrayInputStream("1,0".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("1".getBytes());

        Handler handler = new Handler();
        handler.contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        StringBuilder out = new StringBuilder();
        out.append("test-ipb-").append(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        File path = new File(System.getProperty("user.home") + File.separator + out + ".json");
        JsonIOStrategy jsonIOStrategy = new JsonIOStrategy(handler);
        System.setIn(in);
        jsonIOStrategy.exportTo(path,1);
        System.setIn(in2);
        jsonIOStrategy.importFrom(path);

        assertEquals(2, handler.contactBook.size());

        System.setIn(System.in);

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