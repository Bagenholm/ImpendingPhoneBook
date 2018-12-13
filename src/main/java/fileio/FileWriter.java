package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.ContactBook;
import util.Handler;

import java.io.File;
import java.io.IOException;

public class FileWriter {

    Handler handler;

    public FileWriter(Handler handler) {
        this.handler = handler;
    }

    /**
     * Method that first creates a file in the users home folder:
     *
     * @param fileName    .json
     * @param contactBook is then serialized to Json data and saved in the file location. (see else clause)
     *                    If file already exists and the name is not auto-save (which can be overriden) the method will save the file as temp.json
     *                    instead. Since fileChooser methods now exists, this method will mainly be used for autosaves.
     */
    public static void writeToJson(String fileName, ContactBook contactBook) {

        if (fileName == null) {
            throw new IllegalArgumentException("null used as filename");
        }

        String path = System.getProperty("user.home")
                + File.separator + fileName + ".json";

        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();

        try {

            if (file.exists() && !fileName.equals("auto-save")) {
                System.out.println(file.getName() + " exists. For your convenience we will save the file as temp.json instead");

                String altPath = System.getProperty("user.home")
                        + File.separator + "temp.json";

                mapper.writeValue(new File(altPath), contactBook);
                System.out.println("File saved");

            } else {
                mapper.writeValue(new File(path), contactBook);
                System.out.println("File saved at: " + path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}



