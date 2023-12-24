package org.example.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.structure.Homme;
import org.example.structure.Person;

public class App
{

    public static void main( String[] args )
    {
        int[] list = new int[] {1, 9, 4, 6, 5, 4};
        Random rand = new Random();
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextInt(10000);
        }
        int[] y = x.clone();
        Tableau tx = new Tableau(x);
        Tableau ty = new Tableau(y);
        long start = System.currentTimeMillis();
        tx.insertionSort();
        long duration = System.currentTimeMillis() - start;
        tx.display();
        System.out.println(duration);
        start = System.currentTimeMillis();
        ty.quickSort();
        duration = System.currentTimeMillis() - start;
        ty.display();
        System.out.println(duration);
        List<Integer> l = new ArrayList<>();
        l.add(25);
        l.add(32); 
        Person kevin = new Person("Kevin", "Costner", 56);
        Math.sqrt(2.0);
    }

}
