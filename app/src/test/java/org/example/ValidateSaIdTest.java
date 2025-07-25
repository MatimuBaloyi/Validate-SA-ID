package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidateSaIdTest {

    @Test
    public void shouldReturnTrueForValidIdNumbers() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }

    @Test
    public void shouldReturnFalseIfIdNumberIsTooShort() {
        assertFalse(ValidateSaId.isIdNumberValid("20010148000")); // less than 13 digits
    }

    @Test
    public void shouldReturnFalseIfIdNumberIsTooLong() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800086123")); // more than 13 digits
    }

    @Test
    public void shouldReturnFalseIfIdNumberContainsNonNumeric() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086")); // contains 'A'
    }
}
