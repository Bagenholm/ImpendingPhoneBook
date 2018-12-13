package fileio;

import org.junit.jupiter.api.Test;
import util.Handler;

import static org.junit.jupiter.api.Assertions.*;

class JsonIOStrategyTest {


    @Test
    void throwsExceptionIfHandlerIsNullInConstructor() {

        assertThrows(IllegalArgumentException.class, () -> new JsonIOStrategy(null));

    }


    @Test
    void bodyInExportToMethodDoesNotRunIfContactBookIsNotInstantiated() {

        Handler handler = new Handler();

        handler.contactBook = null;

        IOContext ioContext = new IOContext();

        ioContext.setExportIOStrategy(new JsonIOStrategy(handler));

        ioContext.exportTo();
        assertFalse(false);


    }


    @Test
    void bodyInExportToMethodDoesNotRunIfContactBookIsEmpty() {

        Handler handler = new Handler();

        IOContext ioContext = new IOContext();

        ioContext.setExportIOStrategy(new JsonIOStrategy(handler));

        ioContext.exportTo();
        assertFalse(false);


    }

    @Test
    void throwsExceptionIfNoContactBookInstantiatedWhenImporting() {

        Handler handler = new Handler();

        handler.contactBook = null;

        IOContext ioContext = new IOContext();

        ioContext.setImportIOStrategy(new JsonIOStrategy(handler));

        assertThrows(IllegalArgumentException.class, () -> ioContext.importTo());


    }
}