package data;

import fileio.FileSelector;
import javafx.application.Application;
import javafx.stage.Stage;
import util.Handler;

import java.time.LocalDate;


public class Main extends Application {

    public void start (Stage primaryStage) {

        System.out.println("hello world");

        Handler handler = new Handler();

        handler.contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        FileSelector.chooseJsonFile();



    }

    public static void main(String[] args) {
        launch(args);







    }
}
