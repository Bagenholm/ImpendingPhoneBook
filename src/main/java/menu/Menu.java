package menu;

import util.Handler;

import java.util.ArrayList;

public class Menu {

    Handler handler;

    ArrayList<Selectable> menuOptions = new ArrayList<Selectable>();
    ArrayList<String> menuChoice = new ArrayList<String>();

    public Menu(Handler handler) {
        this.handler = handler;
    }

    public void add(String s, Selectable selectable) {
        menuChoice.add(s);
        menuOptions.add(selectable);
    }

    public void show(){
        for (int i = 0; i < menuChoice.size(); i++) {
            System.out.println((i + 1) + ". " + menuChoice.get(i));
        }
    }

    public int choice(){
        System.out.println("Please choose your action");
        return handler.input.verifyInt(1, menuChoice.size());
    }

    public void run(){
        while(true) {
            show();
            execute(choice());
        }
    }

    public void execute(int choice) {
        menuOptions.get(choice -1).execute();
    }

    public void runEntireMenu(){
        for (int i = 2; i <= menuOptions.size() -1 ; i++) {
            System.out.println(menuChoice.get(i));
            menuOptions.get(i).execute();
        }
    }
}
