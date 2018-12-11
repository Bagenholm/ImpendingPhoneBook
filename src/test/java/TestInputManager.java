import org.junit.jupiter.api.Test;
import util.InputManager;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TestInputManager {

    InputManager input = new InputManager();

    @Test
    void testDateFormatAcceptsCorrectDate8chars() {
        LocalDate date = input.checkDateFormat("19871206");
        assertEquals("1987-12-06", date.toString());
    }

    @Test
    void testDateFormatAcceptsCorrectDate6chars() {
        LocalDate date = input.checkDateFormat("850213");
        assertEquals("1985-02-13", date.toString());
    }

    @Test
    void testDateFormatAcceptsCorrectDate6charsBelow19() {
        LocalDate date = input.checkDateFormat("170225");
        assertEquals("2017-02-25", date.toString());
    }

    @Test
    void testVerifyIntFormatReturnsInt() {
        int i = input.verifyIntFormat("5");
        assertEquals(5, i);
    }

}