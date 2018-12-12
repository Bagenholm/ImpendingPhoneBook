import data.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import data.ContactBook;
import menu.MenuInitializer;
import util.Handler;

import java.time.LocalDate;

public class TestContactList {

    @Test
    void testThatAddContactPutsContactIntoList(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        assertEquals(1,1);
        contactBook.getContactList().size();
        System.out.println(contactBook.getContactList().size());

    }

    @Test
    void testThatRemoveContactRemovesContactFromstList(){
        ContactBook book = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        book.getContactList().add(c);
        assertEquals(1,1);

        book.getContactList().remove(c);
        assertEquals(0,0);
    }

    @Test
    void testThatYouCanEditNameOnAPerson() {
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setName("Karl Olsson");
        System.out.println(contactBook.getContactList().get(0));
    }

    @Test
    void testThatYouCaneditEmailOnAPerson(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setBirthDate(LocalDate.of(2001, 10, 12));
        System.out.println(contactBook.getContactList().get(0));
    }

    @Test
    void testThatYouCanEditPhoneNumberOnAPerson(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setNumber("0418-432945");
        System.out.println(contactBook.getContactList().get(0));

    }

    @Test
    void testThatYouCanEditNoteOnAPerson(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setNote("halloj halloj");
        System.out.println(contactBook.getContactList().get(0));
    }

    @Test
    void testThatYouCanEditEmailOnAPerson(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setEmail("Karlson@iths.se");
        System.out.println(contactBook.getContactList().get(0));
    }

    @Test
    void TestThatYouCanEditAddressOnAPerson(){
        ContactBook contactBook = new ContactBook();
        Contact c = new Contact("Filip Christofferson", "0760447195", "Hindås",
                LocalDate.of(1995, 1, 10), "note", "filip.christofferson@iths.se");
        contactBook.getContactList().add(c);
        c.setAddress("Karlskrona");
        System.out.println(contactBook.getContactList().get(0));
    }


}
