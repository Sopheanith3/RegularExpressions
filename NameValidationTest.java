import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NameValidationTest {
    @Test
    void testValidNameWithoutMiddleInitial() { // Test valid name without middle initial (Smith, John)
        assertTrue(regexValidator.validName("Smith, John"));
    }

    @Test
    void testValidNameWithMiddleInitial() { // Test valid name with middle initial (Smith, John L)
        assertTrue(regexValidator.validName("Smith, John L"));
    }

    @Test
    void testValidNameWithDoubleLastName() { // Test valid name with double last name (Smith-Jones, Mary K)
        assertTrue(regexValidator.validName("Smith-Jones, Mary K"));
    }

    @Test
    void testValidNameWithApostrophe() { // Test valid name with apostrophe in last name (O'Connor, Liam P)
        assertTrue(regexValidator.validName("O'Connor, Liam P"));
    }

    @Test
    void testValidNameWithMultipleMiddleInitials() { // Test valid name with multiple middle initials (Brown, Sarah J K)
        assertTrue(regexValidator.validName("Brown, Sarah J K"));
    }

    @Test
    void testValidNameWithHyphenatedFirstName() { // Test valid name with hyphenated first name (Lee, Anne-Marie)
        assertTrue(regexValidator.validName("Lee, Anne-Marie"));
    }

    @Test
    void testValidNameWithMiddleInitialLowerCase() { // Test invalid name with lowercase middle initial (Smith, John l)
        assertFalse(regexValidator.validName("Smith, John l"));
    }

    @Test
    void testValidNameWithExtraSpaces() { // Test invalid name with extra spaces around name (  Smith, John  )
        assertFalse(regexValidator.validName("  Smith, John  "));
    }

    @Test
    void testInvalidNameMissingComma() { // Test invalid name missing a comma (Smith John)
        assertFalse(regexValidator.validName("Smith John"));
    }

    @Test
    void testInvalidNameWithNumbers() { // Test invalid name containing numbers (Johnson, Mark 2)
        assertFalse(regexValidator.validName("Johnson, Mark 2"));
    }

    @Test
    void testInvalidNameWithSpecialCharacters() { // Test invalid name with special characters (Doe, @lice)
        assertFalse(regexValidator.validName("Doe, @lice"));
    }

    @Test
    void testInvalidNameOnlyComma() { // Test invalid name with only a comma (,)
        assertFalse(regexValidator.validName(","));
    }

    @Test
    void testInvalidNameMiddleInitialTooLong() { // Test invalid name with a middle initial too long (Davis, Chris XYZ)
        assertFalse(regexValidator.validName("Davis, Chris XYZ"));
    }

    @Test
    void testInvalidNameOnlyFirstName() { // Test invalid name with only a first name (John)
        assertFalse(regexValidator.validName("John"));
    }

    @Test
    void testInvalidNameOnlyLastName() { // Test invalid name with only a last name (Smith,)
        assertFalse(regexValidator.validName("Smith,"));
    }
}
