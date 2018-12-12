package fileio;

import fileio.FileReader;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestFileReader {

    @Test
    void readFromJsonReturnsNullWhenNoFileMatch() {
     assertNull(FileReader.readFromJson("45648918949818915616aeg6ea1g6ea1g6"));

    }

    @Test
    void throwsExceptionIfStringIsNull() {

        assertThrows(IllegalArgumentException.class, () -> FileReader.readFromJson(null) );

    }



}
