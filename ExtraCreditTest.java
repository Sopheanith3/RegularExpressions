import org.junit.Test;
import static org.junit.Assert.*;

public class ExtraCreditTest {
    // SSN Extra Credit Tests - Testing SSA numbering rules
    @Test
    public void testInvalidSSNArea666() {
        assertFalse(regexValidator.validSSN("666-45-6789"));
    }

    @Test
    public void testInvalidSSNArea000() {
        assertFalse(regexValidator.validSSN("000-45-6789"));
    }

    @Test
    public void testInvalidSSNArea900() {
        assertFalse(regexValidator.validSSN("900-45-6789"));
    }

    @Test
    public void testInvalidSSNArea999() {
        assertFalse(regexValidator.validSSN("999-45-6789"));
    }

    @Test
    public void testValidSSNAreaNumber() {
        assertTrue(regexValidator.validSSN("123-45-6789"));
    }

    @Test
    public void testInvalidSSNGroup00() {
        assertFalse(regexValidator.validSSN("123-00-6789"));
    }

    @Test
    public void testInvalidSSNSerial0000() {
        assertFalse(regexValidator.validSSN("123-45-0000"));
    }

    @Test
    public void testValidSSNBoundaryArea() {
        assertTrue(regexValidator.validSSN("899-45-6789"));
    }

    // Phone Number Extra Credit Tests - Testing official area codes
    @Test
    public void testValidAreaCode212() {
        assertTrue(regexValidator.validPhoneNumber("(212)555-1234")); // NYC
    }

    @Test
    public void testValidAreaCode415() {
        assertTrue(regexValidator.validPhoneNumber("(415)555-1234")); // San Francisco
    }

    @Test
    public void testValidAreaCode305() {
        assertTrue(regexValidator.validPhoneNumber("(305)555-1234")); // Miami
    }

    @Test
    public void testInvalidAreaCode000() {
        assertFalse(regexValidator.validPhoneNumber("(000)555-1234"));
    }

    @Test
    public void testInvalidAreaCode001() {
        assertFalse(regexValidator.validPhoneNumber("(001)555-1234"));
    }

    @Test
    public void testInvalidAreaCode123() {
        assertFalse(regexValidator.validPhoneNumber("(123)555-1234")); // Invalid area code
    }

    @Test
    public void testInvalidAreaCode999() {
        assertFalse(regexValidator.validPhoneNumber("(999)555-1234"));
    }

    @Test
    public void testInvalidAreaCodeAlpha() {
        assertFalse(regexValidator.validPhoneNumber("(ABC)555-1234"));
    }

    // State Abbreviation Extra Credit Tests
    @Test
    public void testValidStateWA() {
        assertTrue(regexValidator.validLocation("Seattle, WA 98101"));
    }

    @Test
    public void testValidStateNY() {
        assertTrue(regexValidator.validLocation("New York, NY 10001"));
    }

    @Test
    public void testValidStateCA() {
        assertTrue(regexValidator.validLocation("Los Angeles, CA 90001"));
    }

    @Test
    public void testInvalidStateXX() {
        assertFalse(regexValidator.validLocation("Invalid, XX 12345"));
    }

    @Test
    public void testInvalidState00() {
        assertFalse(regexValidator.validLocation("Invalid, 00 12345"));
    }

    @Test
    public void testInvalidStateLowercase() {
        assertFalse(regexValidator.validLocation("Invalid, wa 12345"));
    }

    @Test
    public void testInvalidStateMixedCase() {
        assertFalse(regexValidator.validLocation("Invalid, Wa 12345"));
    }

    @Test
    public void testInvalidStateThreeLetters() {
        assertFalse(regexValidator.validLocation("Invalid, WAA 12345"));
    }
}