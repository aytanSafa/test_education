package com.infina.test.lesson2.assertions;

import org.springframework.stereotype.Component;

@Component
public class PhoneValidator {

    public boolean verify(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
        return true;
    }




}
