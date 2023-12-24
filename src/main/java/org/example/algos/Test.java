package org.example.algos;

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

    public static LinkTable<Integer> maxPrimes(int max) {
        //TODO
        return null;
    }

    public static void main(String[] args) {
        LinkTable<Integer> primes = primes(30);
        LinkIterator<Integer> it = primes.getIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
