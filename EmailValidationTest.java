import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidationTest {

    @Test 
    void testValidEmailSimple() { //Tests a simple email format
        assertTrue(regexValidator.validEmail("john.doe@example.com"));
    }

    @Test 
    void testValidEmailWithNumbers() { //Tests an email containing numbers in the local part
        assertTrue(regexValidator.validEmail("user123@domain.net"));
    }

    @Test 
    void testValidEmailWithUnderscore() { //Tests an email containing an underscore
        assertTrue(regexValidator.validEmail("user_name@example.org"));
    }

    @Test 
    void testValidEmailWithDash() { //Tests an email containing a hyphen in the local part
        assertTrue(regexValidator.validEmail("user-name@domain.com"));
    }

    @Test 
    void testValidEmailWithSubdomain() { //Tests an email with a subdomain
        assertTrue(regexValidator.validEmail("contact@sub.example.co.uk"));
    }

    @Test
    void testValidEmailWithLongTLD() { //Tests an email with a long top-level domain (TLD)
        assertTrue(regexValidator.validEmail("person@company.travel"));
    }

    @Test
    void testValidEmailWithCapitalLetters() { //Tests an email with capital letters
        assertTrue(regexValidator.validEmail("John.Doe@Example.COM"));
    }

    @Test
    void testValidEmailWithNumbersAndHyphens() { //Tests an email with numbers and hyphens
        assertTrue(regexValidator.validEmail("test-email123@company.biz"));
    }

    @Test
    void testInvalidEmailMissingAtSymbol() { //Tests an invalid email missing the '@' symbol
        assertFalse(regexValidator.validEmail("userexample.com"));
    }

    @Test 
    void testInvalidEmailMultipleAtSymbols() { //Tests an invalid email with multiple '@' symbols
        assertFalse(regexValidator.validEmail("user@@example.com"));
    }

    @Test 
    void testInvalidEmailStartingWithDot() { //Tests an invalid email starting with a dot
        assertFalse(regexValidator.validEmail(".user@example.com"));
    }

    @Test
    void testInvalidEmailEndingWithDot() { //Tests an invalid email ending with a dot before @
        assertFalse(regexValidator.validEmail("user.@example.com"));
    }

    @Test
    void testInvalidEmailNoDomain() { //Tests an invalid email with no domain name
        assertFalse(regexValidator.validEmail("user@.com"));
    }

    @Test
    void testInvalidEmailInvalidCharacters() { //Tests an invalid email containing special characters
        assertFalse(regexValidator.validEmail("user!name@example.com"));
    }

    @Test
    void testInvalidEmailDoubleDots() { //Tests an invalid email with consecutive dots in the local part
        assertFalse(regexValidator.validEmail("user..name@example.com"));
    }

    @Test
    void testInvalidEmailNoTLD() { //Tests an invalid email missing a domain
        assertFalse(regexValidator.validEmail("user@example"));
    }
}
