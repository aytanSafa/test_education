package com.infina.test.lesson5.tdd;

import com.infina.test.lesson2.assertions.PhoneValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneNumberValidatorTest {


    PhoneNumberValidator phoneNumberValidator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    void validate() {

        String phoneNumber = "05317006565";
        assertTrue( phoneNumberValidator.test(phoneNumber));

    }

    @Test
    void sendNull(){
        String phoneNumber = null;

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> phoneNumberValidator.test(phoneNumber));

        assertEquals("Phone number cannot be null", ex.getMessage());


    }
}
