package menu;

import data.Contact;
import data.ContactBook;
import fileio.FileSelector;
import util.ASCIIConverter;
import util.ContactFinder;
import util.Handler;
import util.InputManager;

import java.awt.image.BufferedImage;

public class MenuInitializer {

    Handler handler;
    Contact c = new Contact();

    public MenuInitializer(Handler handler) {
        this.handler = handler;
    }

    public void initalizeMenus() {

        Menu mainMenu = new Menu(handler);
        Menu saveMenu = new Menu(handler);
        Menu searchMenu = new Menu(handler);
        Menu editMenu = new Menu(handler);
        Menu quitMenu = new Menu(handler);

        //Main Menu
        mainMenu.add("Search for contact.", () -> searchMenu.run());
        mainMenu.add("Create contact.", () -> { addContact(); editMenu.runEntireMenu(); } );
        mainMenu.add("Print current contact.", () -> printCurrentContact());
        mainMenu.add("Edit contact.", () -> editMenu.run());
        mainMenu.add("Print image.", () -> System.out.println(c.getImage()));
        mainMenu.add("Save.", () -> saveMenu.run());
        mainMenu.add("Load.", () -> { handler.load(); System.out.println(handler.contactBook); } );
        mainMenu.add("Quit.", () -> quitMenu.run());

        //Save Menu
        saveMenu.add("Back to main menu.", () -> mainMenu.run());
        saveMenu.add("Save to existing file.", () -> handler.save());
        saveMenu.add("Save to new file.", () -> handler.saveNew());

        //Search Menu
        searchMenu.add("Back to main menu.", () -> mainMenu.run());
        searchMenu.add("Search by name.", () -> c = finder().selectContact(finder().searchByName(verifyString())));
        searchMenu.add("Search by phone number", () -> c = finder().selectContact(finder().searchByPhoneNumber(verifyString())));
        searchMenu.add("Search by email", () -> c = finder().selectContact(finder().searchByEmail(verifyString())));
        searchMenu.add("Search by birthday", () -> c = finder().selectContact(finder().searchByBirthDate(verifyString())));
        searchMenu.add("Search by note.", () -> c = finder().selectContact(finder().searchByNote(verifyString())));
        searchMenu.add("Search by any / free search", () -> c = finder().selectContact(finder().searchByAny(verifyString())));

        //Edit Menu
        editMenu.add("Back to main menu.", () -> mainMenu.run());
        editMenu.add("Edit contact image.", () -> c.setImage(ascii().convert(ascii().makeImage())));
        editMenu.add("Edit contact name.", () -> c.setName(input().verifyString()));
        editMenu.add("Edit contact phone number.", () -> c.setNumber(input().verifyString()));
        editMenu.add("Edit contact adress.", () -> c.setAddress(input().verifyString()));
        editMenu.add("Edit contact email.", () -> c.setEmail(input().verifyString()));
        editMenu.add("Edit contact note.", () -> c.setNote(input().verifyString()));
        editMenu.add("Edit contact birthdate.", () -> c.setBirthDate(input().verifyDate()));
        editMenu.add("Print current contact.", () -> printCurrentContact());

        //Quit Menu
        quitMenu.add("Back to main menu.", () -> mainMenu.run());
        quitMenu.add("Save and quit.", () -> { handler.save(); System.exit(0);});
        quitMenu.add("Quit without saving.", () -> System.exit(0));

        mainMenu.run();
    }

    //Shorthand for readability.
    private String verifyString(){
        return handler.input.verifyString();
    }

    private ContactFinder finder(){
        return handler.contactFinder;
    }

    private InputManager input(){
        return handler.input;
    }

    private ASCIIConverter ascii() {return handler.ascii; }

    private void addContact() {
        c = new Contact();
        handler.contactBook.add(c);
    }

    private void printCurrentContact() {
        System.out.println(c);
    }
}