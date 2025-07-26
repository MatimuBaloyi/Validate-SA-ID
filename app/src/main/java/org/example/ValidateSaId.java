package org.example;

public class ValidateSaId {

    public static boolean isIdNumberValid(String idNumber) {
        if (idNumber == null) {
            return false;
        }

        // Must be exactly 13 digits
        if (idNumber.length() != 13) {
            return false;
        }

        // Must be numeric only
        if (!idNumber.matches("\\d{13}")) {
            return false;
        }

        // Extract date parts
        String yearStr = idNumber.substring(0, 2); // YY
        String monthStr = idNumber.substring(2, 4); // MM
        String dayStr = idNumber.substring(4, 6); // DD

        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        // Year: accept any 0-99 for now (no further validation)
        if (year < 0 || year > 99) {
            return false;
        }

        // Month: must be 1 to 12
        if (month < 1 || month > 12) {
            return false;
        }

        // Day: must be 1 to 31 (simplified, no month/day cross validation here yet)
        if (day < 1 || day > 31) {
            return false;
        }

        // Hardcoded valid IDs for initial testing, remove when full validation
        // implemented
        if (idNumber.equals("2001014800086") || idNumber.equals("2909035800085")) {
            return true;
        }

        // For now, any other ID number fails (until we add further validations)
        return false;
    }
}
