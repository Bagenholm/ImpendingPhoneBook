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

        if (exportIOStrategy!=null) {
            exportIOStrategy.exportTo();
        }
        else {
            System.out.println("no strategy set, cannot execute command");
        }
    }

    public void importTo() {

        if(importIOStrategy!=null){
            importIOStrategy.importTo();
        }
        else {
            System.out.println("no strategy set, cannot execute command");
        }

    }
}
