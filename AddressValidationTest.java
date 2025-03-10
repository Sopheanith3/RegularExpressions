import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressValidationTest {
    
    // Test valid addresses
    @Test
    public void testValidAddressStandardFormat() { //Tests a standard address format
        assertTrue(regexValidator.validAddress("123 Main Street"));
    }

    @Test
    public void testValidAddressWithAbbreviation() { //Tests abbreviation of street types
        assertTrue(regexValidator.validAddress("456 Maple Ave"));
    }

    @Test
    public void testValidAddressWithFullWordForStreetType() { //Tests full street type name (Boulevard)
        assertTrue(regexValidator.validAddress("789 Oak Boulevard"));
    }

    @Test
    public void testValidAddressWithDirectionalPrefix() { //Tests address with a directional prefix
        assertTrue(regexValidator.validAddress("321 North Washington Street"));
    }

    @Test
    public void testValidAddressWithMultiWordStreetName() { //Tests street name with multiple words
        assertTrue(regexValidator.validAddress("654 Martin Luther King Avenue"));
    }

    @Test
    public void testValidAddressWithApartmentNumber() { //Tests address containing an apartment number
        assertTrue(regexValidator.validAddress("987 Pine Street Apt 4B"));
    }

    @Test
    public void testValidAddressWithUnitNumber() { //Tests address containing a unit number
        assertTrue(regexValidator.validAddress("246 Cedar Road Unit 7"));
    }

    @Test
    public void testValidAddressWithDirectionalAndAbbreviation() { //Tests address with a directional prefix and an abbreviated street type
        assertTrue(regexValidator.validAddress("135 South Park Blvd"));
    }

    // Test invalid addresses
    @Test
    public void testInvalidAddressMissingStreetNumber() { //Tests an address missing a street number
        assertFalse(regexValidator.validAddress("Main Street"));
    }

    @Test
    public void testInvalidAddressWithSpecialCharacters() { //Tests an address containing special characters
        assertFalse(regexValidator.validAddress("123! Main Street#"));
    }

    @Test
    public void testInvalidAddressEmptyString() { //Tests an empty string as an address
        assertFalse(regexValidator.validAddress(""));
    }

    @Test
    public void testInvalidAddressOnlyNumbers() { //Tests an address that only contains numbers
        assertFalse(regexValidator.validAddress("12345"));
    }

    @Test
    public void testInvalidAddressWithUnrecognizedStreetType() { //Tests an invalid street type that is not recognized
        assertFalse(regexValidator.validAddress("456 Main Roadway"));
    }

    @Test
    public void testInvalidAddressNumericStreetName() { //Tests an invalid numeric street name
        assertFalse(regexValidator.validAddress("789 123 Street"));
    }

    @Test
    public void testInvalidAddressWithExcessiveSpaces() { //Tests an address with excessive spaces between words
        assertFalse(regexValidator.validAddress("321   Main    Street"));
    }

    @Test
    public void testInvalidAddressWithSymbols() { //Tests an address containing symbols
        assertFalse(regexValidator.validAddress("654 Main & Street"));
    }
}
