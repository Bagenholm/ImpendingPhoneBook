package util;

import data.Contact;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


import static org.junit.jupiter.api.Assertions.*;

class BirthdayCheckerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    LocalDate birthday = LocalDate.of(1990,01, 01);


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        birthday.plusDays(1);

    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @RepeatedTest(367)
    void testBirthdayNotifierGiveExpectedResult() {

        Handler handler = new Handler();
        Contact contact = new Contact("Sven", "0706875432", "Raka vägen 15", birthday, "My note says hi", "svennyboy@gmail.com");
        handler.contactBook.add(contact);
        LocalDate nextBDay = contact.getBirthDate().withYear(LocalDate.now().getYear());
        String birthDayString = "";
        if (nextBDay.isBefore(LocalDate.now())) {
            nextBDay = nextBDay.plusYears(1);
        }
        if (nextBDay.isEqual((LocalDate.now()))) {
            birthDayString = "Today is Sven's birthday!\n";
        }

        Period p = Period.between(LocalDate.now(), nextBDay);
        long p2 = ChronoUnit.DAYS.between(LocalDate.now(), nextBDay);
        BirthdayChecker.birthdayNotifier(handler, 365);


        assertEquals(birthDayString+ "There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until " + contact.getName() + " has their next birthday. (" +
                p2 + " days total)\n", outContent.toString());


    }

    @Test
    void noStringPrintedWhenOutsideNotifiablePeriod() {

        LocalDate testDateNow = LocalDate.of(2018,6,15);
        Handler handler = new Handler();
        Contact contact = new Contact("Sven", "0706875432", "Raka vägen 15", birthday, "My note says hi", "svennyboy@gmail.com");
        handler.contactBook.add(contact);
        LocalDate nextBDay = contact.getBirthDate().withYear(testDateNow.getYear());
        String birthDayString = "";
        if (nextBDay.isBefore(testDateNow)) {
            nextBDay = nextBDay.plusYears(1);
        }
        if (nextBDay.isEqual((testDateNow))) {
            birthDayString = "Today is Sven's birthday!\n";
        }

        Period p = Period.between(testDateNow, nextBDay);
        long p2 = ChronoUnit.DAYS.between(testDateNow, nextBDay);
        BirthdayChecker.birthdayNotifier(handler, 15);


        assertEquals("", outContent.toString());


    }


    @Test
    void throwsExceptionIfHandlerNotInstantiated() {

       assertThrows(IllegalArgumentException.class, ()-> BirthdayChecker.birthdayNotifier(null, 50));


    }

    @Test
    void giveEmptyContactListDoesNotThrowException() {

        BirthdayChecker.birthdayNotifier(new Handler(), 30);
        assertEquals("", outContent.toString());

    }
}