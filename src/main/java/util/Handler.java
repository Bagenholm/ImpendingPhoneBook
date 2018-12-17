package util;

import data.ContactBook;
import fileio.FileReader;
import fileio.FileWriter;
import menu.MenuInitializer;

public class Handler {

    //:TODO kolla new här (konstruktor?)
    public ContactBook contactBook = new ContactBook();
    public InputManager input = new InputManager();
    public ContactFinder contactFinder = new ContactFinder(this);
    public ASCIIConverter ascii = new ASCIIConverter();
    public MenuInitializer menuInitializer = new MenuInitializer(this);

    public void init() {
        menuInitializer.initalizeMenus();
        menuInitializer.mainMenu.run();
    }

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
