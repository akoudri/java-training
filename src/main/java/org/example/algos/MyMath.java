package org.example.algos;

public class MyMath {

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

}
