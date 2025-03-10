import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SSNValidationTest {
    
    @Test
    void testValidSSNAllDigits() { // Test valid SSN with all digits (123456789)
        assertTrue(regexValidator.validSSN("123456789"));
    }
    
    @Test
    void testValidSSNDashes() { // Test valid SSN with dashes (123-45-6789)
        assertTrue(regexValidator.validSSN("123-45-6789"));
    }
    
    @Test
    void testValidSSNSpaces() { // Test valid SSN with spaces (123 45 6789)
        assertTrue(regexValidator.validSSN("123 45 6789"));
    }
    
    @Test
    void testValidSSNWithEdgeCaseLowest() { // Test valid SSN with edge case (lowest possible SSN 001-01-0001)
        assertTrue(regexValidator.validSSN("001-01-0001"));
    }
    
    @Test
    void testValidSSNWithEdgeCaseHighest() { // Test valid SSN with edge case (highest possible SSN 899-99-9999)
        assertTrue(regexValidator.validSSN("899-99-9999"));
    }
    
    @Test
    void testValidSSNWithMidRange() { // Test valid SSN with mid-range numbers (456-78-9012)
        assertTrue(regexValidator.validSSN("456-78-9012"));
    }
    
    @Test
    void testValidSSNWithDifferentNumbers() { // Test valid SSN with different numbers (212-58-4567)
        assertTrue(regexValidator.validSSN("212-58-4567"));
    }
    
    @Test
    void testValidSSNWithSpecialCase() { // Test valid SSN with a special case (078-05-1120)
        assertTrue(regexValidator.validSSN("078-05-1120"));
    }
    
    @Test
    void testInvalidSSNAllZeroes() { // Test invalid SSN with all zeroes (000-00-0000)
        assertFalse(regexValidator.validSSN("000-00-0000"));
    }
    
    @Test
    void testInvalidSSNStartsWith666() { // Test invalid SSN starting with 666 (666-00-1234)
        assertFalse(regexValidator.validSSN("666-00-1234"));
    }
    
    @Test
    void testInvalidSSNWithLetters() { // Test invalid SSN with letters (abc-de-ghij)
        assertFalse(regexValidator.validSSN("abc-de-ghij"));
    }
    
    @Test
    void testInvalidSSNTooManyDigits() { // Test invalid SSN with too many digits (999-99-99999)
        assertFalse(regexValidator.validSSN("999-99-99999"));
    }
    
    @Test
    void testInvalidSSNTooFewDigits() { // Test invalid SSN with too few digits (123-45-67)
        assertFalse(regexValidator.validSSN("123-45-67"));
    }
    
    @Test
    void testInvalidSSNWrongSeparators() { // Test invalid SSN with wrong separators (123.45.6789)
        assertFalse(regexValidator.validSSN("123.45.6789"));
    }
    
    @Test
    void testInvalidSSNWithInvalidAreaNumber() { // Test invalid SSN with invalid area number (900-12-3456)
        assertFalse(regexValidator.validSSN("900-12-3456"));
    }
    
    @Test
    void testInvalidSSNEmptyString() { // Test invalid SSN with empty string
        assertFalse(regexValidator.validSSN(""));
    }

    // Extra credit tests for SSN numbering rules
    @Test
    public void testInvalidSSNZeroGroup() { // Test invalid SSN with zero group (000-00-0000)
        assertFalse(regexValidator.validSSN("000-00-0000"));
    }

    @Test
    public void testInvalidSSNInvalidPrefix() { // Test invalid SSN with invalid prefix (666-12-3456)
        assertFalse(regexValidator.validSSN("666-12-3456"));
    }
}
