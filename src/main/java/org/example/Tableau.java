package org.example;

import java.util.Random;

public class Tableau {

    private int[] values;
    private int size;

    public Tableau(int size, int maxValue) {
        values = new int[size];
        this.size = size;
        Random random = new Random();
        for (int i = 0; i < size; i++)
            values[i] = random.nextInt(maxValue);
    }

    public Tableau(int[] values) {
        this.values = values;
        this.size = values.length;
    }

    public void setValue(int index, int value) {
        if (index >= 0 && index < size) values[index] = value;
    }

    public int getValue(int index) {
        if (index >= 0 && index < size) return values[index];
        return -1; //No value, throw an exception instead
    }

    public void bubblesSort() {
        boolean sorted = false;
        while (sorted == false)
        {
            sorted = true;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    int tmp = values[i + 1];
                    values[i + 1] = values[i];
                    values[i] = tmp;
                    sorted = false;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < values.length; i++) {
            int j = i;
            while (j > 0 && values[j - 1] > values[j]) {
                int tmp = values[j - 1];
                values[j - 1] = values[j];
                values[j] = tmp;
                j--;
            }
        }
    }

    public void quickSort() {
        quickSort(0, values.length - 1);
    }

    private void quickSort(int min, int max) {
        if (min < max) {
            int pivot = partition(min, max);
            quickSort(min, pivot - 1);
            quickSort(pivot + 1, max);
        }
    }

    private int partition(int min, int max) {
        int pivot = values[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            if (values[j] < pivot) {
                i++;
                int tmp = values[i];
                values[i] = values[j];
                values[j] = tmp;
            }
        }
        int tmp = values[i + 1];
        values[i + 1] = values[max];
        values[max] = tmp;
        return i + 1;
    }

    public void display() {
        for (int i = 0; i < Math.min(10, size); i++)
            System.out.print(values[i] + " ");
        if (size > 10 && size < 20) {
            System.out.println("... ");
        } else if (size >= 20) {
            System.out.print("... ");
            for (int i = size - 10; i < size; i++)
                System.out.print(values[i] + " ");
            System.out.println();
        } else {
            System.out.println();
        }
    }
}
