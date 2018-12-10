package menu;

import java.util.ArrayList;
import java.util.logging.Handler;

public class Menu {

    Handler handler;

    ArrayList<Selectable> menuOptions = new ArrayList<Selectable>();
    ArrayList<String> menuChoice = new ArrayList<String>();

    public void add(String s, Selectable selectable) {
        menuChoice.add(s);
        menuOptions.add(selectable);
    }

    public void show(){
        for (int i = 0; i < menuChoice.size(); i++) {
            System.out.println(i + 1 + ". " + menuChoice.get(i));
        }
    }

    public int choice(){
        System.out.println("Please choose your action");

        return handler.input.verifyInt(1, menuChoice.size());
    }


    public void run(){
        menuOptions.get(choice -1).execute();
    }

    public void runEntireMenu(){
        for (Selectable s : menuOptions ) {
            s.execute();
        }
    }

}
