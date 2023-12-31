package org.example.algos;

import static java.lang.Math.*;

public class Test {

    public static LinkTable<Integer> primes(int n) {
        int count = 1;
        int number = 3;
        LinkTable<Integer> res = new LinkTable<>();
        res.add(2);
        LinkIterator<Integer> it;
        boolean dividable = false;
        while (count < n) {
            if (number % 2 == 0) {
                number ++;
                continue;
            }
            it = res.getIterator();
            while (it.hasNext()) {
                int v = it.next();
                if (number % v == 0) {
                    dividable = true;
                    break;
                }
            }
            if (!dividable) {
                res.add(number);
                count ++;
            }
            number ++;
            dividable = false;
        }
        return res;
    }

    public static LinkTable<Long> maxPrimes(long max) {
        long number = 3;
        LinkTable<Long> res = new LinkTable<>();
        res.add(2L);
        LinkIterator<Long> it;
        boolean dividable = false;
        while (number <= max) {
            if (number % 2 == 0) {
                number ++;
                continue;
            }
            it = res.getIterator();
            while (it.hasNext()) {
                long v = it.next();
                if (number % v == 0) {
                    dividable = true;
                    break;
                }
            }
            if (!dividable) {
                res.add(number);
            }
            number ++;
            dividable = false;
        }
        return res;
    }

    public static LinkTable<Long> primeFactors(long number) {
        long max = Double.valueOf(sqrt(number)).longValue();
        LinkTable<Long> primes = maxPrimes(max);
        LinkIterator<Long> it = primes.getIterator();
        LinkTable<Long> factors = new LinkTable<>();
        while (it.hasNext()) {
            long factor = it.next();
            while (number % factor == 0) {
                factors.add(factor);
                number /= factor;
            }
        }
        return factors;
    }

    public static LinkTable<Long> primeFactors2(long number) {
        long max = Double.valueOf(sqrt(number)).longValue();
        LinkTable<Long> factors = new LinkTable<>();
        for (long f = 2; f <= max; f++) {
            while (number % f == 0) {
                factors.add(f);
                number /= f;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LinkTable<Long> primes = primeFactors2(1_000_000_000_000L);
        long duration = System.currentTimeMillis() - start;
        System.out.printf("Prime factors computed in %d ms\n", duration);
        LinkIterator<Long> it = primes.getIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        Table<Integer> t = new LinkTable<>();
        t.add(5);
        t.add(6);
    }
}
