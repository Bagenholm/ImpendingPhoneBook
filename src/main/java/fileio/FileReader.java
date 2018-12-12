package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.ContactBook;

import java.io.File;
import java.io.IOException;

public class FileReader implements Strategy {

    /**
     * Reads data from a json file and tries to parse it to a contactBook object.
     * It firstly checks that :
     * @param fileName exists in the users home/documents path.
     * @return new contactBook or null if the file doesn't exist or if an error occurred while parsing.
     */
    public static ContactBook readFromJson(String fileName) {

        if (fileName == null) {
            throw new IllegalArgumentException("null used as filename");
        }

        String path = System.getProperty("user.home")
                + File.separator + fileName + ".json";
        File file = new File(path);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        ContactBook deSerializedContactBook = new ContactBook();

        if (file.exists()) {
            System.out.println(file.getName() + " exists");

            try {
                deSerializedContactBook = mapper.readValue(file, ContactBook.class);
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {
            System.out.println("File does not exist, try with a different name");
            return null;
        }

        return deSerializedContactBook;

    }


    public File importTo() {
        return null;
    }

    @Override
    public File execute() {
        return null;
    }
}
