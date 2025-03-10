import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationValidationTest {

    @Test
    public void testValidStandardCityStateZip() {
        assertTrue(regexValidator.validLocation("Seattle, WA 98101")); //Test Valid city, state, zip format
    }

    @Test
    public void testValidCityStateZipWithMultiWordCity() {
        assertTrue(regexValidator.validLocation("San Francisco, CA 94105")); //Test Multi-word city
    }

    @Test
    public void testValidCityStateZipWithHyphenatedCity() {
        assertTrue(regexValidator.validLocation("Ann Arbor, MI 48104")); //Test Hyphenated city
    }

    @Test
    public void testValidCityStateZipWithExtendedZip() {
        assertTrue(regexValidator.validLocation("Portland, OR 97201-1234")); //Test Extended zip code
    }

    @Test
    public void testValidCityStateZipWithSpaceInState() {
        assertTrue(regexValidator.validLocation("New York, NY 10001")); //Test Space in state abbreviation
    }

    @Test
    public void testValidCityStateZipLowercaseState() {
        assertTrue(regexValidator.validLocation("Chicago, IL 60601")); //Test Lowercase state
    }

    @Test
    public void testValidCityWithApostrophe() {
        assertTrue(regexValidator.validLocation("O'Fallon, MO 63366")); //Test Apostrophe in city
    }

    @Test
    public void testValidCityStateZipWithAlternateSpacing() {
        assertTrue(regexValidator.validLocation("Denver,CO 80202")); //Test Alternate spacing
    }

    @Test
    public void testInvalidCityStateZipMissingState() {
        assertFalse(regexValidator.validLocation("Seattle 98101")); //Test Missing state
    }

    @Test
    public void testInvalidCityStateZipInvalidStateAbbreviation() {
        assertFalse(regexValidator.validLocation("Seattle, XX 98101")); //Test Invalid state abbreviation
    }

    @Test
    public void testInvalidCityStateZipWrongOrder() {
        assertFalse(regexValidator.validLocation("WA Seattle 98101")); //Test Wrong order
    }

    @Test
    public void testInvalidCityStateZipMissingZip() {
        assertFalse(regexValidator.validLocation("Seattle, WA")); //Test Missing zip code
    }

    @Test
    public void testInvalidCityStateZipInvalidZipFormat() {
        assertFalse(regexValidator.validLocation("Seattle, WA 9810")); //Test Invalid zip format
    }

    @Test
    public void testInvalidCityStateZipSpecialCharacters() {
        assertFalse(regexValidator.validLocation("Seattle! WA 98101")); //Test Special characters in city
    }

    @Test
    public void testInvalidCityStateZipNumericCity() {
        assertFalse(regexValidator.validLocation("123, WA 98101")); //Test Numeric city
    }

    @Test
    public void testInvalidCityStateZipEmptyString() {
        assertFalse(regexValidator.validLocation("")); //Test Empty string
    }
}
