package fileio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IOContextTest {

    @Test
    void setImportIOStrategyToNull() {

        IOContext ioContext = IOContext.createIOContext();
        assertThrows(IllegalArgumentException.class, () -> ioContext.setImportIOStrategy(null));
    }

    @Test
    void setExportIOStrategyToNull() {

        IOContext ioContext = IOContext.createIOContext();
        assertThrows(IllegalArgumentException.class, () -> ioContext.setExportIOStrategy(null));
    }

    @Test
    void NoExceptionWhenChoosingExportToWithoutSelectingStrategy() {

        IOContext ioContext = IOContext.createIOContext();
        ioContext.exportTo();
        assertFalse(false);
    }

    @Test
    void NoExceptionWhenChoosingImportToWithoutSelectingStrategy() {

        IOContext ioContext = IOContext.createIOContext();
        ioContext.importTo();
        assertFalse(false);

    }


}