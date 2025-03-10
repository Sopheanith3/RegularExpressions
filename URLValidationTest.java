import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class URLValidationTest {
    @Test
    public void testValidURLHttps() { // Test valid URL with HTTPS protocol
        assertTrue(regexValidator.validURL("https://www.example.com"));
    }

    @Test
    public void testValidURLHttp() { // Test valid URL with HTTP protocol
        assertTrue(regexValidator.validURL("http://example.com"));
    }

    @Test
    public void testValidURLNoProtocol() { // Test valid URL without any protocol
        assertTrue(regexValidator.validURL("www.example.com"));
    }

    @Test
    public void testValidURLWithSubdomain() { // Test valid URL with subdomain
        assertTrue(regexValidator.validURL("https://subdomain.example.co.uk"));
    }

    @Test
    public void testValidURLWithPort() { // Test valid URL with a port number
        assertTrue(regexValidator.validURL("http://localhost:8080"));
    }

    @Test
    public void testValidURLWithPath() { // Test valid URL with a path
        assertTrue(regexValidator.validURL("https://example.com/path/to/page"));
    }

    @Test
    public void testValidURLWithQueryParams() { // Test valid URL with query parameters
        assertTrue(regexValidator.validURL("https://example.com/search?q=test&page=1"));
    }

    @Test
    public void testValidURLMixedCase() { // Test valid URL with mixed case in the domain
        assertTrue(regexValidator.validURL("HTTPS://Example.COM"));
    }

    // Invalid URL Tests
    @Test
    public void testInvalidURLMissingDomain() { // Test invalid URL with missing domain
        assertFalse(regexValidator.validURL("https://"));
    }

    @Test
    public void testInvalidURLInvalidProtocol() { // Test invalid URL with an unsupported protocol
        assertFalse(regexValidator.validURL("ftp://example.com"));
    }

    @Test
    public void testInvalidURLMissingDot() { // Test invalid URL missing a dot in the domain name
        assertFalse(regexValidator.validURL("https://examplecom"));
    }

    @Test
    public void testInvalidURLInvalidChars() { // Test invalid URL with invalid characters in the domain
        assertFalse(regexValidator.validURL("https://example!.com"));
    }

    @Test
    public void testInvalidURLSpaces() { // Test invalid URL with spaces in the domain
        assertFalse(regexValidator.validURL("https://example domain.com"));
    }

    @Test
    public void testInvalidURLEmptyString() { // Test invalid URL with an empty string
        assertFalse(regexValidator.validURL(""));
    }

    @Test
    public void testInvalidURLOnlyProtocol() { // Test invalid URL with only the protocol and no domain
        assertFalse(regexValidator.validURL("https://"));
    }

    @Test
    public void testInvalidURLInvalidTopLevelDomain() { // Test invalid URL with an invalid top-level domain
        assertFalse(regexValidator.validURL("https://example.invalidtld"));
    }
}
