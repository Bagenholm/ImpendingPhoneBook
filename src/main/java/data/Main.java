package data;

import util.Handler;


public class Main  {

    public static void main(String[] args) {

        Handler handler = new Handler();

        handler.init();


        /**
         * Code below for testing FileChooser and fileIO
         *
        Handler handler = new Handler();

        handler.contactBook.add(new Contact("Sven", "0706875432", "Raka vägen 15", LocalDate.of(1987,12,06), "My note says hi", "svennyboy@gmail.com"));
        handler.contactBook.add(new Contact("Benny", "0706875432", "Snea Vägen 72", LocalDate.of(1997, Month.JULY,4), "En note", "bennyboy@hotmail.com"));

        IOContext ioContext = new IOContext();

        ioContext.setExportIOStrategy(new JsonIOStrategy(handler));

        ioContext.exportTo();

        ioContext.setImportIOStrategy(new JsonIOStrategy(handler));

        ioContext.importTo();

        System.out.println(handler.contactBook);
        System.exit(0);

        */
    }
}