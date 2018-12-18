package fileio;

import util.InputManager;

public class IOContext {

    /**
     * This class sets the IO strategy for saving and loading of files. Using Strategy pattern for this enables
     * us to just run the same export() method but yielding different results if different strategies are set. While this would have been a good idea if implemented
     * when saving to many different file formats it is not that useful when we are only saving to json. Could be useful if we add more file formats to the program.
     * Uses factory model in constructor for simplicity.
     */

    private IOStrategy importIOStrategy;
    private IOStrategy exportIOStrategy;

    private IOContext() {
    }

    public static IOContext createIOContext() {
        return new IOContext();
    }


    public void setImportIOStrategy(IOStrategy importIOStrategy) {
        if (importIOStrategy != null)
        this.importIOStrategy = importIOStrategy;
        else
            throw new IllegalArgumentException("no strategy set");
    }

    public void setExportIOStrategy(IOStrategy exportIOStrategy) {
        if(exportIOStrategy != null)
        this.exportIOStrategy = exportIOStrategy;
        else
            throw new IllegalArgumentException("no strategy set");
    }

    public void exportTo() {

        if (exportIOStrategy instanceof JsonIOStrategy) {

            System.out.println("Do you want to save a contact (1) or the contactBook (2)?");
            int result =  new InputManager().verifyInt(1, 2);

            exportIOStrategy.exportTo(FileSelector.chooseJsonFileSave(), result);
        }


        else {
            System.out.println("no strategy set, cannot execute command");
        }
    }

    public void importTo() {

        if(importIOStrategy instanceof JsonIOStrategy){
            importIOStrategy.importFrom(FileSelector.chooseJsonFileLoad());
        }

        else {
            System.out.println("no strategy set, cannot execute command");
        }

    }
}
