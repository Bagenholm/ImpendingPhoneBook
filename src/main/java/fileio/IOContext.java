package fileio;

public class IOContext {

    private IOStrategy importIOStrategy;
    private IOStrategy exportIOStrategy;

    public void setImportIOStrategy(IOStrategy importIOStrategy) {
        this.importIOStrategy = importIOStrategy;
    }

    public void setExportIOStrategy(IOStrategy exportIOStrategy) {
        this.exportIOStrategy = exportIOStrategy;
    }

    public void exportTo() {
        exportIOStrategy.exportTo();
    }

    public void importFrom() {

        importIOStrategy.importTo();

    }
}
