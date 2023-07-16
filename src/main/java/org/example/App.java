package org.example;

import org.example.Roue;
import org.example.Voiture;

import java.util.Random;

public class App
{
    public static void losange(int base, int spaces)
    {
        int mid = base / 2 + 1;
        for (int i = 1; i <= base; i++)
        {
            int nbSpaces = mid - i;
            if (nbSpaces < 0) nbSpaces *= -1;
            int nbChars = base - 2 * nbSpaces;
            for (int j = 0; j < spaces; j++) System.out.print(" ");
            for (int j = 0; j < nbSpaces; j++) System.out.print(" ");
            for (int j = 0; j < nbChars; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static int carre(int x) {
        return x * x;
    }

    public static double abs(double x) {
        if (x >= 0) return x;
        else return -1 * x;
    }

    public static double racine(double x, double error) {
        double min = 0.0;
        double max = x;
        double mid = x / 2;
        double carre = mid * mid;
        int counter = 0;
        while (max - min > error) {
            if (carre > x) max = mid;
            else if (carre < x) min = mid;
            else break;
            mid = (max + min) / 2;
            carre = mid * mid;
            counter++;
        }
        System.out.println("Nombre de boucles: " + counter);
        return mid;
    }

    public static double racineNewton(double x, double error)
    {
        double res = x / 2;
        int counter = 0;
        while(true) {
            double approximation = (res + x / res) / 2;
            if (abs(approximation - res) < error) break;
            res = approximation;
            counter++;
        }
        System.out.println("Nombre de boucles: " + counter);
        return res;
    }

    public static long fibo(long n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        long x = 1;
        long y = 2;
        long somme = 0;
        for(int i = 3; i <= n; i++)
        {
            somme = x + y;
            x = y;
            y = somme;
        }
        int i = 12;
        System.out.println(i);
        return somme;
    }

    public static int fact(int x) {
        int res = 1;
        for (int i = 1; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    public static void triBulles(int[] tab) {
        boolean sorted = false;
        while (sorted == false)
        {
            sorted = true;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    int tmp = tab[i + 1];
                    tab[i + 1] = tab[i];
                    tab[i] = tmp;
                    sorted = false;
                }
            }
        }
    }

    public static void insertionSort(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int j = i;
            while (j > 0 && tab[j - 1] > tab[j]) {
                int tmp = tab[j - 1];
                tab[j - 1] = tab[j];
                tab[j] = tmp;
                j--;
            }
        }
    }

    public static void quickSort(int[] tab) {
        quickSort(tab, 0, tab.length - 1);
    }

    public static void quickSort(int[] tab, int min, int max) {
        if (min < max) {
            int pivot = partition(tab, min, max);
            quickSort(tab, min, pivot - 1);
            quickSort(tab, pivot + 1, max);
        }
    }

    public static int partition(int[] tab, int min, int max) {
        int pivot = tab[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            if (tab[j] < pivot) {
                i++;
                int tmp = tab[i];
                tab[i] = tab[j];
                tab[j] = tmp;
            }
        }
        int tmp = tab[i + 1];
        tab[i + 1] = tab[max];
        tab[max] = tmp;
        return i + 1;
    }

    public static void display(int[] tab) {
        for (int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");
        System.out.println();
    }

    public static void main( String[] args )
    {
        Random rand = new Random();
        int[] x = new int[100_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextInt(100);
        }
        int[] y = x.clone();
        long start = System.currentTimeMillis();
        insertionSort(x);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration);
        start = System.currentTimeMillis();
        quickSort(y);
        duration = System.currentTimeMillis() - start;
        System.out.println(duration);
    }
}
