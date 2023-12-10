package org.example.algos;

import org.example.exceptions.NullValueException;

import java.util.Random;

public class DynamicTable {

    private int length = 0;
    private int capacity = 50;
    private Integer[] array = new Integer[capacity];

    public void add(int a) {
        if (length >= capacity) {
            Integer[] narray = new Integer[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                narray[i] = array[i];
            }
            capacity *= 2;
            array = narray;
        }
        array[length] = a;
        length ++;
    }

    public void remove(int idx) {
        array[idx] = null;
        length --;
    }

    public void setValue(int idx, int value) {
        array[idx] = value;
    }

    public int getValue(int idx) throws NullValueException {
        if (array[idx] == null) throw new NullValueException();
        return array[idx];
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        DynamicTable t = new DynamicTable();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            t.add(r.nextInt(100));
        }
        try {
            for (int i = 0; i < t.getLength(); i++) {
                System.out.print(t.getValue(i) + " ");
            }
            System.out.println();
        } catch (NullValueException e) {
            System.out.println(e.getMessage());
        }
    }

}
