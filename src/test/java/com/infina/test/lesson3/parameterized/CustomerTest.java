package com.infina.test.lesson3.parameterized;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    static Customer john;
    static Customer maria;


    @BeforeAll
    static void beforeAll() {
         john = Customer.builder().name("John").age(18).balance(150.30).build();

         maria = Customer.builder().name("Maria").age(18).balance(3.50).build();
    }

    @ParameterizedTest
    @ValueSource(doubles = {3.50, 4.50, 5.50})
    void shouldTransfer(double commission){
        System.out.println(commission);
        Assertions.assertTrue(john.getBalance() > commission);
    }

    @ParameterizedTest
    @ValueSource(doubles = {3.60, 4.50, 5.50})
    void shouldNotTransfer(double commission){
        System.out.println(commission);
        Assertions.assertFalse(maria.getBalance() > commission);
    }



    @ParameterizedTest
    @CsvSource({
            "John,18,150.30",
            "Maria,19.50"
    })
    void isItJohn(String name, int age, double balance){

        assertEquals(john.getName(),name);
        assertEquals(john.getAge(),age);
        assertEquals(john.getBalance(),balance);
    }


    @ParameterizedTest
    @MethodSource("getArgs")
    void isItJohnByMethod(String name, int age, double balance){

        assertEquals(john.getName(),name);
        assertEquals(john.getAge(),age);
        assertEquals(john.getBalance(),balance);
    }


    static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.arguments("John",18,150.30));
    }


}
