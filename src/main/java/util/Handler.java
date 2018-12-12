package util;

import data.ContactBook;
import fileio.FileReader;
import fileio.FileWriter;

public class Handler {

    public ContactBook contactBook = new ContactBook();
    public InputManager input = new InputManager();
    public ContactFinder contactFinder = new ContactFinder(this);

    public void save() {
        FileWriter.writeToJson("auto-save", contactBook);
    }

    public void saveNew() {
        FileWriter.writeToJson(input.verifyString(), contactBook);
    }

    public void load() {
        contactBook = FileReader.readFromJson(input.verifyString());
    }
}
