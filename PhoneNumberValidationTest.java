import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PhoneNumberValidationTest {
    
    @Test
    void testValidPhoneNumberWithDashes() { // Test valid phone number with dashes (213-456-7890)
        assertTrue(regexValidator.validPhoneNumber("213-456-7890")); 
    }
    
    @Test
    void testValidPhoneNumberWithDots() { // Test valid phone number with dots (415.456.7890)
        assertTrue(regexValidator.validPhoneNumber("415.456.7890")); 
    }
    
    @Test
    void testValidPhoneNumberWithSpaces() { // Test valid phone number with spaces (718 456 7890)
        assertTrue(regexValidator.validPhoneNumber("718 456 7890")); 
    }
    
    @Test
    void testValidPhoneNumberWithParentheses() { // Test valid phone number with parentheses (503) 456-7890
        assertTrue(regexValidator.validPhoneNumber("(503) 456-7890")); 
    }
    
    @Test
    void testValidPhoneNumberWithCountryCode() { // Test valid phone number with country code (+1 646-456-7890)
        assertTrue(regexValidator.validPhoneNumber("+1 646-456-7890")); 
    }
    
    @Test
    void testValidPhoneNumberWithoutSeparators() { // Test valid phone number without separators (8184567890)
        assertTrue(regexValidator.validPhoneNumber("8184567890")); 
    }
    
    @Test
    void testValidPhoneNumberWithDifferentAreaCode() { // Test valid phone number with different area code (707)999-9999
        assertTrue(regexValidator.validPhoneNumber("(707)999-9999")); 
    }
    
    @Test
    void testValidPhoneNumberWithMidRange() { // Test valid phone number with mid-range area code (212) 555-7890
        assertTrue(regexValidator.validPhoneNumber("(212) 555-7890"));
    }
    
    @Test
    void testInvalidPhoneNumberTooShort() { // Test invalid phone number that is too short (999-9999)
        assertFalse(regexValidator.validPhoneNumber("999-9999"));
    }
    
    @Test
    void testInvalidPhoneNumberWithLetters() { // Test invalid phone number with letters (abcdefghij)
        assertFalse(regexValidator.validPhoneNumber("abcdefghij"));
    }
    
    @Test
    void testInvalidPhoneNumberWrongSeparator() { // Test invalid phone number with wrong separator (123/456/7890)
        assertFalse(regexValidator.validPhoneNumber("123/456/7890"));
    }
    
    @Test
    void testInvalidPhoneNumberExtraDigit() { // Test invalid phone number with extra digit (123-456-78901)
        assertFalse(regexValidator.validPhoneNumber("123-456-78901"));
    }
    
    @Test
    void testInvalidPhoneNumberWithMissingDigit() { // Test invalid phone number with missing digit (123-456-789)
        assertFalse(regexValidator.validPhoneNumber("123-456-789"));
    }
    
    @Test
    void testInvalidPhoneNumberWithExtraCharacters() { // Test invalid phone number with extra characters ((123) 456-7890 x123)
        assertFalse(regexValidator.validPhoneNumber("(123) 456-7890 x123"));
    }
    
    @Test
    void testInvalidPhoneNumberWithInvalidAreaCode() { // Test invalid phone number with invalid area code (000) 456-7890
        assertFalse(regexValidator.validPhoneNumber("(000) 456-7890"));
    }
    
    @Test
    void testInvalidPhoneNumberEmptyString() { // Test invalid phone number with an empty string
        assertFalse(regexValidator.validPhoneNumber(""));
    }
}
