package org.example;

public class ValidateSaId {

        public static boolean isIdNumberValid(String idNumber) {
                if (idNumber == null || idNumber.length() != 13 || !idNumber.matches("\\d{13}")) {
                        return false;
                }

                // Validate birth date
                String monthStr = idNumber.substring(2, 4);
                String dayStr = idNumber.substring(4, 6);

                int month = Integer.parseInt(monthStr);
                int day = Integer.parseInt(dayStr);

                if (month < 1 || month > 12)
                        return false;
                if (day < 1 || day > 31)
                        return false;

                // Validate gender digits
                int genderDigits = Integer.parseInt(idNumber.substring(6, 10));
                if (genderDigits < 0 || genderDigits > 9999)
                        return false;

                // Validate citizenship digit
                char citizenship = idNumber.charAt(10);
                if (citizenship != '0' && citizenship != '1')
                        return false;

                // Validate checksum
                return isValidLuhn(idNumber);
        }

        private static boolean isValidLuhn(String idNumber) {
                int sumOdd = 0;
                int sumEven = 0;

                // Step 1: Sum digits in odd positions (1st, 3rd, ..., 11th)
                for (int i = 0; i < 12; i += 2) {
                        sumOdd += Character.getNumericValue(idNumber.charAt(i));
                }

                // Step 2: Concatenate even-positioned digits (2nd, 4th, ..., 12th)
                StringBuilder evenDigits = new StringBuilder();
                for (int i = 1; i < 12; i += 2) {
                        evenDigits.append(idNumber.charAt(i));
                }

                int evenNumber = Integer.parseInt(evenDigits.toString());
                int evenProduct = evenNumber * 2;

                // Step 3: Add digits of the product
                while (evenProduct > 0) {
                        sumEven += evenProduct % 10;
                        evenProduct /= 10;
                }

                // Step 4: Add both sums
                int total = sumOdd + sumEven;

                // Step 5: Calculate check digit
                int checkDigit = (10 - (total % 10)) % 10;

                // Compare with the last digit
                int actualCheckDigit = Character.getNumericValue(idNumber.charAt(12));
                return checkDigit == actualCheckDigit;
        }
}
