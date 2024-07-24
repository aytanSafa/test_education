package com.infina.test.lesson2.assertions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {

    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    @DisplayName("True Condition")
    void validateShouldTrue() {
        assertTrue(phoneValidator.verify("0123456789"));

    }

    @Test
    @DisplayName("Null Condition")
    void sendNullThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> phoneValidator.verify(null));
        assertEquals("Phone number cannot be null or empty",ex.getMessage());
    }

    @Test
    @DisplayName("Empty Condition")
    void sendEmptyThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> phoneValidator.verify(""));
        assertEquals("Phone number cannot be null or empty",ex.getMessage());
    }


    @Test
    @DisplayName("Wrong condition")
    void sendWrongDigitThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> phoneValidator.verify("1234"));
        assertEquals("Phone number must be 10 digits",ex.getMessage());
    }
}
