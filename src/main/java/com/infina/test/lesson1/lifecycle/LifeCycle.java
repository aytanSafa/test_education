package com.infina.test.lesson1.lifecycle;

import org.springframework.stereotype.Component;

public class LifeCycle {


    public String hello(){
        return "Hello World";
    }

    public String hello(String name){
        return "Hello " + name;
    }

}
