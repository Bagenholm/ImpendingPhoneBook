import data.Contact;
import org.junit.jupiter.api.Test;
import util.ContactFinder;
import util.Handler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class TestContactFinder {

    Handler handler = new Handler();

    ContactFinder contactFinder = new ContactFinder(handler);

    Contact a1 = new Contact("Alice","0707959697", "Slättåsvägen 34",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@gmail.com");
    Contact a2 = new Contact("Alice","0713561272", "Slättåsvägen 44",
            LocalDate.of(1997, 05, 25),"(>^_^)>","testing@hotmail.com");
    Contact a3 = new Contact("Jonas","0713561273", "Slättåsvägen 54",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@live.se");
    Contact a4 = new Contact("Jonas","0755113259", "Slättåsvägen 54",
            LocalDate.of(1999, 05, 25),"(>^_^)>","testing@live.se");


    @Test
    void TestSearchByName() {

        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByName("Alice");
        assertTrue(results.size()==2);
    }

    @Test
    void TestSearchByEmail() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByEmail("testing@gmail.com");
        assertEquals(1, results.size());
    }

    @Test
    void TestSearchByNote() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByNote("(>^_^)>");
        assertTrue(results.size()==4);
    }

    @Test
    void TestSearchByAddress() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByAddress("Slättåsvägen 54");
        assertTrue(results.size()==2);
    }

    @Test
    void TestSearchByPhoneNumber() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByPhoneNumber("0755113259");
        assertTrue(results.size()==1);
    }

    @Test
    void name() {
        assertEquals("Slättåsvägen 54", a4.getAddress());
    }

    @Test
    void TestSearchByAny() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        results = contactFinder.searchByAny("25");
        assertTrue(results.size()==4);

    }


    @Test
    void TestSearchByBirthDate() {
        handler.contactBook.getContactList().add(a1);
        handler.contactBook.getContactList().add(a2);
        handler.contactBook.getContactList().add(a3);
        handler.contactBook.getContactList().add(a4);

        List<Contact> results;
        //results = contactFinder.searchByBirthDate(LocalDate.of(1999, 05, 25).toString(), handler);
      //  assertTrue(results.size()==3);
    }

}
