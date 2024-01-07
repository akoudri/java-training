package org.example.algos;

import java.util.function.Function;

public class MyMath {

    public static long compo(long x) {
        long s = somme(x);
        return carre(somme(x));
    }

    public static long somme(long x) {
        return x + 5;
    }

    public static long carre(long x) {
        return x * x;
    }

    public static long composition(long x) {
        return carre(somme(x));
    }

    public static double abs(double x) {
        if (x >= 0) return x;
        else return -1 * x;
    }

    public static int abs(int x) {
        if (x >= 0) return x;
        else return -1 * x;
    }

    public static double racine(double x) {
        return racine(x, 1e-12);
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

    public static int fact2(int x) {
        if (x <= 1) {
            return x;
        }
        return x * fact2(x-1);
    }

    public static LinkTable printPrimeNumbers(int num) {
        //Générer une liste pour stocker les num premiers nombres premiers
        return null;
    }

    public static int n() {
        return 5;
    }

    public static int m() {
        return 3 * n();
    }

    public static int l() {
        return 2 * m();
    }
    public static void main(String[] args) {
        Function<Long, Long> somme = MyMath::somme;
        Function<Long, Long> carre = MyMath::carre;
        Function<Long, Long> composition = somme.andThen(carre);
        System.out.println(composition.apply(5L));
    }

}
