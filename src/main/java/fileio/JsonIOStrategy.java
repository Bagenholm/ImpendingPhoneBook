package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Contact;
import data.ContactBook;
import util.ContactFinder;
import util.Handler;
import java.io.File;
import java.io.IOException;

public class JsonIOStrategy implements IOStrategy {

    Handler handler;

    public JsonIOStrategy(Handler handler) {
        if (handler != null) {
            this.handler = handler;
        }
        else {
            System.err.println("handler cannot be null");
            throw new IllegalArgumentException();
        }

    }

    /**
     *  Save method which utilizes JFileChooser instead of saving through console.
     *  Checks if contact book is instantiated through the handler and that the contact list is not empty.
     *  Then the user is prompted to choose if they want to save a contact or the whole book.
     *  The object is then serialized to Json data and saved in the file location.
     */


    @Override
    public void exportTo() {

        if (handler.contactBook != null && handler.contactBook.getContactList().size()!=0) {

            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println("Do you want to save a contact (1) or the contactBook (2)?");
            int result = handler.input.verifyInt(1, 2);

            Contact contact = null;


            if (result == 1) {
                ContactFinder contactFinder = new ContactFinder(handler);
                if (handler.contactBook.getContactList().size() > 1) {
                    System.out.println("Which contact would you like to export?");
                }
                contact = contactFinder.selectContact(handler.contactBook.getContactList());

            }

            File file = FileSelector.chooseJsonFileSave();

            if (file != null && result == 1) {

                try {
                    objectMapper.writeValue(file, contact);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (file != null && result == 2) {

                try {
                    objectMapper.writeValue(file, handler.contactBook);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("No path selected or operation cancelled");
            }

        }

        else if (handler.contactBook == null) {
            System.out.println("No contactBook instantiated, cannot save to file");

        }

        else if (handler.contactBook.getContactList().size() == 0) {
            System.out.println("The contact book is empty. Cannot save empty contact book to file");
        }

    }


    /**
     * Reads data from a json file and tries to parse it to a contactBook object which is stored in the handler object.
     * It firstly checks that the contactBook is instantiated, then opens a fileChooser where you can select json files and tries to parse the json file
     * and overwrite our contactBook with it. If the Json file does not contain a contactBook the method will instead try to add it as a regular contact.
     *
     */

    public void importTo() {

        if (handler.contactBook == null) {
            System.err.println("No contactBook instantiated, cannot load from file");
            throw new IllegalArgumentException();
        }


        File file = FileSelector.chooseJsonFileLoad();

        if (file != null) {

            ObjectMapper mapper = new ObjectMapper();
            ContactBook deSerializedContactBook;
            Contact deSerializedContact;

            try {
                deSerializedContactBook = mapper.readValue(file, ContactBook.class);

                if (deSerializedContactBook != null)
                    handler.contactBook.setContactList(deSerializedContactBook.getContactList());

            } catch (Exception e) {

                try {
                    deSerializedContact = mapper.readValue(file, Contact.class);
                    if (deSerializedContact!=null)
                    handler.contactBook.add(deSerializedContact);

                } catch (IOException e1) {
                    e.printStackTrace();
                    e1.printStackTrace();
                }


            }

        } else {

            System.out.println("No file selected or operation cancelled");
        }

    }




}
