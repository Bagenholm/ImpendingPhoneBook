package menu;

//ContactFinder returnerar Contact? Ska ContactFinder ta parametrar?
//Contact-variabel birthYear kanske ska vara birthDay istället? Och inte lagra som en int utan en kalender?

import data.Contact;
import fileio.FileSelector;
import util.ASCIIConverter;
import util.ContactFinder;
import util.Handler;
import util.InputManager;

import java.awt.image.BufferedImage;

public class MenuInitializer {

    Handler handler;
    Contact c;

    public MenuInitializer(Handler handler) {
        this.handler = handler;
    }


    public Menu mainMenu = new Menu(handler);
    Menu createMenu = new Menu(handler);
    Menu saveMenu = new Menu(handler);
    Menu loadMenu = new Menu(handler);
    Menu searchMenu = new Menu(handler);
    Menu editMenu = new Menu(handler);
    Menu quitMenu = new Menu(handler);

    public void initalizeMenus() {

        //Main Menu
        mainMenu.add("Search for contact.", () -> searchMenu.run());
        mainMenu.add("Create contact.", () -> createMenu.run());
        mainMenu.add("Edit contact.", () -> editMenu.run());
        mainMenu.add("Save.", () -> saveMenu.run());
        mainMenu.add("Load.", () -> loadMenu.run());
        mainMenu.add("Quit.", () -> quitMenu.run());

        //Create Menu
        createMenu.add("Back to main menu.", () -> mainMenu.run());
        createMenu.add("Make new contact.", () -> { c = new Contact(); editMenu.runEntireMenu(); } );

        //Save Menu
        saveMenu.add("Back to main menu.", () -> mainMenu.run());
        saveMenu.add("Save to existing file.", () -> handler.save());
        saveMenu.add("Save to new file.", () -> handler.saveNew());

        //Load Menu
        loadMenu.add("Back to main menu.", () -> mainMenu.run());
        loadMenu.add("Load from file.", () -> handler.load());

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
        editMenu.add("Edit contact name.", () -> c.setName(input().verifyString())); //TODO: C=searched contact?
        editMenu.add("Edit contact phone number.", () -> c.setNumber(input().verifyString()));
        editMenu.add("Edit contact adress.", () -> c.setAddress(input().verifyString()));
        editMenu.add("Edit contact email.", () -> c.setEmail(input().verifyString()));
        editMenu.add("Edit contact note.", () -> c.setNote(input().verifyString()));
        editMenu.add("Edit contact birthdate.", () -> c.setBirthDate(input().verifyDate()));
        editMenu.add("Edit contact image.", () -> c.setImage(ascii().convert(ascii().makeImage())));

        //Quit Menu
        quitMenu.add("Back to main menu.", () -> mainMenu.run());
        quitMenu.add("Save and quit.", () -> { handler.save(); System.exit(0);});
        quitMenu.add("Quit without saving.", () -> System.exit(0));
    }


    //Shorthand for readability.
    public String verifyString(){
        return handler.input.verifyString();
    }

    public ContactFinder finder(){
        return handler.contactFinder;
    }

    public InputManager input(){
        return handler.input;
    }

    public ASCIIConverter ascii() {return handler.ascii; }
}
