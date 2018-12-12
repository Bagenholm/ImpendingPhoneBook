package menu;

//Metod save() i Handler?
//Metod saveNew() i Handler?
//ContactFinder returnerar Contact? Ska ContactFinder ta parametrar?
//Contact-variabel birthYear kanske ska vara birthDay istället? Och inte lagra som en int utan en kalender?

import data.Contact;
import util.Handler;

public class MenuInitializer {

    Handler handler;
    Contact c; //TODO: C=searched contact?


    Menu mainMenu = new Menu();
    Menu createMenu = new Menu();
    Menu saveMenu = new Menu();
    Menu loadMenu = new Menu();
    Menu removeMenu = new Menu();
    Menu searchMenu = new Menu();
    Menu editMenu = new Menu();
    Menu quitMenu = new Menu();

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
        createMenu.add("Make new contact.", () -> { c = new Contact(); editMenu.runEntireMenu(); } ); //TODO: Add chosen contact to edit menu


        //Save Menu
        saveMenu.add("Save to existing file.", () -> handler.save());
        saveMenu.add("Save to new file.", () -> handler.saveNew());
        saveMenu.add("Back to main menu.", () -> mainMenu.run());


        //Load Menu
        loadMenu.add("Load from file.", () -> handler.load());
        loadMenu.add("Back to main menu.", () -> mainMenu.run());


        /*Search Menu TBI TODO: Create contact finder with matching methods - BASSEBOY!? */
        searchMenu.add("Search by name.", () -> c = handler.contactFinder.searchByName());
        searchMenu.add("Search by phone number", () -> c = handler.contactFinder.searchByPhoneNumber());
        searchMenu.add("Search by email", () -> c = handler.contactFinder.searchByEmail());
        searchMenu.add("Search by birthday", () -> c = handler.contactFinder.searchByBirthYear());
        searchMenu.add("Search by note.", () -> c = handler.contactFinder.searchByNote());
        searchMenu.add("Search by any / Free search", () -> c = handler.contactFinder.searcyByAny());
        searchMenu.add("Back to main menu.", () -> mainMenu.run());

        /*
        //Remove Menu
        removeMenu.add("Search by name.", () -> c = handler.contactFinder.searchByName());
        removeMenu.add("Removing the person", () -> handler.contactBook.getContactList().remove(c));
        removeMenu.add("Back to main menu.", () -> mainMenu.run());
        */

        //Edit Menu
        editMenu.add("Edit contact name.", () -> c.setName(handler.input.verifyString())); //TODO: C=searched contact?
        editMenu.add("Edit contact phone number.", () -> c.setNumber(handler.input.verifyString()));
        editMenu.add("Edit contact adress.", () -> c.setAddress(handler.input.verifyString()));
        editMenu.add("Edit contact email.", () -> c.setEmail(handler.input.verifyString()));
        editMenu.add("Edit contact note.", () -> c.setNote(handler.input.verifyString()));
        editMenu.add("Edit contact birthdate.", () -> c.setBirthDate(handler.input.verifyDate()));



        //Quit Menu
        quitMenu.add("Back to main menu.", () -> mainMenu.run());
         quitMenu.add("Save and quit.", () -> { handler.save(); System.exit(0);});
        quitMenu.add("Quit without saving.", () -> System.exit(0));

    }
}
