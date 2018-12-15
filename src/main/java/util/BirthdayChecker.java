package util;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BirthdayChecker {


    /**
     * @param handler is where the contactbook is stored
     * @param notifiableInterval is the setting on how long time beforehand that you want to get notified.
     */

    public static void birthdayNotifier(Handler handler, long notifiableInterval) {


        if (handler != null){


        handler.contactBook.getContactList().stream().forEach(contact -> {
            LocalDate nextBDay = contact.getBirthDate().withYear(LocalDate.now().getYear());
            if (nextBDay.isBefore(LocalDate.now())) {
                nextBDay = nextBDay.plusYears(1);
            } else if (nextBDay.isEqual(LocalDate.now())) {

                System.out.print("Today is " + contact.getName() + "'s birthday!\n");
            }
            Period p = Period.between(LocalDate.now(), nextBDay);
            long p2 = ChronoUnit.DAYS.between(LocalDate.now(), nextBDay);
            if (p2 < notifiableInterval) {
                System.out.print("There are " + p.getMonths() + " months, and " +
                        p.getDays() + " days until " + contact.getName() + " has their next birthday. (" +
                        p2 + " days total)\n");

            }
        });

    } else {
            throw new IllegalArgumentException("No handler provided");
        }

    }


}
