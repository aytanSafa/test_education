package com.infina.test.lesson3.parameterized;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private String name;
    private int age;
    private double balance;
}
