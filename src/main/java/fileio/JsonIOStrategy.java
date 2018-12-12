package fileio;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.ContactBook;
import util.Handler;

import java.io.File;

public class JsonIOStrategy implements IOStrategy {

    Handler handler;

    public JsonIOStrategy(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void exportTo() {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = FileSelector.chooseJsonFileSave();

        if (file != null) {

            try {
                objectMapper.writeValue(file, handler.contactBook);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public void importTo() {

        File file = FileSelector.chooseJsonFileLoad();

        if (file != null) {

            ObjectMapper mapper = new ObjectMapper();
            ContactBook deSerializedContactBook;

            try {
                deSerializedContactBook = mapper.readValue(file, ContactBook.class);

                if (deSerializedContactBook != null)
                    handler.contactBook.setContactList(deSerializedContactBook.getContactList());

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }




}
