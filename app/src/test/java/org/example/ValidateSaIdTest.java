package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidateSaIdTest {

    // Valid known IDs - should return true
    @Test
    public void shouldReturnTrueForValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    // Too short - less than 13 characters
    @Test
    public void shouldReturnFalseIfIdNumberIsTooShort() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000"));
    }

    // Too long - more than 13 characters
    @Test
    public void shouldReturnFalseIfIdNumberIsTooLong() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800086123"));
    }

    // Non-numeric characters
    @Test
    public void shouldReturnFalseIfIdNumberContainsNonNumeric() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"));
    }

    // Year validation placeholder (00–99 valid)
    @Test
    public void shouldReturnTrueIfYearIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    // Invalid month (must be 01–12)
    @Test
    public void shouldReturnFalseIfMonthIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2099014800086")); // 99 = invalid
        assertFalse(ValidateSaId.isIdNumberValid("2000004800086")); // 00 = invalid
    }

    // Valid month (01–12)
    @Test
    public void shouldReturnTrueIfMonthIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2012124800086"));
    }

    // Invalid day (must be 01–31)
    @Test
    public void shouldReturnFalseIfDayIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2001324800086")); // 32 = invalid
        assertFalse(ValidateSaId.isIdNumberValid("2001004800086")); // 00 = invalid
    }

    // Valid day
    @Test
    public void shouldReturnTrueIfDayIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // 01
        assertTrue(ValidateSaId.isIdNumberValid("2001314800086")); // 31
    }

    // Valid female gender digits
    @Test
    public void shouldReturnTrueForValidFemaleGenderDigits() {
        assertTrue(ValidateSaId.isIdNumberValid("2001010000086")); // 0000
        assertTrue(ValidateSaId.isIdNumberValid("2909034999085")); // 4999
    }

    // Valid male gender digits
    @Test
    public void shouldReturnTrueForValidMaleGenderDigits() {
        assertTrue(ValidateSaId.isIdNumberValid("2001015000086")); // 5000
        assertTrue(ValidateSaId.isIdNumberValid("2909039999085")); // 9999
    }

    // Invalid gender digits (non-numeric)
    @Test
    public void shouldReturnFalseIfGenderDigitsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("200101abcd086")); // non-numeric
    }

    // Valid citizenship digit
    @Test
    public void shouldReturnTrueForValidCitizenshipDigit() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // citizen (0)
        assertTrue(ValidateSaId.isIdNumberValid("2909035800185")); // permanent resident (1)
    }

    // Invalid citizenship digit
    @Test
    public void shouldReturnFalseForInvalidCitizenshipDigit() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286")); // 2 = invalid
        assertFalse(ValidateSaId.isIdNumberValid("2909035800385")); // 3 = invalid
    }
}
