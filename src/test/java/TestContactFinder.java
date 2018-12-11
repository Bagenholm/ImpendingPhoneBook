import data.Contact;
import org.junit.jupiter.api.Test;
import util.ContactFinder;
import util.Handler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class TestContactFinder {

    ContactFinder contactFinder = new ContactFinder();

    Contact a1 = new Contact("Alice","0713561271", "Slättåsvägen 34",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@gmail.com");
    Contact a2 = new Contact("Alice","0713561272", "Slättåsvägen 44",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@hotmail.com");
    Contact a3 = new Contact("Jonas","0713561273", "Slättåsvägen 54",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@live.se");
    Contact a4 = new Contact("Jonas","0755113259", "Slättåsvägen 54",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@live.se");

    Handler handler = new Handler();

    @Test
    void TestSearchByName() {

        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);

        List<Contact> results;
        results = contactFinder.searchByName("Alice", handler);
        assertTrue(results.size()==2);
    }

    @Test
    void TestSearchByEmail() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);

        List<Contact> results;
        results = contactFinder.searchByEmail("testing@gmail.com", handler);
        assertTrue(results.size()==1);
    }

    @Test
    void TestSearchByAddress() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);

        List<Contact> results;
        results = contactFinder.searchByEmail("testing@gmail.com", handler);
        assertTrue(results.size()==1);
    }


}
