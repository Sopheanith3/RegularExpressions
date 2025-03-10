import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OddWordValidationTest {

    @Test
    public void testValidOddWordShortest() { 
        assertTrue(regexValidator.validlengthWord("ion")); // 3 total letters (odd)
    }

    @Test
    public void testValidOddWordFiveLetters() { 
        assertTrue(regexValidator.validlengthWord("union")); // 5 total letters (odd)
    }

    @Test
    public void testValidOddWordSevenLetters() { 
        assertTrue(regexValidator.validlengthWord("invention")); // 7 total letters (odd)
    }

    @Test
    public void testValidOddWordMixedCase() { 
        assertTrue(regexValidator.validlengthWord("Suppression")); // Case insensitive check
    }

    @Test
    public void testValidOddWordThirteenLetters() { 
        assertTrue(regexValidator.validlengthWord("participation")); // 13 total letters (odd)
    }

    @Test
    public void testValidOddWordNineteenLetters() { 
        assertTrue(regexValidator.validlengthWord("conceptualization")); // 19 total letters (odd)
    }

    @Test
    public void testValidOddWordTwentyThreeLetters() { 
        assertTrue(regexValidator.validlengthWord("Overintellectualization")); // 23 total letters (odd)
    }

    @Test
    public void testValidOddWordWithCapitalization() { 
        assertTrue(regexValidator.validlengthWord("Commercialization")); // Should be case insensitive
    }

    @Test
    public void testInvalidWordWrongEnding() { 
        assertFalse(regexValidator.validlengthWord("motivation")); // not correct length (even)
    }

    @Test
    public void testInvalidWordWithNumbers() { 
        assertFalse(regexValidator.validlengthWord("m0tion")); // Contains a number
    }

    @Test
    public void testInvalidWordWithSpecialCharacters() { 
        assertFalse(regexValidator.validlengthWord("moti@nion")); // Contains special character
    }

    @Test
    public void testInvalidWordWithSpaces() { 
        assertFalse(regexValidator.validlengthWord(" expulsion ")); // Leading/trailing spaces
    }

    @Test
    public void testInvalidWordWithIncorrectPattern() { 
        assertFalse(regexValidator.validlengthWord("bahion")); // Doesn't follow the regex pattern
    }

    @Test
    public void testInvalidWordEvenLengthFourLetters() { 
        assertFalse(regexValidator.validlengthWord("xion")); // 4 letters (even)
    }

    @Test
    public void testInvalidWordEvenLengthFourteenLetters() { 
        assertFalse(regexValidator.validlengthWord("disintegration")); // 14 total letters (even)
    }

    @Test
    public void testInvalidWordNoIonEnding() { 
        assertFalse(regexValidator.validlengthWord("apple")); // Doesn't end in "ion"
    }
}
