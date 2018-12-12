package fileio;

import java.io.File;

public class IOContext {

    private ExportStrategy exportStrategy;
    private ImportStrategy importStrategy;

    public void setExportStrategy(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public void setImportStrategy(ImportStrategy importStrategy) {
        this.importStrategy = importStrategy;
    }

    public void exportFile(File file) {
      //  exportStrategy.exportTo(file);

    }

    public File importStrategy(File file) {

     return null;
    }
}
