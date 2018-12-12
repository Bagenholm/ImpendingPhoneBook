import data.Contact;
import data.ContactBook;
import fileio.FileReader;
import fileio.FileWriter;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileWriter {


    @Test
    void fileWriteReturnsNewFileWithSameInformation() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        StringBuilder out = new StringBuilder();
        out.append("test-ipb-").append(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        FileWriter.writeToJson(out.toString(), contactBook);
        ContactBook emptyContactBook = new ContactBook();
        emptyContactBook = FileReader.readFromJson(out.toString());
        assertEquals(contactBook, emptyContactBook);

    }
    @Test
    void throwsExceptionIfStringIsNull() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));

        assertThrows(IllegalArgumentException.class, () -> FileWriter.writeToJson(null, contactBook) );

    }



}
