package org.example.tests;

public class Ternary {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int c = a > b ? a : b;
        System.out.println(c);*
        //Equivalent to
        int d;
        if (a > b) {
            d = a;
        } else {
            d = b;
        }
    }

}
