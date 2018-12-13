package fileio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSelectorTest {

    @Test
    void nullInGetFileForSave() {

        assertNull(FileSelector.getFileForLoad(null));

    }

    @Test
    void nullInGetFileForLoad() {

        assertNull(FileSelector.getFileForLoad(null));
    }
}