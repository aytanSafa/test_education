package com.infina.test.lesson1.lifecycle;


import org.junit.jupiter.api.*;

public class LifeCycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Tüm testlerden once calisirim");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Her Testten once calisirim");
    }

    @Test
    void helloWorld() {
     LifeCycle lifeCycle = new LifeCycle();
     System.out.println(lifeCycle.hello());
    }

    @Test
    void helloName() {
        LifeCycle lifeCycle = new LifeCycle();
        System.out.println(lifeCycle.hello("INFINA"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Her testten sonra calisirim");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tum testlerden sonra calisirim");
    }
}
