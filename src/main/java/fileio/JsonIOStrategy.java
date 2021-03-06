package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.Contact;
import data.ContactBook;
import util.ContactFinder;
import util.Handler;

import java.io.File;
import java.io.IOException;

public class JsonIOStrategy implements IOStrategy {

    private Handler handler;

    public JsonIOStrategy(Handler handler) {
        if (handler != null) {
            this.handler = handler;
        } else {
            System.err.println("handler cannot be null");
            throw new IllegalArgumentException();
        }

    }

    /**
     * Reads data from a json file and tries to parse it to a contactBook object.
     * It firstly checks that :
     *
     * @param fileName exists in the users home/documents path.
     * @return new contactBook or null if the file doesn't exist or if an error occurred while parsing.
     * Since importFrom in JsonIOStrategy now exists this method will mainly be used for auto-load on program boot.
     */
    public static ContactBook autoLoadFromJson(String fileName) {

        if (fileName == null) {
            throw new IllegalArgumentException("null used as filename");
        }

        String path = System.getProperty("user.home")
                + File.separator + fileName + ".json";
        File file = new File(path);

        ObjectMapper mapper = new ObjectMapper();
        ContactBook deSerializedContactBook = new ContactBook();

        if (file.exists()) {

            try {
                deSerializedContactBook = mapper.readValue(file, ContactBook.class);
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {
            System.out.println("No auto-save exists. Auto-save not loaded!");
            return null;
        }

        return deSerializedContactBook;

    }

    /**
     * Method that first creates a file in the users home folder:
     *
     * @param fileName    .json
     * @param contactBook is then serialized to Json data and saved in the file location. (see else clause)
     *                    If file already exists and the name is not auto-save (which can be overriden) the method will save the file as temp.json
     *                    instead. Since fileChooser methods now exists, this method will mainly be used for autosaves.
     */
    public static void autoSaveToJson(String fileName, ContactBook contactBook) {

        if (fileName == null) {
            throw new IllegalArgumentException("null used as filename");
        }

        if (!contactBook.getContactList().isEmpty()) {

            String path = System.getProperty("user.home")
                    + File.separator + fileName + ".json";

            ObjectMapper mapper = new ObjectMapper();

            try {

                mapper.writeValue(new File(path), contactBook);
                System.out.println("File saved at: " + path);


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Cannot save empty contact book");

        }

    }

    /**
     * Save method which utilizes file from JFileChooser instead of saving through console.
     * Checks if contact book is instantiated through the handler and that the contact list is not empty.
     * Then the user is prompted to choose if they want to save a contact or the whole book.
     * The object is then serialized to Json data and saved in the file location.
     *
     * @param fileFromFileChooser is the file from the FileSelector method.
     * @param choice is set in earlier method 1 for contact and 2 for the whole contactB ook
     */


    @Override
    public void exportTo(File fileFromFileChooser, int choice) {

        if (handler.contactBook != null && !handler.contactBook.getContactList().isEmpty()) {

            ObjectMapper objectMapper = new ObjectMapper();
            Contact contact = null;


            if (choice == 1) {
                ContactFinder contactFinder = new ContactFinder(handler);

                System.out.println("Which contact would you like to export?");

                contact = contactFinder.selectContact(handler.contactBook.getContactList());

            }

            if (fileFromFileChooser != null && choice == 1) {

                try {
                    objectMapper.writeValue(fileFromFileChooser, contact);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (fileFromFileChooser != null && choice == 2) {

                try {
                    objectMapper.writeValue(fileFromFileChooser, handler.contactBook);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("No path selected or operation cancelled");
            }

        } else if (handler.contactBook == null) {
            System.out.println("No contactBook instantiated, cannot save to file");

        } else if (handler.contactBook.getContactList().size() == 0) {
            System.out.println("The contact book is empty. Cannot save empty contact book to file");
        }

    }


    /**
     * Reads data from a json file and tries to parse it to a contactBook object which is stored in the handler object.
     * It firstly checks that the contactBook is instantiated, then opens a fileChooser where you can select json files and tries to parse the json file
     * and overwrite our contactBook with it. If the Json file does not contain a contactBook the method will instead try to add it as a regular contact.
     *
     * @param fileFromFileChooser is the file that comes from fileChooser.
     */

    public void importFrom(File fileFromFileChooser) {

        if (handler.contactBook == null) {
            System.err.println("No contactBook instantiated, cannot load from file");
            throw new IllegalArgumentException();
        }


        if (fileFromFileChooser != null) {

            ObjectMapper mapper = new ObjectMapper();
            ContactBook deSerializedContactBook;
            Contact deSerializedContact;

            try {
                deSerializedContactBook = mapper.readValue(fileFromFileChooser, ContactBook.class);

                if (deSerializedContactBook != null)
                    handler.contactBook.setContactList(deSerializedContactBook.getContactList());

            } catch (Exception e) {

                try {
                    deSerializedContact = mapper.readValue(fileFromFileChooser, Contact.class);
                    if (deSerializedContact != null)
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
