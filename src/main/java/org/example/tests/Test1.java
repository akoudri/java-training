package org.example.tests;

import org.example.structure.*;

import java.time.LocalDate;

public class Test1 {

    public static void main(String[] args) {
        Actor a = new Actor("bg", "Brad", "Pitt", LocalDate.of(1964, 2, 28));
        org.example.algos.Actor b = new org.example.algos.Actor();
    }

}
