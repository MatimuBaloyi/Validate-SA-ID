package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

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

    // New tests for birthdate extraction
    @Test
    public void shouldExtractCorrectBirthdate() {
        LocalDate bd1 = ValidateSaId.getBirthDate("2001014800086");
        assertEquals(LocalDate.of(2020, 1, 1), bd1);

        LocalDate bd2 = ValidateSaId.getBirthDate("9912315800084");
        assertEquals(LocalDate.of(1999, 12, 31), bd2);
    }

    @Test
    public void shouldReturnNullForInvalidBirthdate() {
        assertNull(ValidateSaId.getBirthDate("2001324800086")); // invalid day 32
        assertNull(ValidateSaId.getBirthDate("2099134800086")); // invalid month 13
    }

    // New tests for gender extraction
    @Test
    public void shouldReturnCorrectGender() {
        assertEquals("Female", ValidateSaId.getGender("2001014800086")); // 4800 < 5000 female
        assertEquals("Male", ValidateSaId.getGender("2001015800086")); // 5800 >= 5000 male
    }
}
