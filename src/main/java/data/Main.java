package data;

import fileio.FileSelector;
import fileio.IOContext;
import fileio.JsonIOStrategy;
import javafx.application.Application;
import javafx.stage.Stage;
import util.Handler;

import java.time.LocalDate;


public class Main  {



    public static void main(String[] args) {

        System.out.println("hello world");

        Handler handler = new Handler();

        handler.contactBook.getContactList().add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));

        IOContext ioContext = new IOContext();

        ioContext.setExportIOStrategy(new JsonIOStrategy(handler));

        ioContext.exportTo();

        ioContext.setImportIOStrategy(new JsonIOStrategy(handler));

        ioContext.importFrom();

        System.out.println(handler.contactBook);




    }
}
