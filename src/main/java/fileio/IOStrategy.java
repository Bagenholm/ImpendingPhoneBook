package fileio;

import java.io.File;

public interface IOStrategy {

    void exportTo(File fileFromFileChooser);

    void importTo(File fileFromFileChooser);

}
