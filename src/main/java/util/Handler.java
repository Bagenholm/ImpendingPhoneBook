package util;

import data.ContactBook;
import fileio.*;
import menu.MenuInitializer;

public class Handler {

    //:TODO kolla new här (konstruktor?)
    public ContactBook contactBook = new ContactBook();
    public InputManager input = new InputManager();
    public ContactFinder contactFinder = new ContactFinder(this);
    public ASCIIConverter ascii = new ASCIIConverter();
    public MenuInitializer menuInitializer = new MenuInitializer(this);
    IOContext io = new IOContext();

    public void init() {
        contactBook = autoLoad();
        BirthdayChecker.birthdayNotifier(this, 30);
        menuInitializer.initalizeMenus();
    }

    public void save() {
        FileWriter.writeToJson("auto-save", contactBook);
    }

    public void saveNew() {
        io.setExportIOStrategy(new JsonIOStrategy(this));
        io.exportTo();
    }

    public ContactBook autoLoad() {
        if (FileReader.readFromJson("auto-save") != null) {
            return FileReader.readFromJson("auto-save");
        } else {
            return new ContactBook();
        }
    }

    public void load() {
        io.setImportIOStrategy(new JsonIOStrategy(this));
        io.importTo();
    }
}
