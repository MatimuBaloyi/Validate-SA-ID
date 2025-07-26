package org.example;

public class ValidateSaId {

    public static boolean isIdNumberValid(String idNumber) {
        if (idNumber == null)
            return false;
        if (idNumber.length() != 13)
            return false;
        if (!idNumber.matches("\\d{13}"))
            return false;

        try {
            String yearStr = idNumber.substring(0, 2);
            String monthStr = idNumber.substring(2, 4);
            String dayStr = idNumber.substring(4, 6);
            String genderStr = idNumber.substring(6, 10);
            char citizenshipChar = idNumber.charAt(10);

            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            int gender = Integer.parseInt(genderStr);

            // Year is assumed valid if 00–99 (you can enhance this with century logic
            // later)
            if (year < 0 || year > 99)
                return false;
            if (month < 1 || month > 12)
                return false;
            if (day < 1 || day > 31)
                return false;

            // Gender must be within 0000–9999
            if (gender < 0 || gender > 9999)
                return false;

            // Citizenship must be 0 or 1
            if (citizenshipChar != '0' && citizenshipChar != '1')
                return false;

            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
