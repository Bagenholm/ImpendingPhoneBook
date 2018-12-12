package util;
import data.Contact;
import data.ContactBook;
import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class BirthDayNotifier {

    Handler handler;

    public void birthDayNotification() {
        LocalDate date = new LocalDate();

        ContactBook contactBook;



        if(handler.contactBook.getContactList().contains()){
            System.out.println("There is a birthday today.");

            return handler.contactBook.getContactList().stream()
                    .filter( () -> c.getBirthDate().getMonthValue()
                            == LocalDate.now().getMonthValue() );
        }
        else{
            System.out.println("There is no birthday today.");
            return ;
        }
    }
}