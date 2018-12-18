package util;

import data.ContactBook;
import fileio.*;
import menu.MenuInitializer;

import java.time.LocalDate;

public class Handler {

    //:TODO kolla new här (konstruktor?)
    public ContactBook contactBook = new ContactBook();
    public InputManager input = new InputManager();
    public ContactFinder contactFinder = new ContactFinder(this);
    public ASCIIConverter ascii = new ASCIIConverter();
    public MenuInitializer menuInitializer = new MenuInitializer(this);
    IOContext io = IOContext.createIOContext();

    public void init() {
        contactBook = autoLoad();
        BirthdayChecker.birthdayNotifier(this, 30, LocalDate.now());
        menuInitializer.initalizeMenus();
    }

    public void save() {
        JsonIOStrategy.autoSaveToJson("auto-save", contactBook);
    }

    public void saveNew() {
        io.setExportIOStrategy(new JsonIOStrategy(this));
        io.exportTo();
    }

    public ContactBook autoLoad() {
        if (JsonIOStrategy.autoLoadFromJson("auto-save") != null) {
            System.out.println("auto-save loaded");
            return JsonIOStrategy.autoLoadFromJson("auto-save");
        } else {
            return new ContactBook();
        }
    }

    public void load() {
        io.setImportIOStrategy(new JsonIOStrategy(this));
        io.importTo();
    }
}
