package com.infina.test.lesson5.tdd;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {

        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number cannot be null");

        return true;
    }
}
