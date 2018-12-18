package fileio;

public class IOContext {

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
            exportIOStrategy.exportTo(FileSelector.chooseJsonFileSave());
        }
        else if (exportIOStrategy instanceof ImageIOStrategy) {
            exportIOStrategy.exportTo(FileSelector.chooseImageFileSave());
        }
        else {
            System.out.println("no strategy set, cannot execute command");
        }
    }

    public void importTo() {

        if(importIOStrategy instanceof JsonIOStrategy){
            importIOStrategy.importTo(FileSelector.chooseJsonFileLoad());
        }
        else if (importIOStrategy instanceof ImageIOStrategy) {
            importIOStrategy.importTo(FileSelector.chooseImageFileLoad());
        }
        else {
            System.out.println("no strategy set, cannot execute command");
        }

    }
}
