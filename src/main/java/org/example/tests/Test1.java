package org.example.tests;

import org.example.algos.Book;
import org.example.algos.DynamicTable;
import org.example.algos.LinkTable;
import org.example.algos.MyMath;
import org.example.annotations.Author;
import org.example.structure.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

    //@Author(firstName = "Albert", lastName = "Camus")
    private Book b = new Book("L'étranger");

    public static void main(String[] args) {

//        Actor a = new Actor("bg", "Brad", "Pitt", LocalDate.of(1964, 2, 28));
//        org.example.algos.Actor b = new org.example.algos.Actor();
//        Day l = Day.MONDAY;
//        Day m = Day.MONDAY;
//        System.out.println(l.getPriority());
//        Point p = new Point(2, 5);
//        System.out.println(p.x() + ", " + p.y());
//        System.out.println(p.dist());
//        Function<Integer, Integer> somme = x -> x + 5;
//        Function<Integer, Integer> carre = x -> x * x;
//        Function<Integer, Integer> compo1 = somme.andThen(carre).andThen(carre);
//        Function<Integer, Integer> compo2 = somme.compose(carre);
//        System.out.println(compo1.apply(2));
//        System.out.println(compo2.apply(2));
//        DynamicTable<Integer> l = new DynamicTable<>();
        List<Long> l = new ArrayList<>();
        for (long i = 0; i < 1_000_000; i++) {
            l.add(i);
        }
        long start = System.currentTimeMillis();
        List<Long> res = l.stream()
                .map(MyMath::carre)
                .map(x -> x + 5)
                .filter( x -> x % 2 == 0)
                .toList();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Duration : " + duration);
        res = new ArrayList<>(l);
        start = System.currentTimeMillis();
        for (Long i : l) {
            long c = MyMath.carre(i);
            long s = c + 5;
            if (s % 2 == 0) {
                res.add(s);
            }
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("Duration : " + duration);
    }
}
