import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class regexValidator {

    //SSN Validates 
    public static boolean validSSN(String theSSN) {
        String regex = "^" 
                    + "(?!000|666|9\\d{2})" //First three digit cannot be 000,666, or 900-999
                    + "\\d{3}[-\\s]?" //Three digits followed by optional separator
                    + "(?!00)\\d{2}[-\\s]?" //Two digits, no 00 allowed, and optional separator
                    + "(?!0000)\\d{4}" // Last four digits, cannot be 0000 allowed
                    + "$"; // End of string
        return Pattern.matches(regex, theSSN.replaceAll("\\s", ""));
    }

    // //US Phone Number Validates
    public static boolean validPhoneNumber(String thePhoneNumber) {
        String regex = "^(?:\\+1[ .-]?)?" // Optional country code +1 for the US only
                    + "(\\(?([2-9][0-9]{2})\\)?)" // Area code cannot start with 0 or 1 
                    + "[-. ]?" // Optional separator
                    + "([0-9]{3})[-. ]?([0-9]{4})$"; // Three digits + four digits numbers
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(thePhoneNumber);

        if (matcher.matches()) {
            String areaCode = matcher.group(2);
            return isValidAreaCode(areaCode);
        }
        return false;
    }

    //Helper method for area code for the extra credit
    private static boolean isValidAreaCode(String areaCode) {
        // List of common official area codes 
        String[] validAreaCodes = {
            "201", "202", "203", "205", "206", "207", "208", "209", "210", "212", "213", "214", "215",
            "216", "217", "218", "219", "220", "223", "224", "225", "228", "229", "231", "234", "239",
            "240", "248", "251", "252", "253", "254", "256", "260", "262", "267", "269", "270", "272",
            "276", "281", "283", "301", "302", "303", "304", "305", "307", "308", "309", "310", "312",
            "313", "314", "315", "316", "317", "318", "319", "320", "321", "323", "325", "327", "330",
            "331", "332", "334", "336", "337", "339", "346", "347", "351", "352", "360", "361", "364",
            "380", "385", "386", "401", "402", "404", "405", "406", "407", "408", "409", "410", "412",
            "413", "414", "415", "417", "419", "423", "424", "425", "430", "432", "434", "435", "440",
            "442", "443", "447", "458", "463", "469", "470", "475", "478", "479", "480", "484", "501",
            "502", "503", "504", "505", "507", "508", "509", "510", "512", "513", "515", "516", "517",
            "518", "520", "530", "531", "534", "539", "540", "541", "551", "559", "561", "562", "563",
            "564", "567", "570", "571", "573", "574", "575", "580", "585", "586", "601", "602", "603",
            "605", "606", "607", "608", "609", "610", "612", "614", "615", "616", "617", "618", "619",
            "620", "623", "626", "628", "629", "630", "631", "636", "641", "646", "650", "651", "657",
            "660", "661", "662", "667", "669", "678", "680", "681", "682", "701", "702", "703", "704",
            "706", "707", "708", "712", "713", "714", "715", "716", "717", "718", "719", "720", "724",
            "725", "726", "727", "730", "731", "732", "734", "737", "740", "743", "747", "754", "757",
            "760", "762", "763", "765", "769", "770", "772", "773", "774", "775", "779", "781", "785",
            "786", "801", "802", "803", "804", "805", "806", "808", "810", "812", "813", "814", "815",
            "816", "817", "818", "828", "830", "831", "832", "843", "845", "847", "848", "850", "856",
            "857", "858", "859", "860", "862", "863", "864", "865", "870", "872", "878", "901", "903",
            "904", "906", "907", "908", "909", "910", "912", "913", "914", "915", "916", "917", "918",
            "919", "920", "925", "928", "929", "931", "936", "937", "938", "940", "941", "947", "949",
            "951", "952", "954", "956", "959", "970", "971", "972", "973", "978", "979", "980", "984",
            "985", "989"
        };
        for (String validCode : validAreaCodes) {
            if (validCode.equals(areaCode)) {
                return true;
            }
        }
        return false;
    }
    
    //Email address Validates
    public static boolean validEmail(String theEmail) {
        String regex = "^(?!.*@.*@)" // No multiple '@' symbols
                    + "(?!\\.)" // No leading '.'
                    + "(?!.*\\.\\.)" // No consecutive like two periods ..
                    + "([a-zA-Z0-9._%+-]*[^.])" // Local part
                    + "@([a-zA-Z0-9.-]+)" // Domain name
                    + "\\.[a-zA-Z]{2,}$"; // Top-level domain
        return Pattern.matches(regex, theEmail);
    }

    //First and Last name validates
    public static boolean validName(String theName) {
        String regex = "^[A-Z][a-zA-Z'-]+(?:[-'][a-zA-Z]+)*" // First name
                     + ",\\s[A-Z][a-zA-Z'-]+" // Last name
                     + "(?:\\s[A-Z](?:[a-zA-Z])?)*$"; // Optional middle initial
        return Pattern.matches(regex, theName);
    }    

    //MMDDYYYY Validates date format
    public static boolean validDate(String theDate) {
        String regex = "^(0[1-9]|1[0-2]|[1-9])" // Month (01-12)
                     + "[-/](0[1-9]|[12]\\d|3[01]|[1-9])" // Day (01-31)
                     + "[-/](\\d{2}|\\d{4})$"; // Year with 2 or 4 digits
        if (!Pattern.matches(regex, theDate)) return false;
        try {
            theDate = theDate.replace('/', '-');
            String[] format = theDate.split("-");
            int month = Integer.parseInt(format[0]);
            int day = Integer.parseInt(format[1]);
            int year = Integer.parseInt(format[2]);
            LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //House Address Validate format
    public static boolean validAddress(String theAddress) {
        String regex = "^(?!.*\\s{2,})" // No double spaces
                     + "\\d+\\s+" // House number
                     + "(?:[a-zA-Z]+\\s+)*[a-zA-Z]+" // Street name
                     + "(?:\\s+(?:North|South|East|West|N|S|E|W))?" // Optional direction
                     + "\\s+(?:Street|St\\.?|Road|Rd\\.?|Boulevard|Blvd\\.?|Avenue|Ave\\.?)" // Street type
                     + "\\s*(?:Apt\\s*\\d+[A-Za-z]?)?" // Optional apartment number
                     + "(?:\\s*Unit\\s*\\d+[A-Za-z]?)?$"; // Optional unit number
        return Pattern.matches(regex, theAddress);
    }

    //City, State, Zip code Validate format
    public static boolean validLocation(String theLocation) {
        if (theLocation == null || theLocation.trim().isEmpty()) return false;
        theLocation = theLocation.trim();
        
        // List of valid state abbreviations (uppercase only)
        List<String> statesAbbreviations = Arrays.asList(
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
        );
        
        // Combine state abbreviations into one regex pattern (no case-insensitivity flag)
        String state = String.join("|", statesAbbreviations);
        String regex = "^([A-Za-z\\s']+)" // City name
                     + "\\s*,\\s*" // Comma separator
                     + "(" + state + ")" // Uppercase state abbreviation only
                     + "\\s+" // Space separator
                     + "\\d{5}(-\\d{4})?$"; // ZIP code (5 or 9 digits optional)
                     
        // Use the Pattern.matcher() to handle the matching
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(theLocation);
        
        return matcher.matches();
    }

    //Military Time Validation
    public static boolean validMilitaryTime(String theTime) {
        String regex = "^([01]\\d|2[0-3])" // 00-23 Hours
                     + "([0-5]\\d)$"; // 00-59 Minutes
        return Pattern.matches(regex, theTime);
    }

    //US Currency Validation
    public static boolean validUSCurrency(String theCurrency) {
        String regex = "^-?\\$" // Optional negative sign and '$'
                     + "\\d{1,3}(,\\d{3})*" // Groups of three digits separated by commas
                     + "(\\.\\d{2})?$"; // Optional two decimal places
        return Pattern.matches(regex, theCurrency);
    }

    //URLs Validation
    public static boolean validURL(String theLinks) {
        String regex = "(?i)^(https?://)?" // Optional protocol
                     + "(localhost|[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})" // Domain
                     + "(?::\\d{1,5})?" // Optional port
                     + "(/[^\\s]*)?$"; // Optional path
        return Pattern.matches(regex, theLinks);
    }

    public static boolean validPassword(String thePassword) {
        String regex = "^"
                     + "(?=.*[a-z])" // At least one lowercase letter
                     + "(?=.*[A-Z])" // At least one uppercase letter
                     + "(?=.*\\d)" // At least one number
                     + "(?=.*!)" // Requires exactly one !
                     + "(?!.*(.)\\1{2,})" // Require two duplicate characters
                     + "[A-Za-z\\d!]{10,}$"; // Extra with letters, digits, and !, minimum length of 10
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(thePassword);
        return matcher.matches();
    }

    //word ending in "ion" Validation\
    public static boolean validlengthWord(String word) {
        if (word.equals("ion")) {
            return true; // Special case: "ion" is valid
        }
        if (!word.matches("^[a-zA-Z]+ion$")) {
            return false; // General pattern check
        }
        return word.length() % 2 != 0; // Ensure total length is odd
    }
}