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



    /**
     * Needs equal and hashcode implementation in Contact and contactBook
     */
    @Test
    void fileWriteReturnsNewFileWithSameInformation() {
        ContactBook contactBook = new ContactBook();
        contactBook.getContactList().add(new Contact("0762221245", "Sven", "svennyboy@gmail.com", LocalDate.of(1987,12,06)));
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
        contactBook.getContactList().add(new Contact("0762221245", "Sven", "svennyboy@gmail.com", LocalDate.of(1987,12,06)));

        assertThrows(IllegalArgumentException.class, () -> FileWriter.writeToJson(null, contactBook) );

    }



}
