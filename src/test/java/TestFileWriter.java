import data.Contact;
import data.ContactBook;
import fileio.FileReader;
import fileio.FileWriter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileWriter {


    @Test
    /**
     * Needs equal and hashcode implementation in Contact and contactBook
     */
    void fileWriteReturnsNewFileWithSameInformation() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("0762221245", "Sven", "svennyboy@gmail.com", LocalDate.of(1987,12,06)));
        FileWriter.writeToJson("1st-contact-book", contactBook);
        ContactBook emptyContactBook = new ContactBook();
        emptyContactBook = FileReader.readFromJson("1st contact-book");
        assertEquals(contactBook, emptyContactBook);

    }
    @Test
    void throwsExceptionIfStringIsNull() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("0762221245", "Sven", "svennyboy@gmail.com", LocalDate.of(1987,12,06)));

        assertThrows(IllegalArgumentException.class, () -> FileWriter.writeToJson(null, contactBook) );

    }



}
