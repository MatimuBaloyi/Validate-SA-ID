package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidateSaIdTest {

    @Test
    public void shouldReturnTrueForValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // Valid
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085")); // Valid
    }

    @Test
    public void shouldReturnFalseIfTooShort() {
        assertFalse(ValidateSaId.isIdNumberValid("200101480008")); // 12 digits
    }

    @Test
    public void shouldReturnFalseIfTooLong() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000867")); // 14 digits
    }

    @Test
    public void shouldReturnFalseIfContainsNonDigits() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086")); // A is not a digit
    }

    @Test
    public void shouldReturnFalseIfMonthIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2013014800086")); // 13 is not a valid month
    }

    @Test
    public void shouldReturnFalseIfDayIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2001324800086")); // 32 is not a valid day
    }

    @Test
    public void shouldReturnFalseIfCitizenshipDigitIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286")); // '2' is not allowed
    }

    @Test
    public void shouldReturnFalseIfChecksumIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800080")); // last digit is wrong
    }
}
