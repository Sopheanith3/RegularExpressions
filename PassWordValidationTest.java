import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassWordValidationTest {

    @Test
    public void testValidPasswordMinimumLength() { 
        assertTrue(regexValidator.validPassword("Abc!123456")); // Exactly 10 characters, meets all conditions
    }

    @Test
    public void testValidPasswordExceedsMinimumLength() { 
        assertTrue(regexValidator.validPassword("XyZ!45678abc")); // More than 10 characters, still valid
    }

    @Test
    public void testValidPasswordWithMaxConsecutiveLowercase() { 
        assertTrue(regexValidator.validPassword("Aabc!123DEF")); // 3 consecutive lowercase allowed
    }

    @Test
    public void testValidPasswordWithMixedCases() { 
        assertTrue(regexValidator.validPassword("Pass1!WordX")); // Proper mix of upper, lower, digit, punctuation
    }

    @Test
    public void testValidPasswordWithSinglePunctuation() { 
        assertTrue(regexValidator.validPassword("Secure!2Pass12")); // Uses exactly one punctuation mark
    }

    @Test
    public void testValidPasswordWithMultipleDigits() { 
        assertTrue(regexValidator.validPassword("Strong!9876Abc")); // Extra numbers but still valid
    }

    @Test
    public void testValidPasswordWithDifferentPunctuation() { 
        assertTrue(regexValidator.validPassword("Hello!123World")); // '@' as punctuation
    }

    @Test
    public void testValidPasswordWithDifferentPunctuation2() { 
        assertTrue(regexValidator.validPassword("XyZ!45678abc")); // '#' as punctuation
    }

    @Test
    public void testInvalidPasswordTooShort() { 
        assertFalse(regexValidator.validPassword("Ab1!cde")); // Less than 10 characters
    }

    @Test
    public void testInvalidPasswordMissingUppercase() { 
        assertFalse(regexValidator.validPassword("abcdef!1234")); // No uppercase letter
    }

    @Test
    public void testInvalidPasswordMissingLowercase() { 
        assertFalse(regexValidator.validPassword("ABCDEF!1234")); // No lowercase letter
    }

    @Test
    public void testInvalidPasswordMissingDigit() { 
        assertFalse(regexValidator.validPassword("Abcdefgh!X")); // No digit
    }

    @Test
    public void testInvalidPasswordMissingPunctuation() { 
        assertFalse(regexValidator.validPassword("Abcdef12345")); // No punctuation
    }

    @Test
    public void testInvalidPasswordTooManyConsecutiveLowercase() { 
        assertFalse(regexValidator.validPassword("Abcdeeee!123")); // More than 3 consecutive lowercase letters
    }

    @Test
    public void testInvalidPasswordTooManyConsecutiveLowercase2() { 
        assertFalse(regexValidator.validPassword("Abcdaaaa!123")); // More than 3 consecutive lowercase letters
    }

    @Test
    public void testInvalidPasswordWithMultiplePunctuation() { 
        assertFalse(regexValidator.validPassword("Secure!Pass@12")); // More than one punctuation mark
    }

    @Test
    public void testInvalidPasswordWithOnlyLettersNoDigitOrPunctuation() { 
        assertFalse(regexValidator.validPassword("Abcdefghijkl")); // No digit, no punctuation
    }

    @Test
    public void testInvalidPasswordWithOnlyDigitsAndNoLetters() { 
        assertFalse(regexValidator.validPassword("1234567890!")); // No upper/lowercase letters
    }

    @Test
    public void testInvalidPasswordWithOnlyPunctuationAndLetters() { 
        assertFalse(regexValidator.validPassword("Abcdef!!!")); // No digit
    }

    @Test
    public void testInvalidPasswordWithSpaces() { 
        assertFalse(regexValidator.validPassword("Abc 123!XYZ")); // Spaces should not be allowed
    }

    @Test
    public void testInvalidPasswordWithTabs() { 
        assertFalse(regexValidator.validPassword("Abc\t123!XYZ")); // Tabs should not be allowed
    }

    @Test
    public void testInvalidPasswordWithNewlineCharacters() { 
        assertFalse(regexValidator.validPassword("Abc\n123!XYZ")); // Newlines should not be allowed
    }

    @Test
    public void testInvalidPasswordWithTooManyConsecutiveRepeatingCharacters() { 
        assertFalse(regexValidator.validPassword("Aaaab!123X")); // More than 3 consecutive 'a' characters
    }

    @Test
    public void testInvalidPasswordWithOnlyUppercaseLetters() { 
        assertFalse(regexValidator.validPassword("HELLO123!X")); // No lowercase letter
    }
}
