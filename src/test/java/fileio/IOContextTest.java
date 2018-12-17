package fileio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IOContextTest {

    @Test
    void setImportIOStrategyToNull() {

        IOContext ioContext = new IOContext();
        assertThrows(IllegalArgumentException.class, () -> ioContext.setImportIOStrategy(null));
    }

    @Test
    void setExportIOStrategyToNull() {

        IOContext ioContext = new IOContext();
        assertThrows(IllegalArgumentException.class, () -> ioContext.setExportIOStrategy(null));
    }

    @Test
    void NoExceptionWhenChoosingExportToWithoutSelectingStrategy() {

        IOContext ioContext = new IOContext();
        ioContext.exportTo();
        assertFalse(false);
    }

    @Test
    void NoExceptionWhenChoosingImportToWithoutSelectingStrategy() {

        IOContext ioContext = new IOContext();
        ioContext.importTo();
        assertFalse(false);

    }
}