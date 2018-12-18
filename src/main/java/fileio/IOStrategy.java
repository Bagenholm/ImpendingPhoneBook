package fileio;

import java.io.File;

public interface IOStrategy {

    void exportTo(File fileFromFileChooser, int choice);

    void importFrom(File fileFromFileChooser);

}
