import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateValidationTest {
    
    // Test valid date formats
    @Test
    public void testValidDateStandardFormat() { //Tests a standard date format with dashes
        assertTrue(regexValidator.validDate("12-31-2023"));
    }

    @Test
    public void testValidDateSlashSeparator() { //Tests a standard date format with slashes
        assertTrue(regexValidator.validDate("12/31/2023"));
    }

    @Test
    public void testValidLeapYearDate() { //Tests a leap year date
        assertTrue(regexValidator.validDate("02-29-2024"));
    }

    @Test
    public void testValidEdgeCaseFirstDayOfYear() { //Tests the first day of the year
        assertTrue(regexValidator.validDate("01-01-2023"));
    }

    @Test
    public void testValidEdgeCaseLastDayOfYear() { //Tests the last day of the year
        assertTrue(regexValidator.validDate("12-31-2023"));
    }

    @Test
    public void testValidShortYearFormat() { //Tests a short year format
        assertTrue(regexValidator.validDate("12-31-23"));
    }

    @Test
    public void testValidMonthWithLeadingZero() { //Tests a month with a leading zero
        assertTrue(regexValidator.validDate("02-15-2024"));
    }

    @Test
    public void testValidMonthWithoutLeadingZero() { //Tests a month without a leading zero
        assertTrue(regexValidator.validDate("2-15-2024"));
    }

    // Test invalid date formats
    @Test
    public void testInvalidDateInvalidMonth() { //Tests an invalid month value
        assertFalse(regexValidator.validDate("13-01-2023"));
    }

    @Test
    public void testInvalidDateInvalidDay() { //Tests an invalid day value
        assertFalse(regexValidator.validDate("02-30-2023"));
    }

    @Test
    public void testInvalidDateInvalidLeapYear() { //Tests an invalid leap year date
        assertFalse(regexValidator.validDate("02-29-2023"));
    }

    @Test
    public void testInvalidDateWrongSeparator() { //Tests an incorrect separator
        assertFalse(regexValidator.validDate("12.31.2023"));
    }

    @Test
    public void testInvalidDateNonNumeric() { //Tests a date containing non-numeric characters
        assertFalse(regexValidator.validDate("12-AB-2023"));
    }

    @Test
    public void testInvalidDateEmptyString() { //Tests an empty string
        assertFalse(regexValidator.validDate(""));
    }

    @Test
    public void testInvalidDateMissingComponents() { //Tests a date missing components
        assertFalse(regexValidator.validDate("12-2023"));
    }

    @Test
    public void testInvalidDateOutOfRange() { //Tests a date with out-of-range values
        assertFalse(regexValidator.validDate("00-00-0000"));
    }
}
