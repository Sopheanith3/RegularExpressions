import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MilitaryTimeValidationTest {
    @Test
    public void testValidMilitaryTimeMidnight() { // Test valid military time for midnight (0000)
        assertTrue(regexValidator.validMilitaryTime("0000"));
    }

    @Test
    public void testValidMilitaryTimeNoon() { // Test valid military time for noon (1200)
        assertTrue(regexValidator.validMilitaryTime("1200"));
    }

    @Test
    public void testValidMilitaryTimeEarlyMorning() { // Test valid military time for early morning (0530)
        assertTrue(regexValidator.validMilitaryTime("0530"));
    }

    @Test
    public void testValidMilitaryTimeSingleDigitHour() { // Test valid military time with a single-digit hour (0900)
        assertTrue(regexValidator.validMilitaryTime("0900"));
    }

    @Test
    public void testValidMilitaryTimeFullDay() { // Test valid military time for the last minute of the day (2359)
        assertTrue(regexValidator.validMilitaryTime("2359"));
    }

    @Test
    public void testValidMilitaryTimeEveningTime() { // Test valid military time for evening time (1845)
        assertTrue(regexValidator.validMilitaryTime("1845"));
    }

    @Test
    public void testValidMilitaryTimeLeadingZero() { // Test valid military time with a leading zero (0005)
        assertTrue(regexValidator.validMilitaryTime("0005"));
    }

    @Test
    public void testValidMilitaryTimeSingleDigitMinute() { // Test valid military time with a single-digit minute (1205)
        assertTrue(regexValidator.validMilitaryTime("1205"));
    }

    @Test
    public void testInvalidMilitaryTimeInvalidHour() { // Test invalid military time with an invalid hour (2460)
        assertFalse(regexValidator.validMilitaryTime("2460"));
    }

    @Test
    public void testInvalidMilitaryTimeInvalidMinute() { // Test invalid military time with an invalid minute (1260)
        assertFalse(regexValidator.validMilitaryTime("1260"));
    }

    @Test
    public void testInvalidMilitaryTimeNonNumeric() { // Test invalid military time with non-numeric characters (12AB)
        assertFalse(regexValidator.validMilitaryTime("12AB"));
    }

    @Test
    public void testInvalidMilitaryTimeTooShort() { // Test invalid military time that is too short (123)
        assertFalse(regexValidator.validMilitaryTime("123"));
    }

    @Test
    public void testInvalidMilitaryTimeTooLong() { // Test invalid military time that is too long (123456)
        assertFalse(regexValidator.validMilitaryTime("123456"));
    }

    @Test
    public void testInvalidMilitaryTimeWithColon() { // Test invalid military time with a colon (12:30)
        assertFalse(regexValidator.validMilitaryTime("12:30"));
    }

    @Test
    public void testInvalidMilitaryTimeEmpty() { // Test invalid military time with an empty string
        assertFalse(regexValidator.validMilitaryTime(""));
    }

    @Test
    public void testInvalidMilitaryTimeNegative() { // Test invalid military time with a negative sign (-1200)
        assertFalse(regexValidator.validMilitaryTime("-1200"));
    }
}
