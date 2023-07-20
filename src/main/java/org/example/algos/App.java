package org.example.algos;

import java.util.Random;

public class App
{

    public static void main( String[] args )
    {
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
        ImageProcessing processing = new ImageProcessing("https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg", false);
        System.out.println(processing.getDimension().width);
    }
}
