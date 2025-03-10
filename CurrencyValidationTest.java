import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyValidationTest {
    
    // Test valid currency formats
    @Test
    public void testValidCurrencySimpleValue() { //Tests a simple currency value with two decimal numbers
        assertTrue(regexValidator.validUSCurrency("$100.00"));
    }

    @Test
    public void testValidCurrencyWithCommas() { //Tests a large currency value with commas 
        assertTrue(regexValidator.validUSCurrency("$1,234,567.89"));
    }

    @Test
    public void testValidCurrencyWholeNumber() { //Tests a whole number without decimal places
        assertTrue(regexValidator.validUSCurrency("$500"));
    }

    @Test
    public void testValidCurrencyNegativeValue() { //Tests a negative currency value
        assertTrue(regexValidator.validUSCurrency("-$100.00"));
    }

    @Test
    public void testValidCurrencyLargeNumber() { //Tests a large currency value with commas and decimal places
        assertTrue(regexValidator.validUSCurrency("$123,456,789.00"));
    }

    @Test
    public void testValidCurrencyCentsOnly() { //Tests a currency value with only cents
        assertTrue(regexValidator.validUSCurrency("$0.99"));
    }

    @Test
    public void testValidCurrencyZero() { //Tests a zero currency value
        assertTrue(regexValidator.validUSCurrency("$0.00"));
    }

    @Test
    public void testValidCurrencyWithoutCents() { //Tests a currency value without cents
        assertTrue(regexValidator.validUSCurrency("$1,000"));
    }

    // Test invalid currency formats
    @Test
    public void testInvalidCurrencyMissingDollarSign() { //Tests a missing dollar sign
        assertFalse(regexValidator.validUSCurrency("100.00"));
    }

    @Test
    public void testInvalidCurrencyInvalidFormat() { //Tests an incorrectly formatted currency value
        assertFalse(regexValidator.validUSCurrency("$100,00"));
    }

    @Test
    public void testInvalidCurrencyTooManyCents() { //Tests a currency value with more than two decimal places
        assertFalse(regexValidator.validUSCurrency("$100.001"));
    }

    @Test
    public void testInvalidCurrencyNonNumericChars() { //Tests a currency value containing non-numeric characters
        assertFalse(regexValidator.validUSCurrency("$10A.00"));
    }

    @Test
    public void testInvalidCurrencyMultipleDollarSigns() { //Tests a currency value with multiple dollar signs
        assertFalse(regexValidator.validUSCurrency("$$100.00"));
    }

    @Test
    public void testInvalidCurrencyInvalidCommaPlacement() { //Tests an invalid comma placement in the currency value
        assertFalse(regexValidator.validUSCurrency("$1,00.00"));
    }

    @Test
    public void testInvalidCurrencyEmptyString() { //Tests an empty string
        assertFalse(regexValidator.validUSCurrency(""));
    }

    @Test
    public void testInvalidCurrencySpaces() { //Tests a currency value with spaces after the dollar sign
        assertFalse(regexValidator.validUSCurrency("$ 100.00"));
    }
}
