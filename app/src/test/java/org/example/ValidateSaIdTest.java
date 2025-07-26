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

    // Invalid year (YY) part - here we assume all 00-99 valid so this test is just
    // a placeholder
    @Test
    public void shouldReturnTrueIfYearIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    // Invalid month (MM) part - must be between 01 and 12
    @Test
    public void shouldReturnFalseIfMonthIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2099014800086")); // month 99 invalid
        assertFalse(ValidateSaId.isIdNumberValid("2000004800086")); // month 00 invalid
    }

    // Valid month - 01 through 12
    @Test
    public void shouldReturnTrueIfMonthIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // month 01
        assertTrue(ValidateSaId.isIdNumberValid("2012124800086")); // month 12
    }

    // Invalid day (DD) part - must be 01 through 31 (simplified)
    @Test
    public void shouldReturnFalseIfDayIsInvalid() {
        assertFalse(ValidateSaId.isIdNumberValid("2001324800086")); // day 32 invalid
        assertFalse(ValidateSaId.isIdNumberValid("2001004800086")); // day 00 invalid
    }

    // Valid day - 01 through 31
    @Test
    public void shouldReturnTrueIfDayIsValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086")); // day 01
        assertTrue(ValidateSaId.isIdNumberValid("2001314800086")); // day 31
    }
}
